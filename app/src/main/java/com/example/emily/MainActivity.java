package com.example.emily;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity {
    SimpleDateFormat format1 = new SimpleDateFormat("a hh시 mm분");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent real = getIntent();
        String response = real.getStringExtra("version");
        RelativeLayout relativeLayout = findViewById(R.id.main);
        LinearLayout relate = findViewById(R.id.scroll);

        final ScrollView realscroll = findViewById(R.id.realscroll);
        realscroll.post(new Runnable() {
            @Override
            public void run() {
                realscroll.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });


        switch (response){
            case "1":
                RelativeLayout layout31 = findViewById(R.id.main_second);                           //고객 답변 적기
                layout31.setVisibility(VISIBLE);
                TextView request31 = (TextView) layout31.findViewById(R.id.request);
                request31.setText("오늘 학식은 뭐야?");
                TextView time31 = (TextView) layout31.findViewById(R.id.time);
                setTime(time31);

                Handler delayHandler = new Handler();
                delayHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        RelativeLayout layout32 = findViewById(R.id.main_third);                    //Emily 답변 적기
                        layout32.setVisibility(VISIBLE);

                        TextView text232 = (TextView) layout32.findViewById(R.id.text3);
                        text232.setText("해당 식당을 골라주세요!");

                        TextView el = layout32.findViewById(R.id.time4);
                        setTime(el);

                        Button button432 = layout32.findViewById(R.id.button4);
                        button432.setText("카이마루");
                        button432.setOnClickListener(new Button.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                RelativeLayout layout331 = findViewById(R.id.main_fourth);
                                layout331.setVisibility(VISIBLE);

                                TextView request331 = (TextView) layout331.findViewById(R.id.request2);
                                request331.setText("카이마루 알려줘");

                                TextView text331 = (TextView) layout331.findViewById(R.id.time2);
                                setTime(text331);

                                Handler delayHandler = new Handler();
                                delayHandler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        RelativeLayout layout3311 = findViewById(R.id.main_fifth);
                                        layout3311.setVisibility(VISIBLE);

                                        TextView textView3311 = layout3311.findViewById(R.id.request1);
                                        textView3311.setText("지금 시간 기준으로는 \n" +"쌀밥&잡곡밥(\\ 600/800)\n" +
                                                "감자미역국(\\ 600)\n" +
                                                "닭살매콤볶음(\\ 800/1700)\n" +
                                                "고기두부적(\\ 1000)\n" +
                                                "메추리알장조림(\\ 600)\n" +
                                                "미니함박&매콤소스(\\ 800)\n" +
                                                "두부톳나물무침(\\ 600)\n" +
                                                "열무겉절이(\\400 )\n" +
                                                "연두부찜(\\ 500)\n" +
                                                "도시락김(\\ 200)\n" +
                                                "김치(\\ 300)\n" +
                                                "양배추샐러드(\\ 500)\n" +
                                                "콘샐러드(\\ 600)\n" +
                                                "황도(\\ 600)\n" +
                                                "★일품메뉴★\n" +
                                                "소불고기야채볶음밥&계란후라이&우동국물(\\ 4000)이렇게 있습니다.");

                                        TextView time23311 = layout3311.findViewById(R.id.time1);
                                        setTime(time23311);
                                        Handler delayHandler = new Handler();
                                        delayHandler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                RelativeLayout layout34 = findViewById(R.id.main_sixth);
                                                layout34.setVisibility(VISIBLE);

                                                TextView textView314 = layout34.findViewById(R.id.request3);
                                                textView314.setText("이외에 더 질문할 것이 더 있으면 이 톡을 눌러 Emily와 대화해보세요!");

                                                TextView tex2t = layout34.findViewById(R.id.time3);
                                                setTime(tex2t);
                                                layout34.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View view) {
                                                        Intent intent = new Intent(getApplicationContext(),chat.class);
                                                        startActivity(intent);
                                                    }
                                                });
                                            }
                                        }, 300);

                                    }
                                }, 500);

                            }
                        });


                        Button button2 = layout32.findViewById(R.id.button5);
                        button2.setText("서맛골");
                        button2.setOnClickListener(new Button.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                RelativeLayout layout332 = findViewById(R.id.main_fourth);
                                layout332.setVisibility(VISIBLE);

                                TextView textview = (TextView) layout332.findViewById(R.id.request2);
                                textview.setText("서맛골 알려줘");

                                TextView textview2 = (TextView) layout332.findViewById(R.id.time2);
                                setTime(textview2);

                                Handler delayHandler = new Handler();
                                delayHandler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        RelativeLayout layout3321 = findViewById(R.id.main_fifth);
                                        layout3321.setVisibility(VISIBLE);

                                        TextView textView3311 = layout3321.findViewById(R.id.request1);
                                        textView3311.setText("지금 시간 기준으로\n(한식)" +
                                                "쌀밥\n" +
                                                "어묵김치국\n" +
                                                "돈육간장볶음\n" +
                                                "고구마맛탕\n" +
                                                "콩자반\n" +
                                                "깍두기\n" +
                                                "야채샐러드\n" +
                                                "\n" +
                                                "(일품)\\4,500\n" +
                                                "닭갈비비빔밥*후라이\n" +
                                                "팽이버섯장국\n" +
                                                "꽈배기\n" +
                                                "반달단무지\n" +
                                                "요구르트\n이렇게 있습니다!");

                                        TextView textview = layout3321.findViewById(R.id.time1);
                                        setTime(textview);
                                        Handler delayHandler = new Handler();
                                        delayHandler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                RelativeLayout layout35 = findViewById(R.id.main_sixth);
                                                layout35.setVisibility(VISIBLE);

                                                TextView textVi1ew33244 = layout35.findViewById(R.id.request3);
                                                textVi1ew33244.setText("이외에 더 질문할 것이 더 있으면 이 톡을 눌러 Emily와 대화해보세요!");

                                                TextView tex13t = layout35.findViewById(R.id.time3);
                                                setTime(tex13t);
                                                layout35.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View view) {
                                                        Intent intent = new Intent(getApplicationContext(),chat.class);
                                                        startActivity(intent);
                                                    }
                                                });
                                            }
                                        }, 300);

                                    }
                                }, 2000);
                            }
                        });
                        Button button3 = layout32.findViewById(R.id.button6);
                        button3.setText("동맛골");
                        button3.setOnClickListener(new Button.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                RelativeLayout layout333 = findViewById(R.id.main_fourth);
                                layout333.setVisibility(VISIBLE);

                                TextView textview = (TextView) layout333.findViewById(R.id.request2);
                                textview.setText("동맛골 알려줘");

                                TextView textview2 = (TextView) layout333.findViewById(R.id.time2);
                                setTime(textview2);

                                Handler delayHandler = new Handler();
                                delayHandler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        RelativeLayout layout3331 = findViewById(R.id.main_fifth);
                                        layout3331.setVisibility(VISIBLE);

                                        TextView textView3311 = layout3331.findViewById(R.id.request1);
                                        textView3311.setText("지금 시간 기준으로 \n <Cafeteria>\t\n" +
                                                "흑미밥\t600 \n" +
                                                "오곡밥\t900 \n" +
                                                "사골파국\t600 \n" +
                                                "소불고기야채볶음\t2,500 \n" +
                                                "닭살굴소스볶음\t1,600 \n" +
                                                "닭살굴소스볶음(소)\t800 \n" +
                                                "새우까스\t900 \n" +
                                                "순대깐풍\t1,500 \n" +
                                                "두부구이\t600 \n" +
                                                "감자버터구이\t700 \n" +
                                                "무나물\t400 \n" +
                                                "도토리묵부추무침\t600 \n" +
                                                "참나물겉절이\t600 \n" +
                                                "실곤약초무침\t500 \n" +
                                                "깍두기\t300 \n" +
                                                "볶음김치\t500 \n" +
                                                "양반김\t200 \n" +
                                                "(비건)그린샐러드\t600 \n" +
                                                "(비건)콥샐러드\t1,600 \n" +
                                                "컵과일\t700 \n" +
                                                "냉쫄면\t1,100 \n" +
                                                "하이라이스소스\t800 \n" +
                                                "3구세트\t1,100 \n" +
                                                "\n" +
                                                "\n" +
                                                "<라이스코너> 4,000원\t\n" +
                                                "돈까스오므라이스\t\n" +
                                                "미소장국\t\n" +
                                                "오이피클\t\n" +
                                                "\n" +
                                                "\n" +
                                                "<일품코너> 4,000원\t\n" +
                                                "날치알김치볶음밥\t\n" +
                                                "단호박튀김\t\n" +
                                                "미소장국\t\n" +
                                                "\n" +
                                                "\n" +
                                                "<Self-Bar>\t\n" +
                                                "깍두기/그린샐러드\n이렇게 있네요!");

                                        TextView textview = layout3331.findViewById(R.id.time1);
                                        setTime(textview);
                                        Handler delayHandler = new Handler();
                                        delayHandler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                RelativeLayout layout324 = findViewById(R.id.main_sixth);
                                                layout324.setVisibility(VISIBLE);

                                                TextView textView3214 = layout324.findViewById(R.id.request3);
                                                textView3214.setText("이외에 더 질문할 것이 더 있으면 이 톡을 눌러 Emily와 대화해보세요!");

                                                TextView tdext = layout324.findViewById(R.id.time3);
                                                setTime(tdext);
                                                layout324.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View view) {
                                                        Intent intent = new Intent(getApplicationContext(),chat.class);
                                                        startActivity(intent);
                                                    }
                                                });
                                            }
                                        }, 300);


                                    }
                                }, 2000);
                            }
                        });
                        Button button4 = layout32.findViewById(R.id.button7);
                        button4.setText("교수회관");
                        button4.setOnClickListener(new Button.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                RelativeLayout layout334 = findViewById(R.id.main_fourth);
                                layout334.setVisibility(VISIBLE);

                                TextView textview = (TextView) layout334.findViewById(R.id.request2);
                                textview.setText("교수회관 알려줘");

                                TextView textview2 = (TextView) layout334.findViewById(R.id.time2);
                                setTime(textview2);

                                Handler delayHandler = new Handler();
                                delayHandler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        RelativeLayout layout3341 = findViewById(R.id.main_fifth);
                                        layout3341.setVisibility(VISIBLE);

                                        TextView textView3311 = layout3341.findViewById(R.id.request1);
                                        textView3311.setText("지금 시간 기준으로 \n 완두콩밥\n" +
                                                "콩나물국\n" +
                                                "닭도리탕\n" +
                                                "맛살브로콜리볶음\n" +
                                                "우엉조림\n" +
                                                "무생채\n" +
                                                "양상추샐러드\n" +
                                                "결명자차\n이렇게 있습니다!");

                                        TextView textview = layout3341.findViewById(R.id.time1);
                                        setTime(textview);
                                        Handler delayHandler = new Handler();
                                        delayHandler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                RelativeLayout layout38 = findViewById(R.id.main_sixth);
                                                layout38.setVisibility(VISIBLE);

                                                TextView textVie32w34 = layout38.findViewById(R.id.request3);
                                                textVie32w34.setText("이외에 더 질문할 것이 더 있으면 이 톡을 눌러 Emily와 대화해보세요!");

                                                TextView tex15t = layout38.findViewById(R.id.time3);
                                                setTime(tex15t);
                                                layout38.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View view) {
                                                        Intent intent = new Intent(getApplicationContext(),chat.class);
                                                        startActivity(intent);
                                                    }
                                                });
                                            }
                                        }, 300);

                                    }
                                }, 2000);
                            }
                        });
                    }
                }, 1000);
                break;
            case "2":
                RelativeLayout layout41 = findViewById(R.id.main_second);
                layout41.setVisibility(VISIBLE);

                TextView textview = (TextView) layout41.findViewById(R.id.request);
                textview.setText("사이트 바로 연결해줘");

                TextView textview2 = (TextView) layout41.findViewById(R.id.time);
                setTime(textview2);

                Handler delayHandl1er = new Handler();
                delayHandl1er.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        RelativeLayout layout42 = findViewById(R.id.main_third);
                        layout42.setVisibility(VISIBLE);

                        TextView textview = (TextView) layout42.findViewById(R.id.text3);
                        textview.setText("어떤 사이트로 접속하고 싶으신가요?\n밑 선택지 중에서 골라주세요!");

                        TextView textview2 = (TextView) layout42.findViewById(R.id.time4);
                        setTime(textview2);

                        Button button = layout42.findViewById(R.id.button4);
                        button.setText("카대전");
                        button.setOnClickListener(new Button.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                RelativeLayout relative = findViewById(R.id.main_fourth);
                                relative.setVisibility(VISIBLE);

                                TextView text3113 = relative.findViewById(R.id.request2);
                                text3113.setText("카대전 접속");

                                TextView kjkl = relative.findViewById(R.id.time2);
                                setTime(kjkl);

                                Handler delayHandler = new Handler();
                                delayHandler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        RelativeLayout layout = findViewById(R.id.main_fifth);
                                        layout.setVisibility(VISIBLE);

                                        TextView ew = layout.findViewById(R.id.request1);
                                        TextView re = layout.findViewById(R.id.time1);

                                        ew.setText("카대전으로 접속합니다.");
                                        setTime(re);

                                        Handler delayhand = new Handler();
                                        delayhand.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                RelativeLayout layout31118 = findViewById(R.id.main_sixth);
                                                layout31118.setVisibility(VISIBLE);

                                                TextView text11View34 = layout31118.findViewById(R.id.request3);
                                                text11View34.setText("이외에 더 질문할 것이 더 있으면 이 톡을 눌러 Emily와 대화해보세요!");

                                                TextView text3432 = layout31118.findViewById(R.id.time3);
                                                setTime(text3432);
                                                layout31118.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View view) {
                                                        Intent intent = new Intent(getApplicationContext(),chat.class);
                                                        startActivity(intent);
                                                    }
                                                });

                                                Handler delayHandler = new Handler();
                                                delayHandler.postDelayed(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        Uri uri = Uri.parse("https://www.facebook.com/KaDaejeon/");
                                                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                                        startActivity(intent);
                                                    }
                                                }, 1000);
                                            }
                                        },300);
                                    }
                                },500);
                            }
                        });
                        Button button2 = layout42.findViewById(R.id.button5);
                        button2.setText("학사요람");
                        button2.setOnClickListener(new Button.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                RelativeLayout relative2 = findViewById(R.id.main_fourth);
                                relative2.setVisibility(VISIBLE);

                                TextView text3113 = relative2.findViewById(R.id.request2);
                                text3113.setText("학사요람 접속");

                                TextView rea2l = relative2.findViewById(R.id.time2);
                                setTime(rea2l);

                                Handler delayHandler = new Handler();
                                delayHandler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        RelativeLayout le = findViewById(R.id.main_fifth);
                                        le.setVisibility(VISIBLE);

                                        TextView e1w = le.findViewById(R.id.request1);
                                        TextView r2e = le.findViewById(R.id.time1);

                                        e1w.setText("학사요람으로 접속합니다.");
                                        setTime(r2e);

                                        Handler hand = new Handler();
                                        hand.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {

                                                RelativeLayout layout31128 = findViewById(R.id.main_sixth);
                                                layout31128.setVisibility(VISIBLE);

                                                TextView textV11iew34 = layout31128.findViewById(R.id.request3);
                                                textV11iew34.setText("이외에 더 질문할 것이 더 있으면 이 톡을 눌러 Emily와 대화해보세요!");

                                                TextView t13ext = layout31128.findViewById(R.id.time3);
                                                setTime(t13ext);
                                                layout31128.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View view) {
                                                        Intent intent = new Intent(getApplicationContext(),chat.class);
                                                        startActivity(intent);
                                                    }
                                                });

                                                Handler delayHandler = new Handler();
                                                delayHandler.postDelayed(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        Uri uri = Uri.parse("http://bulletin.kaist.ac.kr/html/kr/#link");
                                                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                                        startActivity(intent);
                                                    }
                                                }, 1000);
                                            }
                                        }, 300);


                                    }
                                },500);
                            }
                        });
                        Button button3 = layout42.findViewById(R.id.button6);
                        button3.setText("도서관");
                        button3.setOnClickListener(new Button.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                RelativeLayout relative3 = findViewById(R.id.main_fourth);
                                relative3.setVisibility(VISIBLE);

                                TextView text3113 = relative3.findViewById(R.id.request2);
                                text3113.setText("도서관 접속");

                                TextView e = relative3.findViewById(R.id.time2);
                                setTime(e);

                                Handler delayHandler = new Handler();
                                delayHandler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        RelativeLayout go = findViewById(R.id.main_fifth);
                                        go.setVisibility(VISIBLE);

                                        TextView min = go.findViewById(R.id.request1);
                                        TextView vo = go.findViewById(R.id.time1);

                                        min.setText("도서관으로 접속합니다.");
                                        setTime(vo);

                                        Handler dalla = new Handler();
                                        dalla.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                RelativeLayout layout312118 = findViewById(R.id.main_sixth);
                                                layout312118.setVisibility(VISIBLE);

                                                TextView textV342iew34 = layout312118.findViewById(R.id.request3);
                                                textV342iew34.setText("이외에 더 질문할 것이 더 있으면 이 톡을 눌러 Emily와 대화해보세요!");

                                                TextView t64ext = layout312118.findViewById(R.id.time3);
                                                setTime(t64ext);
                                                layout312118.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View view) {
                                                        Intent intent = new Intent(view.getContext(),chat.class);
                                                        startActivity(intent);
                                                    }
                                                });

                                                Handler delayHandler = new Handler();
                                                delayHandler.postDelayed(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        Uri uri = Uri.parse("https://library.kaist.ac.kr/main.do");
                                                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                                        startActivity(intent);
                                                    }
                                                }, 1000);
                                            }
                                        }, 300);

                                    }
                                },500);

                            }
                        });
                        Button button4 = layout42.findViewById(R.id.button7);
                        button4.setText("학사공지사항");
                        button4.setOnClickListener(new Button.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                RelativeLayout relative4 = findViewById(R.id.main_fourth);
                                relative4.setVisibility(VISIBLE);

                                TextView text31123 = relative4.findViewById(R.id.request2);
                                text31123.setText("학사 공지사항 접속해줘");

                                TextView a= relative4.findViewById(R.id.time2);
                                setTime(a);

                                Handler delayHandler = new Handler();
                                delayHandler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        RelativeLayout lay = findViewById(R.id.main_fifth);
                                        lay.setVisibility(VISIBLE);

                                        TextView ke = lay.findViewById(R.id.request1);
                                        ke.setText("공지사항 접속하겠습니다.");

                                        TextView timetime = lay.findViewById(R.id.time1);
                                        setTime(timetime);

                                        Handler he = new Handler();
                                        he.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                RelativeLayout layout3121218 = findViewById(R.id.main_sixth);
                                                layout3121218.setVisibility(VISIBLE);

                                                TextView textView3324 = layout3121218.findViewById(R.id.request3);
                                                textView3324.setText("이외에 더 질문할 것이 더 있으면 이 톡을 눌러 Emily와 대화해보세요!");

                                                TextView text234 = layout3121218.findViewById(R.id.time3);
                                                setTime(text234);
                                                layout3121218.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View view) {
                                                        Intent intent = new Intent(view.getContext(),chat.class);
                                                        startActivity(intent);
                                                    }
                                                });

                                                Handler delayHandler = new Handler();
                                                delayHandler.postDelayed(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        Uri uri = Uri.parse("https://www.kaist.ac.kr/_prog/_board/?code=kaist_student&site_dvs_cd=kr&menu_dvs_cd=0603");
                                                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                                        startActivity(intent);
                                                    }
                                                }, 1000);
                                            }
                                        },300);

                                    }
                                },500);
                            }
                        });
                    }
                }, 1000);

                break;
            case "3":
                RelativeLayout layout = findViewById(R.id.main_second);
                layout.setVisibility(VISIBLE);
                TextView text3212 = layout.findViewById(R.id.request);
                text3212.setText("자주 묻는 질문 검색");
                TextView dke2 = layout.findViewById(R.id.time);
                setTime(dke2);

                Handler thread = new Handler();
                thread.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        RelativeLayout layou3t = findViewById(R.id.main_third);
                        layou3t.setVisibility(VISIBLE);

                        TextView bangtan = layou3t.findViewById(R.id.text3);
                        bangtan.setText(
                                "에밀리한테 할 수 있으신 질문들로는:\n\n" +
                                "1. 매점, 카페, 식당 등의 위치\n" +
                                "2. 오늘의 식단 (학식)\n" +
                                "3. 카이스트 근처 맛집 정보\n" +
                                "4. 학과별 졸업 요건 검색\n" +
                                "5. 도서관 관련 정보 검색\n" +
                                "6. 동아리 정보 & 동방 위치 검색\n" +
                                "7. OTL 기준 과목 정보 검색\n" +
                                "8. 김박사넷 기준 교수님 평가, 웹사이트 등 검색\n" +
                                "9. 학사일정 검색, 및 최근 2주간 있는 일정 표시\n" +
                                "10. 파팔라도 관련 검색\n\n" +
                                "더 알고 싶은 것들은 하단의 버튼들 중 골라주세요!");

                        TextView tiem = layou3t.findViewById(R.id.time4);
                        setTime(tiem);

                        Button you1 = layou3t.findViewById(R.id.button4);
                        Button you2 = layou3t.findViewById(R.id.button5);
                        Button you3 = layou3t.findViewById(R.id.button6);
                        Button you4 = layou3t.findViewById(R.id.button7);

                        you1.setText("학교 정보");
                        you2.setText("에밀리 정보");
                        you3.setText("앱 정보");
                        you4.setText("개발자 정보");


                        you1.setOnClickListener(new Button.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                RelativeLayout neo = findViewById(R.id.main_fourth);
                                neo.setVisibility(VISIBLE);
                                TextView jung2ko2ok = neo.findViewById(R.id.request2);
                                jung2ko2ok.setText("앱이 궁금해!");
                                TextView taey32eon = neo.findViewById(R.id.time2);
                                setTime(taey32eon);
                                Handler wedonttalkanymore = new Handler();
                                wedonttalkanymore.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        RelativeLayout l2ay = findViewById(R.id.main_fifth);
                                        l2ay.setVisibility(VISIBLE);

                                        TextView ke = l2ay.findViewById(R.id.request1);
                                        ke.setText("학교 정보가 궁금하시군요.\n카이스트는 세계의 중심에서 세상을 움직이는 최고의 과학기술대학으로 고급 과학기술 인재 양성과 연구 수행 및 지원이 설립 목적입니다. 현재 신성철 총장이 재임해 있으며, 상징물로는 오리연못, 석림의 종, (넙죽이)가 있습니다.");

                                        TextView timetime = l2ay.findViewById(R.id.time1);
                                        setTime(timetime);

                                        Handler he = new Handler();
                                        he.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                RelativeLayout layout31221218 = findViewById(R.id.main_sixth);
                                                layout31221218.setVisibility(VISIBLE);

                                                TextView textView3324 = layout31221218.findViewById(R.id.request3);
                                                textView3324.setText("이외에 더 질문할 것이 더 있으면 이 톡을 눌러 Emily와 대화해보세요!");

                                                TextView text234 = layout31221218.findViewById(R.id.time3);
                                                setTime(text234);
                                                layout31221218.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View view) {
                                                        Intent intent = new Intent(view.getContext(),chat.class);
                                                        startActivity(intent);
                                                    }
                                                });
                                            }
                                        },300);
                                    }
                                },400);
                            }
                        });

                        you2.setOnClickListener(new Button.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                RelativeLayout gotlove = findViewById(R.id.main_fourth);
                                gotlove.setVisibility(VISIBLE);
                                TextView jung2kook = gotlove.findViewById(R.id.request2);
                                jung2kook.setText("앱이 궁금해!");
                                TextView taey2eon = gotlove.findViewById(R.id.time2);
                                setTime(taey2eon);

                                Handler igot2love = new Handler();
                                igot2love.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        RelativeLayout l22ay = findViewById(R.id.main_fifth);
                                        l22ay.setVisibility(VISIBLE);

                                        TextView k2e = l22ay.findViewById(R.id.request1);
                                        k2e.setText("Emily 정보가 궁금하시군요.\n저는 카이스트 전용 AI 챗봇 Emily에밀리( ͡° ͜ʖ ͡°)입니다. 학사 정보 관련된 내용을 전문으로 탑재하고 있습니다. (2019년 7월 9일 탄생하였습니다.) 궁금하신 점은 최대한 알려드릴려고 노력하고 있어요. 항상 당신 곁에 있답니다!");
                                        TextView ti2metime = l22ay.findViewById(R.id.time1);
                                        setTime(ti2metime);

                                        Handler he = new Handler();
                                        he.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                RelativeLayout layout31221218 = findViewById(R.id.main_sixth);
                                                layout31221218.setVisibility(VISIBLE);

                                                TextView textView3324 = layout31221218.findViewById(R.id.request3);
                                                textView3324.setText("이외에 더 질문할 것이 더 있으면 이 톡을 눌러 Emily와 대화해보세요!");

                                                TextView text234 = layout31221218.findViewById(R.id.time3);
                                                setTime(text234);
                                                layout31221218.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View view) {
                                                        Intent intent = new Intent(view.getContext(),chat.class);
                                                        startActivity(intent);
                                                    }
                                                });
                                            }
                                        },300);
                                    }
                                },500);

                            }
                        });

                        you3.setOnClickListener(new Button.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                RelativeLayout V = findViewById(R.id.main_fourth);
                                V.setVisibility(VISIBLE);
                                TextView jungkook = V.findViewById(R.id.request2);
                                jungkook.setText("앱이 궁금해!");
                                TextView taeyeon = V.findViewById(R.id.time2);
                                setTime(taeyeon);

                                Handler igotlove = new Handler();
                                igotlove.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        RelativeLayout l222ay = findViewById(R.id.main_fifth);
                                        l222ay.setVisibility(VISIBLE);

                                        TextView k22e = l222ay.findViewById(R.id.request1);
                                        k22e.setText("이 앱이 궁금하시군요.\n이 앱은 몰입캠프 2분반 김태원, 최현성, 한지수 팀이 머리를 맡대고 만들었습니다. Dialogflow와 Firebase, 서버 이 삼박자를 이어 하나의 AI챗봇 에밀리를 만들었습니다.");
                                        TextView ti22metime = l222ay.findViewById(R.id.time1);
                                        setTime(ti22metime);

                                        Handler he = new Handler();
                                        he.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                RelativeLayout layout312212318 = findViewById(R.id.main_sixth);
                                                layout312212318.setVisibility(VISIBLE);

                                                TextView textVie3w3324 = layout312212318.findViewById(R.id.request3);
                                                textVie3w3324.setText("이외에 더 질문할 것이 더 있으면 이 톡을 눌러 Emily와 대화해보세요!");

                                                TextView text2234 = layout312212318.findViewById(R.id.time3);
                                                setTime(text2234);
                                                layout312212318.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View view) {
                                                        Intent intent = new Intent(view.getContext(),chat.class);
                                                        startActivity(intent);
                                                    }
                                                });
                                            }
                                        },300);
                                    }
                                },500);
                            }
                        });

                        you4.setOnClickListener(new Button.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                RelativeLayout charlieputh = findViewById(R.id.main_fourth);
                                charlieputh.setVisibility(VISIBLE);
                                TextView jungk3ook = charlieputh.findViewById(R.id.request2);
                                jungk3ook.setText("앱이 궁금해!");
                                TextView tae33yeon = charlieputh.findViewById(R.id.time2);
                                setTime(tae33yeon);

                                Handler igotlo3ve = new Handler();
                                igotlo3ve.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        RelativeLayout l2ay = findViewById(R.id.main_fifth);
                                        l2ay.setVisibility(VISIBLE);

                                        TextView ke = l2ay.findViewById(R.id.request1);
                                        ke.setText("개발자와 연락하고 싶으시군요.\n이 톡을 누르시면 이메일 보내기 창으로 넘어갑니다.");

                                        TextView timetime = l2ay.findViewById(R.id.time1);
                                        setTime(timetime);

                                        l2ay.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                Intent email = new Intent(Intent.ACTION_SEND);
                                                email.setType("plain/Text");
                                                email.putExtra(Intent.EXTRA_EMAIL, "maxkim139@gmail.com");
                                                email.putExtra(Intent.EXTRA_SUBJECT,"Emily 건의사항");
                                                email.putExtra(Intent.EXTRA_TEXT, "앱 버전 (AppVersion):"+ "\n기기명 (Device):\n안드로이드 OS (Android OS):\n내용 (Content):\n");
                                                email.setType("message/rfc822");
                                                startActivity(email);
                                            }
                                        });

                                        Handler he = new Handler();
                                        he.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                RelativeLayout layout312212128 = findViewById(R.id.main_sixth);
                                                layout312212128.setVisibility(VISIBLE);

                                                TextView textView31324 = layout312212128.findViewById(R.id.request3);
                                                textView31324.setText("이외에 더 질문할 것이 더 있으면 이 톡을 눌러 Emily와 대화해보세요!");

                                                TextView text2234 = layout312212128.findViewById(R.id.time3);
                                                setTime(text2234);
                                                layout312212128.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View view) {
                                                        Intent intent = new Intent(getApplicationContext(),chat.class);
                                                        startActivity(intent);
                                                    }
                                                });
                                            }
                                        },300);
                                    }
                                },600);

                            }
                        });
                    }
                },1000);


                break;
        }

    }


    public void setTime(TextView textView){
        Date time = new Date();
        String time2 = format1.format(time);
        textView.setText(time2);
    }
}
