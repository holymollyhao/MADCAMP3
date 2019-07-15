# import
from bs4 import BeautifulSoup
from urllib.request import urlopen
from pymongo import MongoClient
from datetime import datetime
import json
import sys

ans=[]
url = urlopen("https://bds.bablabs.com/restaurants?campus_id=JEnfpqCUuR")
bs = BeautifulSoup(url, 'html.parser')
body = bs.body

t=sys.argv

target = body.find(class_="col-12 col-sm-10 col-md-8 col-lg-6").find_all(class_="restaurant-item")
for i in target:
    ans.append(i.find(class_="card card-menu").find(class_="card-title").text)
x={
    "동측식당" : {
        "메뉴" : ans[0],
        "start1" : "08:00",
        "end1" : "10:00",
        "start2" : "11:30",
        "end2" : "13:00",
        "start3" : "17:30",
        "end3" : "19:30"
    },
    "서측식당" : {
        "메뉴" : ans[1],
        "start1" : "08:00",
        "end1" : "10:00",
        "start2" : "11:30",
        "end2" : "13:00",
        "start3" : "17:30",
        "end3" : "19:00"
    },
    "카이마루" : {
        "메뉴" : ans[2],
        "start1" : "08:00",
        "end1" : "09:30",
        "start2" : "11:30",
        "end2" : "13:30",
        "start3" : "17:30",
        "end3" : "19:30"
    },
    "교수회관" : {
        "메뉴" : ans[3],
        "start1" : "08:00",
        "end1" : "08:00",
        "start2" : "11:20",
        "end2" : "13:00",
        "start3" : "17:30",
        "end3" : "18:30"
    }
}
print(json.dumps(x,ensure_ascii=False))


