# MADCAMP3
카이스트 몰입캠프 3주차 

## Used
Server: DialogFlow, FirebaseDB, Nodejs

FrontEnd: Android Studio

## Home Window
<img width="200" alt="스크린샷 2019-09-12 오후 7 42 24" src="https://user-images.githubusercontent.com/50355670/64778127-6f434100-d596-11e9-854f-df9c82a5e279.png">

The main feature of this app is its chatbot feature. However, we have taken out some of the mainly used features such as asking the menu of the school cafeteria, URL to school sites, frequently asked questions. The user can access these question with buttons in the main window.

카이스트 내부의 정보를 알려주는 챗봇이 본 앱의 주요 기능. 그중, 자주 사용되는 기능들 (학식, 학교 사이트들, 자주 물어보는 질문 등)을 따로 버튼식으로 유저가 사용할 수 있도록 따로 분리함.

## Cafeteria Menu

<img width="200" alt="스크린샷 2019-09-12 오후 7 42 33" src="https://user-images.githubusercontent.com/50355670/64782015-322f7c80-d59f-11e9-8170-717d8b30ed7b.png">

On clicking the first button, the window is switched to a button based ui where the user can select the cafeteria's menu. The cafeteria menu is crawled from th school's portal webpage everyday and stored in the firebase DB.

첫번째 버튼을 누르면, 버튼 형식을 기반으로 한 챗봇 윈도우가 열리게 되고, 교내 식당을 선택할 수 있고, 각 식당의 메뉴를 열람할 수 있음. 메뉴는 매일 학교 홈페이지로부터 크롤링 하여 가져오게 하였음.

## URL to School Sites

<img width="200" alt="스크린샷 2019-09-12 오후 7 42 43" src="https://user-images.githubusercontent.com/50355670/64783768-92282200-d5a3-11e9-80d2-acce31ee5b30.png">      <img width="200" alt="스크린샷 2019-09-12 오후 9 24 16" src="https://user-images.githubusercontent.com/50355670/64783830-b2f07780-d5a3-11e9-9abb-9006067d96ca.png">

On clicking the second button, the window is switched to yet another button based ui where the user can select one of the frequent sites visited by students in KAIST. This window is also a button-based UI.

두번째 버튼을 누르면, 버튼 형식을 기반으로 한 챗봇 윈도우가 열리게 되고, 카이스트 학생들이 자주 사용하는 웹사이트들을 
띄워주고 버튼을 누르면 해당 
사이트로 연결해 
줍니다.

DialogFLow, FIrebase DB, Android Studio를 이용한 카이스트 내부 정보를 알려주는 채팅봇 구현(이후 카톡과도 연동 가능)
1. DialogFlow: Intent와 entities를 이용한 ML 학습을 시켜 자연어를 기계가 알아듣고 서버에 Post 요청을 보내 항목별로 답변을 도출하도록 구현
2. Firebase DB: Web crawling을 이용하여 웹사이트들에 흩어져 있는 정보들을 한 DB에 모아 JSON형태로 정리해 놓음
3. Androids Studio: DialogFlow와 안드로이드를 연동하여 Dialogflow에서 구현한 ML을 가져올 수 있도록 함.
