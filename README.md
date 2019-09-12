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
사이트로 연결해 줌.

## ChatBot

<img width="200" alt="스크린샷 2019-09-12 오후 9 45 20" src="https://user-images.githubusercontent.com/50355670/64785200-ca7d2f80-d5a6-11e9-91dd-e86147d5442d.png">      <img width="200" alt="스크린샷 2019-09-12 오후 7 46 21" src="https://user-images.githubusercontent.com/50355670/64784877-15e30e00-d5a6-11e9-8a2f-7e270fc620db.png">

The main feature of the chatbot can be accessed by clicking the button. The message is sent to the server that is connected to the dialogfow. Dialogflow has been trained to understand various questions in Korean.

1. Asking Locations, and its open,close time
2. Cafeteria Menu
3. Club information
4. Professor information
5. Subject&Class information
6. School Schedules(ex. start of semester)
....

Most of the information is gathered by crawling different sites regarding each information using beautifulsoup in python. 

가장 주요한 기능인 챗봇 기능은 마지막 버튼을 누르면 된다. 채팅방에서 쓴 메세지는 dialogflow와 연결되어 있는 서버로 보내지고, dialogflow에서 메세지를 받아서 화면에 띄운다. Dialogflow는 위와 같은 질문들에 대한 대답을 받을 수 있도록 train되어 있다. 대부분의 챗봇이 가진 정보들은 학교 웹사이트들에서 beautifulsoup로 크롤링한 정보들을 DB에 저장하고, DB의 정보를 서버가 가져오는 형식으로 구성되어 있다.
