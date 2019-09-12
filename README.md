# MADCAMP3
카이스트 몰입캠프 3주차 

DialogFLow, FIrebase DB, Android Studio를 이용한 카이스트 내부 정보를 알려주는 채팅봇 구현(이후 카톡과도 연동 가능)
1. DialogFlow: Intent와 entities를 이용한 ML 학습을 시켜 자연어를 기계가 알아듣고 서버에 Post 요청을 보내 항목별로 답변을 도출하도록 구현
2. Firebase DB: Web crawling을 이용하여 웹사이트들에 흩어져 있는 정보들을 한 DB에 모아 JSON형태로 정리해 놓음
3. Androids Studio: DialogFlow와 안드로이드를 연동하여 Dialogflow에서 구현한 ML을 가져올 수 있도록 함.
