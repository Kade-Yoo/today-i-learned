# AWS Lambda Runtime Version 변경기

- AWS Lambda 처음 접했고 Runtime 변경이라는 것은 더더욱 들어보지 못했다
- 목적은 Lambda Runtime NodeJS12가 11월 14일부로 추가 기술지원이 종료되고 12월 부로 신규 생성이 안된다는 것이다
- 그래서 NodeJS12 to 16으로 변경을 해야한다
- 변경 전에 확인해야할 사항은 코드!
- 근데 코드를 찾기까지 엄청 오래걸렸다… 그 이유는 람다를 어떻게 쓰는지 모르기 때문에 결국 찾긴했다 찾아서 어떤 부분을 확인해야하는지 검색해서 찾았다
    - 첫번째 : Dependency(Library) NodeJS16으로 Version Upgrade가 되면서 동작을 안할 만한 애들을 찾아라!
        - 방법은 library를 검색해보고 github에서 정보를 찾는 것
    - 두번째 : Code NodeJS16으로 변경되면서 Deprecate된 애들을 찾아라!
        - 공홈에서 Deprecate된 내용을 확인해서 코드에서 찾는다 해당사항이 있는지

  [Node v16.0.0 (Current) | Node.js](https://nodejs.org/ko/blog/release/v16.0.0/)


!! 확인 할 사항 : AWS Lambda를 테스트할 방법을 알아야한다, 근데 여기서 궁금한 사항 요건 테스트 코드를 어떻게 짜야되지?, 그냥 코드에서 하면되는걸까?