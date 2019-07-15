const express = require('express');
const bodyParser = require('body-parser');
const app = express();
var firebase = require('firebase-admin');
var serviceAccount=require('./emily-puowgc-firebase-adminsdk-pburh-6af26fe3a7.json');
firebase.initializeApp({
    credential: firebase.credential.cert(serviceAccount),
    databaseURL: "https://emily-puowgc.firebaseio.com"
  });

var db=firebase.database();

app.use(bodyParser.urlencoded({extended:true}))

app.use(bodyParser.json())
let {PythonShell} = require('python-shell')
var result=[];
PythonShell.run('bopdaesang_crawl.py', {args:0}, function (err, results) {
    if (err) throw err;
    console.log(results)
    db.ref('foods/').set(JSON.parse(results));
    
});

 
app.post('/', function (req, res) {
  console.log("running");
  const intent=req.body["queryResult"]["intent"]["displayName"];
  console.log(intent);
  if(intent=="Find Locations via name"){
    const shops=req.body["queryResult"]["parameters"]["shops"];
    var ref = db.ref('buildings/')
    ref.on('child_added', function(data){
        if(shops==data.key){
            console.log(data.val());
            const val = data.val()["building"];
            res.json({"fulfillmentText":val+"건물에 위치해 있습니다"});
        }
    })
  }
  if(intent=="specificlocation"){
    const shops=req.body["queryResult"]["parameters"]["shops"];
    var ref = db.ref('buildings/')
    ref.on('child_added', function(data){
        if(shops==data.key){
            console.log(data.val());
            const val = data.val()["building"];
            res.json({"fulfillmentText":val+"입니다"});
        }
    })
  }
  if(intent=="openclosetime"|| intent=="Find Locations via time"){
    const shops=req.body["queryResult"]["parameters"]["shops"];
    var ref = db.ref('buildings/')
    ref.on('child_added', function(data){
        if(shops==data.key){
            console.log(data.val());
            const val1 = data.val()["open"];
            const val2 = data.val()["close"];
            d=new Date();
            if(tomin(gettime(d))<tomin(val1) && tomin(val1)-tomin(gettime(d))<=30){
                res.json({"fulfillmentText":shops+"의 영업시간은 "+val1+"부터 "+val2+"입니다. 곧 오픈할 예정입니다!"});
            }else if(tomin(gettime(d))>tomin(val2) && -tomin(val2)+tomin(gettime(d))<=30){
                res.json({"fulfillmentText":shops+"의 영업시간은 "+val1+"부터 "+val2+"입니다. 방금 닫았어요 ㅠㅜ!"});
            }else if(tomin(gettime(d))<tomin(val2) && tomin(val1)<tomin(gettime(d))){
                res.json({"fulfillmentText":shops+"의 영업시간은 "+val1+"부터 "+val2+"입니다. 지금 영업 중입니다!"});
            }else{
                res.json({"fulfillmentText":shops+"의 영업시간은 "+val1+"부터 "+val2+"입니다. 영업 중이 아닙니다..."});
            }
        }
    })
  }
  if(intent=="Find Locations summary"){
    const shops=req.body["queryResult"]["parameters"]["shops"];
    var ref = db.ref('buildings/')
    ref.on('child_added', function(data){
        if(shops==data.key){
            console.log(data.val());
            const val1 = data.val()["info"];
            res.json({"fulfillmentText":data.key+"에서는 "+val1});
        }
    })
  }
  if(intent=="Find Locations via wants"){
    const wants=req.body["queryResult"]["parameters"]["Wants"];
    var arr="";
    var cnt=0;
    var ref = db.ref('buildings/');
    ref.once("value")
        .then(function(snapshot) {
            snapshot.forEach(function(childSnapshot){
                if(childSnapshot.val()["category"]==wants){
                    console.log(childSnapshot.key);
                    arr=arr+childSnapshot.key.toString()+", ";
                    cnt++
                }
            })
            if (cnt>1){
                res.json({"fulfillmentText": "교내에는 "+arr+"가 있습니다. 어느 건물에 있는지 궁금하시다면, 말씀해주시면 됩니다."});
            }else if(cnt==1){
                res.json({"fulfillmentText": "교내에는 "+arr+"가 있습니다"});
            }
            else{
                res.json({"fulfillmentText": "교내에는 본 시설은 없는것 같습니다 ㅠㅜ"});
            }
        });
    
  }
  if(intent=="Professors"){
    const prof=req.body["queryResult"]["parameters"]["ProfessorName"];
    const profwants=req.body["queryResult"]["parameters"]["profwants"];
    var ref = db.ref('professors/')
    ref.on('child_added', function(data){
        console.log(prof);
        console.log(profwants);
        if(prof==data.key){
            console.log(data.val());
            const val1 = data.val()[profwants];
            if(profwants=="후기"){
                res.json({"fulfillmentText":data.key+" 교수님의 "+profwants+": "+val1[0]});
            }else{
                res.json({"fulfillmentText":data.key+" 교수님의 "+profwants+": "+val1});
            }
        }
    })
  }
  if(intent=="Consultant"){
    const major=req.body["queryResult"]["parameters"]["Major-consultant"];
    var ref = db.ref('consult/'+major+"/");
    console.log(major)
    var arr="";
    var cnt=0;
    ref.once("value")
        .then(function(snapshot) {
            snapshot.forEach(function(childSnapshot){
                arr=arr+childSnapshot.val()["name"].toString()+", ";
                cnt++;
            })
            console.log(arr);
            res.json({"fulfillmentText":arr+"등의 상담 선생님들이 있습니다. 더 알아보고 싶은 상담 선생님이 있다면, 말씀해 주세요"});

            
    })
  }
  if(intent=="consultant email"){
    const major=req.body["queryResult"]["parameters"]["major"];
    const name=req.body["queryResult"]["parameters"]["ProfessorName"];
    var ref = db.ref('consult/'+major+"/");
    console.log(major)
    var arr="";
    var cnt=0;
    ref.once("value")
        .then(function(snapshot) {
            snapshot.forEach(function(childSnapshot){
                if(name==childSnapshot.val()["name"]){
                    console.log(name);
                    console.log(childSnapshot.val()["email"])
                    res.json({"fulfillmentText":name+" 상담 선생님의 이메일은 "+childSnapshot.val()["email"]});

                }
            })

    })
  }
  if(intent=="consultant summary"){
    const major=req.body["queryResult"]["parameters"]["major"];
    const name=req.body["queryResult"]["parameters"]["ProfessorName"];
    var ref = db.ref('consult/'+major+"/");
    console.log(major)
    var arr="";
    var cnt=0;
    ref.once("value")
        .then(function(snapshot) {
            snapshot.forEach(function(childSnapshot){
                if(name==childSnapshot.val()["name"]){
                    console.log(name);
                    console.log(childSnapshot.val()["email"])
                    res.json({"fulfillmentText":name+" 상담 선생님은 "+childSnapshot.val()["interest"]+"관련 상담을 진행하시는 상담사이십니다. "+name+" 선생님의 이메일은: "+childSnapshot.val()["email"]+" 입니다"});

                }
            })     
    })
  }
  if(intent=="foodlocations"){
    const clubs=req.body["queryResult"]["parameters"]["foods"];
    var ref = db.ref('buildings/')
    ref.on('child_added', function(data){
        if(clubs==data.key){
            console.log(data.val());
            const val1 = data.val()["position"];
            res.json({"fulfillmentText":data.key+"는 "+val1+"에 위치해 있습니다."});
        }
    })
  }
  if(intent=="Clubs Location"||intent=="clubslocation"){
    const clubs=req.body["queryResult"]["parameters"]["clubs"];
    var ref = db.ref('clubs/')
    ref.on('child_added', function(data){
        if(clubs==data.key){
            console.log(data.val());
            const val1 = data.val()["position"];
            if(val1==""){
                res.json({"fulfillmentText":data.key+"는 동방이 없습니다 ㅠㅜ..."});
            }else{
                res.json({"fulfillmentText":data.key+"는 "+val1+"에 위치해 있습니다."});
            }
        }
    })
  }
  if(intent=="Clubs Summary"||intent=="clubssummary"){
    const clubs=req.body["queryResult"]["parameters"]["clubs"];
    var ref = db.ref('clubs/')
    ref.on('child_added', function(data){
        if(clubs==data.key){
            console.log(data.val());
            const val1 = data.val()["category"];
            res.json({"fulfillmentText":data.key+"는 "+val1+" 동아리 입니다"});

        }
    })
  }
  if(intent=="Find Food"||intent=="another"){
    const restaurants=req.body["queryResult"]["parameters"]["foods"];
    var ref = db.ref('foods/')
    ref.on('child_added', function(data){
        if(restaurants==data.key){
            console.log(data.val());
            if(data.val()=="-운영없음-"){
                res.json({"fulfillmentText":"오늘은 영업하지 않습니다 ㅠㅜ"});
            }else{
                res.json({"fulfillmentText":data.val()});
            }
        }
    })
    }
  if(intent=="Contacts"){
        const where=req.body["queryResult"]["parameters"]["contacts"];
        var ref = db.ref('contacts/')
        var cnt=0
        try{
            ref.on('child_added', function(data){
                if(where==data.key){
                    console.log(data.val()["number"]);
                    cnt=1;
                    res.json({"fulfillmentText": where+"의 전화번호는 02-958-"+data.val()["number"]+" 입니다"});
                }
            })

        }catch(err){
            res.json({"fulfillmentText": where+"의 전화번호를 찾을 수 없습니다"});
        }
        
    }
    if(intent=="timeleft"|| intent=="Daysleft"){
        var ref = db.ref('when/')
        var cnt=0
        var today = new Date();
        const when=req.body["queryResult"]["parameters"]["when"];
        today= new Date(2000, today.getMonth()+1, today.getDate());
        ref.once("value")
            .then(function(snapshot) {
                snapshot.forEach(function(childSnapshot){
                    if(when==childSnapshot.key){
                        console.log("foundit!")
                        start=childSnapshot.val()["start"].split(".");
                        end=childSnapshot.val()["end"].split(".");
                        startsat=new Date(2000,start[0],start[1]);
                        endsat=new Date(2000, end[0], end[1]);
                    }
                })
                console.log(when)
                if(startsat<=today && today<=endsat){
                    diff=(parseFloat(endsat-today)/86400000);
                    res.json({"fulfillmentText": when+" 기간이 끝날때 까지 "+ "D-"+diff+"일 남았어요!"});
                }else if(today<startsat){
                    diff=((startsat-today)/86400000);
                    console.log(startsat-today)
                    console.log(diff);
                    console.log(startsat.getMonth());
                    console.log(startsat.getDate());
                    console.log(today.getMonth());
                    console.log(today.getDate());
                    res.json({"fulfillmentText": when+" 기간이 시작할 때까지 "+ "D-"+diff+"일 남았어요!"});
                }else{
                    res.json({"fulfillmentText": when+" 기간은 이미 지났어요..."});
                }
                   
            })
    }
    if(intent=="Whats coming up"){
        var ref = db.ref('when/')
        var cnt=0
        var today = new Date();
        var arr1="";
        var arr2="";
        today= new Date(2000, today.getMonth()+1, today.getDate());
        ref.once("value")
            .then(function(snapshot) {
                snapshot.forEach(function(childSnapshot){
                    start=childSnapshot.val()["start"].split(".");
                    end=childSnapshot.val()["end"].split(".");
                    startsat=new Date(2000,start[0],start[1]);
                    endsat=new Date(2000, end[0], end[1]);
                    if(startsat<=today && today<=endsat){
                        arr1=arr1+childSnapshot.key+", ";
                    }else if(today<startsat && (startsat-today)<86400000*14){
                        arr2=arr2+childSnapshot.key+", ";
                    }
                })
                if (arr1.length==0 && arr2.length==0){
                    res.json({"fulfillmentText": "특별한 일정이 없습니다!"});  
                }else if(arr1.length==0){
                    res.json({"fulfillmentText": "곧 "+arr2+"들이 있을 예정입니다"})
                }else if(arr2.length==0){
                    res.json({"fulfillmentText": "현재 "+arr1+"기간입니다"})
                }else{
                    res.json({"fulfillmentText": "현재 "+arr1+" 기간이고, 곧 "+arr2+"들이 있을 예정입니다"}); 
                }
                   
            })
    }
    if(intent=="When sths coming"){
        const when=req.body["queryResult"]["parameters"]["when"];
        var ref = db.ref('when/')
        var cnt=0
        var today = new Date();
        ref.once("value")
            .then(function(snapshot) {
                snapshot.forEach(function(childSnapshot){
                    if(childSnapshot.key==when){
                        start=childSnapshot.val()["start"];
                        end=childSnapshot.val()["end"];
                        if(start==end){
                            res.json({"fulfillmentText": when+"은 "+start+"일 입니다"});
                        }else{
                            res.json({"fulfillmentText": when+" 기간은 "+start+"일 부터 "+end+"일 까지 입니다"}); 
                        }
                    }
                })      
            })  
    }
    if(intent=="Subjects info via professor"){
        console.log("running")
        const coursename=req.body["queryResult"]["parameters"]["SubjectName"];
        const prof=req.body["queryResult"]["parameters"]["ProfessorName"];
        var ref=db.ref('subjects/'+coursename+"/교수별 후기/"+prof);
        ref.once("value")
            .then(function(snapshot2){
                    res.json({"fulfillmentText": coursename+" 후기: "+snapshot2.val()["0"]});
            })
    }
    if(intent=="Subjects info"){
        const coursename=req.body["queryResult"]["parameters"]["SubjectName"];
        const wants=req.body["queryResult"]["parameters"]["SubjectsWants"];
        var arr="";
        var cnt=0;
        var ref = db.ref('subjects/');
        ref.once("value")
            .then(function(snapshot) {
                snapshot.forEach(function(childSnapshot){
                    if(childSnapshot.key==coursename){
                        if(wants=="담당 교수"){
                            var cnt=0;
                            var ref2=db.ref('subjects/'+coursename+"/"+wants)
                            ref2.once("value")
                                .then(function(snapshot2){
                                    snapshot2.forEach(function(childSnapshot2){
                                        arr=arr+childSnapshot2.val()+", "
                                        cnt=cnt+1
                                    })
                                    if(cnt==1){
                                        res.json({"fulfillmentText": coursename+"은/는 "+arr+"교수님이 담당하고 계십니다"}); 
                                    }else{
                                        res.json({"fulfillmentText": coursename+"은/는 "+arr+"등의 교수님들이 담당하고 계십니다"});
                                    }

                                })

                        }else if(wants=="전체 후기"){
                            console.log("sibaloma")
                            var ref2=db.ref('subjects/'+coursename+"/"+wants)
                            ref2.once("value")
                                .then(function(snapshot2){
                                    console.log(snapshot2)
                                    res.json({"fulfillmentText": coursename+" 후기: "+snapshot2.val()["0"]+" 더 많은 후기를 위해서는 "+childSnapshot.val()["OTL 주소"]+"를 방문해 주세요!"});
                                })
                        }else{
                            res.json({"fulfillmentText": coursename+"의 "+wants+": "+childSnapshot.val()[wants]});
                        }
                        
                    }
                })
            });
        
    }

    

    

})
function tomin(start) {
    start = start.split(":");
    hours=parseInt(start[0]);
    minutes=parseInt(start[1]);
    return hours*60+minutes;
}
function gettime(date){
    if(date.getMinutes().toString().length==1){
        return (date.getHours().toString()+":"+"0"+date.getMinutes().toString())
    }
    return (date.getHours()+":"+date.getMinutes())
}


app.listen(3000, function () {
    console.log(tomin("08:00"))
    console.log('Example app listening on port 3000!');
});
