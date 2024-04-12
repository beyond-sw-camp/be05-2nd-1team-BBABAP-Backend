# be05-2nd-project-1st-team-BBABAP

![BBABAP LOGO](https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/113917104/aa9c8201-c25c-4553-89cb-bcf0a741ce58)

# <div align="center">전기차 충전소 찾기 서비스</div>
## <div align="center">:dizzy:한화시스템 BEYOND SW캠프 2차 프로젝트:dizzy:</div>

<div align=center><h3>:books: STACKS</h3></div>

<div align=center> 
  <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> 
 <img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"> <img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
  <br>

<img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white"> 
  <img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white"> 
  <img src="https://img.shields.io/badge/bootstrap-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white">
  <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black"> 
  <br>
<img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white">
<br>
<img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">
  <img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white">
</div>
<br>
<br>

![image](https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/155924495/499225bb-9656-4383-aea4-1a00e9ceaf5c)

## 팀원 소개
<table>
  <tbody>
    <tr>
      <td align="center"><a href="https://github.com/chan-nni"><img src="https://avatars.githubusercontent.com/chan-nni" width="120px;" alt="강찬미"/><br /><sub><b>강찬미</b></sub></a><br /></td>
      <td align="center"><a href="https://github.com/hsw50108"><img src="https://avatars.githubusercontent.com/hsw50108" width="120px;" alt="김동욱"/><br /><sub><b>김동욱</b></sub></a><br /></td>
      <td align="center"><a href="https://github.com/nbbb9"><img src="https://avatars.githubusercontent.com/nbbb9" width="120px;" alt="이영원"/><br /><sub><b>이영원</b></sub></a><br /></td>
      <td align="center"><a href="https://github.com/eujin99"><img src="https://avatars.githubusercontent.com/eujin99" width="120px;" alt="정유진"/><br /><sub><b>정유진</b></sub></a><br /></td>
      <td align="center"><a href="https://github.com/zzimni"><img src="https://avatars.githubusercontent.com/zzimni" width="120px;" alt="하지민"/><br /><sub><b>하지민</b></sub></a><br /></td>
    </tr>
  </tbody>
</table>

## 역할 분담
**강찬미** : api 명세서 작성 , 게시글 , 댓글 구현
<BR>
**김동욱** : 요구사항 명세서 작성 , 회원가입 , 로그인 구현 
<BR>
**이영원** : 요구사항 명세서 작성 , WBS 작성 , 충전소 지도 , 검색 , 즐겨찾기 구현
<BR>
**정유진** : 요구사항 명세서 작성 , WBS 작성 , 충전소 조회, 검색, 등록 구현
<BR>
**하지민** : 기능 명세서 작성 , 로그아웃 , 게시글 , 댓글 기능 수정

# 목차
### 1. [프로젝트 개요](#프로젝트-개요)
* [개발동기](#개발동기)
* [개발목적](#개발목적)
* [기대효과](#기대효과)
* [일정](#일정)

### 2. [요구사항 정의](#요구사항-정의)
* [기능 명세서](#기능명세서)
* [요구사항 명세서](#요구사항-명세서)
* [테이블 명세서](#테이블명세서)
* [ERD 설계도](#ERD-설계도)
* [API 명세서](#API-명세서)

### 3. [프로젝트 설명](#프로젝트-설명)

* [회원, 게시판, 댓글 CRUD](##회원,-게시판,-댓글-CRUD)
  * [FlowChart](#FlowChart)
  * [TestCase](#TestCase)

* [지도, 전기차 충전소](##지도,-전기차-충전소)
  * [FlowChart_외부 API CRUD](#FlowChart_외부-API-CRUD)
  * [FlowChart_전기차 충전소 DB CRUD](#FlowChart_전기차-충전소-DB-CRUD)
  * [TestCase](#TestCase)

### 4. [마치며...](마치며...)


---

# 1. 프로젝트 개요
## 개발동기
이번에 구성된 팀으로 백엔드 프로젝트만 진행하는 줄 알고 처음에는 CRUD 기능을 갖춘 간단한 SNS 서비스를 개발할 계획이었습니다. 그래서 테이블 명세서를 작성하고 ERD를 구성하고, UI까지 피그마로 구현하였습니다. 그런데 팀이 그대로 유지되어 다음 프론트엔드 프로젝트까지 함께 진행하게 된다는 공지를 받았습니다. 이에 저희는 백엔드와 프론트엔드를 결합해서 보다 다양한 기술을 활용하여 풍성한 기능을 갖춘 서비스를 개발해보고 싶다는 욕심이 생겼습니다. 외부 API를 활용하면 외부 데이터를 DB까지 연결해서 다양한 기능을 구성할 수 있고, 프론트엔드에서도 다양한 UI를 구현할 수 있을 것이라는 기대가 있었습니다. 그래서 저희는 공공데이터와 지도 API를 사용할 수 있는 프로젝트 주제를 생각해보았고, 결과적으로 전기차 충전소 위치 검색과  충전소 후기 작성&조회,  전기차 사용자들을 위한 커뮤니티 등을 포함한 전기차 사용자 전용 서비스를 구현하기로 결정했습니다. 
## 개발목적
![title](https://www.poscochemical.com/upload/img/202302/202302276e_9M4Cbr0C.png)   
![title](https://pds.joongang.co.kr/news/component/htmlphoto_mmdata/202202/15/78177e54-9800-4f7c-9e3e-d1d8e0d39f9b.jpg)   
![title](https://www.gyotongn.com/news/photo/202301/340751_91139_2018.jpg)   


[전기차 충전소 위치 파악에 어려움을 겪는 사용자들에 대한 기사](https://www.gyotongn.com/news/articleView.html?idxno=340751)   



전기차 보급의 급속한 성장은 전기차 충전 인프라의 중요성을 더욱 부각시키고 있습니다. 현재 전기차 충전 인프라는 부족한 상황이며, 충전소의 수요가 늘어나면서 관리와 운영에 대한 요구가 더욱 증가하고 있습니다.
이에 따라 전기차 시장의 성장에 발맞추어 효율적인 충전소 관리 및 운영 시스템을 개발하는 것이 필요합니다. 이러한 시스템은 전기차 사용자들이 충전소를 편리하게 이용할 수 있도록 돕고, 충전소 운영자들은 충전소를 보다 효율적으로 관리하여 서비스 품질을 향상시킬 수 있습니다.
이는 전기차 시장의 성장을 지원하고 환경 친화적인 교통 수단으로의 전환을 촉진하는 데 도움이 될 것으로 기대됩니다.
이 프로젝트의 목적은 현재의 전기차 충전 인프라의 한계를 극복하고, 보다 효율적이고 편리한 전기차 충전소 관리 및 운영 시스템을 구축하는 것입니다. 구체적으로는 다음과 같은 목적을 가지고 개발을 진행하고 있습니다:
1. 사용자 편의성 제고
    - 전기차 운전자들이 충전소를 쉽게 찾고 이용할 수 있도록 합니다. 이를 통해 전기차 운전자들은 충전소 위치 및 상태를 빠르게 확인하고 예약할 수 있어 편리함을 느낄 수 있습니다.
2. 게시판 기능 제공
    - 사용자들이 서로 정보를 공유하고 소통할 수 있는 게시판을 구축하여 사용자들간의 소통을 촉진합니다. 이를 통해 사용자들은 경험 공유, 충전소 추천, 문의사항 등을 자유롭게 게시하고 공유할 수 있습니다. 또한, 게시판을 통해 운전자들의 궁금증을 해결하고 문제를 해결하는 데에도 도움을 줄 수 있습니다.
이러한 목적을 통해 전기차 운전자들은 보다 편리하게 충전소를 이용할 수 있으며, 충전소 운영자들은 사용자들의 피드백을 적극 수용하여 서비스 품질을 높일 수 있습니다. 이는 전기차 시장의 확대와 함께 전기차 보급의 촉진에 기여할 것으로 기대됩니다.
## 기대효과
1. 사용자 편의성 증대
    - 전기차 운전자들은 충전소 위치 및 상태를 쉽게 확인하고 예약할 수 있어 편리함을 경험할 수 있습니다. 이는 전기차 이용의 장벽을 낮추어 전기차 보급률을 높일 수 있습니다.
2. 운영 효율성 향상
    - 충전소 운영자들은 실시간으로 충전소의 상태를 모니터링하고 관리할 수 있어 운영 효율이 향상됩니다. 이를 통해 충전소의 혼잡도를 완화하고 서비스 품질을 개선할 수 있습니다.
3. 자원 최적 활용
    - 충전소 관리 시스템을 통해 충전소의 이용률을 최적화하고 에너지를 효율적으로 관리할 수 있습니다. 이는 전기차 시장의 지속 가능한 성장을 지원합니다.
4. 사용자 커뮤니티 구축
    - 게시판 기능을 통해 사용자들 간의 소통과 정보 교류가 활성화됩니다. 이는 전기차 운전자들의 경험 공유와 충전소 추천에 도움을 줄 뿐만 아니라, 서로의 궁금증을 해결하는 데에도 도움이 됩니다.
5. 환경 보호 및 에너지 절감
    - 전기차의 보급은 환경 보호에 기여하며, 충전 인프라의 효율적 관리는 에너지를 절약하는 데에도 도움이 됩니다.
이러한 기대효과를 통해 전기차 시장의 성장을 지원하고 보다 지속 가능한 교통 시스템을 구축하는 데 기여할 것으로 기대됩니다.
## 일정
![image](https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/155924495/06a9404b-5f06-4d9b-8a9d-aa864cf5dd18)



<br>

# 2. 요구사항 정의
## 기능 명세서
![image](https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/155924495/8b5c45d0-fe8e-4600-9658-0b7122114f98)
[기능 명세서](https://docs.google.com/spreadsheets/d/1HJ723_Ogkmu6DHP5rk5k0lYIcjl0OEtLpUuBsLs4hm0/edit#gid=16405556)
## 요구사항 명세서
![image](https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/155924495/7ece42c9-52a6-4784-a73b-a5c5c24b9a11)
[요구사항 명세서](https://docs.google.com/spreadsheets/d/1HJ723_Ogkmu6DHP5rk5k0lYIcjl0OEtLpUuBsLs4hm0/edit#gid=1162915854)
## 테이블 명세서
![image](https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/155924495/1fc95f40-4c58-49bf-a9b6-3c9c0316fef2)
## ERD 설계도
![image](https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/155924495/122e68ac-6c21-41f0-bf05-f2901154aac2)
## API 명세서
![API 반띵](https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/156767787/90e1510b-da6f-4a0c-95f4-8938cb0ad392)
![API 반띵2](https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/156767787/30781dbe-9dd9-43aa-bfd3-fb56599c08b8)



# 3. 프로젝트 설명
## 회원, 게시판, 댓글 CRUD
### FlowChart
- User / Board / Comment CRUD
<img width="1279" alt="스크린샷 2024-03-28 오전 3 16 54" src="https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/156767787/d557ecca-99f8-4b55-ae67-84f6bb78cc97">




### TestCase

<details>
  <summary>회원 - 회원가입</summary>
  <div markdown="1">
    <img src="https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/85616993/517b2603-53e1-44c7-9c4b-abc8df2d4354"/>
  </div>
  <div markdown="1">
    <img src="https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/85616993/5845260c-dc57-4598-897e-a4a4dd42b482"/>
  </div>
</details>
<details>
  <summary>회원 - 로그인</summary>
  <div markdown="1">
    <img src="https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/85616993/e4af241d-c8cd-434e-b781-46230253ddc9"/>
  </div>
</details>
<details>
  <summary>회원 - 수정</summary>
  <div markdown="1">
    <img src="https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/85616993/ee3c21d5-f6b6-4995-b8f5-491dcf852d37"/>
  </div>
  <div markdown="1">
    <img src="https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/85616993/c7c7b2a6-dd86-43cb-a635-e29df7e7b4b6"/>
  </div>
</details>
<details>
  <summary>회원 - 수정 후 로그아웃</summary>
  <div markdown="1">
    <img src="https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/85616993/a4a14b30-1368-4ae7-a144-b271d012bebb"/>
  </div>
</details>
<details>
  <summary>회원 - 수정된 정보 로그인</summary>
  <div markdown="1">
    <img src="https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/85616993/a3f29dcb-de85-41cb-ac8f-ebdc6cb2bd27"/>
  </div>
</details>
<details>
  <summary>회원 - 삭제</summary>
  <div markdown="1">
    <img src="https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/85616993/dd9b3c83-1d8f-4f7c-811e-3c10cc851d3f"/>
- 수정 된 비밀번호로 다시 로그인 후 회원 삭제
  </div>
  <div markdown="1">
    <img src="https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/85616993/94b10789-4493-45e3-b782-0156faf58ad8"/>
  </div>
</details>
<details>
  <summary>게시판 - 게시글 전체 조회</summary>
  <div markdown="1">
    <img src="https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/85616993/d4c914ed-ed87-4c4a-adbd-5c03cfded29c"/>
  </div>
</details>
<details>
  <summary>게시판 - 게시글 등록</summary>
  <div markdown="1">
    <img src="https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/85616993/c6670ce5-42d2-40a6-b69a-f2877b741e72"/>
  </div>
  <div markdown="1">
    <img src="https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/85616993/f7f5b06d-e4d4-4a5b-8406-1c4609e9cd79"/>
  </div>
</details>
<details>
  <summary>게시판 - 게시글 수정</summary>
  <div markdown="1">
    <img src="https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/85616993/b5db6c37-3bc1-42b6-8618-d47ff58064f9"/>
  </div>
  <div markdown="1">
    <img src="https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/85616993/16485229-1629-4ef6-a65e-f46064067129"/>
  </div>
</details>
<details>
  <summary>게시판 - 게시글 삭제</summary>
  <div markdown="1">
    <img src="https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/85616993/a38b0a0b-69b8-4676-bc2e-9cbecf3602a1"/>
  </div>
  <div markdown="1">
    <img src="https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/85616993/69f47172-3cad-400c-a53e-0bdff1618bb5"/>
  </div>
</details>
<details>
  <summary>게시판 - 특정 게시글 조회</summary>
  <div markdown="1">
    <img src="https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/85616993/c860c80f-94a7-4a1b-8cb4-5018835b14a2"/>
  </div>
</details>
<details>
  <summary>게시판 - 게시글 제목/내용 키워드 검색</summary>
  <div markdown="1">
    <img src="https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/85616993/845742a1-65c2-42b0-9120-a38aab6e1742"/>
  </div>
</details>
<details>
  <summary>게시판 - 댓글 등록</summary>
  <div markdown="1">
    <img src="https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/85616993/a67546e5-feef-41e4-b842-e0f1fc29d034"/>
  </div>
  <div markdown="1">
    <img src="https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/85616993/8838d220-35dd-4b6d-9d87-5dbf8dcda03f"/>
  </div>
</details>
<details>
  <summary>게시판 - 댓글 삭제</summary>
  <div markdown="1">
    <img src="https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/85616993/f65d718c-d33d-4b15-bee0-6e4c8fb76e96"/>
  </div>
  <div markdown="1">
    <img src="https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/85616993/e09b9484-607d-453b-a93d-a177bf89386b"/>
  </div>
</details>
## 지도, 전기차 충전소

### FlowChart_외부 API CRUD
![KakaoMapDiagram](https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/113917104/10b730f3-50d6-4855-bb48-97f830d8fba0)
![FavoriteDiagram](https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/113917104/85a45293-8633-487e-a8a4-24afd82cd8a2)
>### KaKaoMapUI.java
* 카카오맵 API를 통해 주소를 검색하고 지도로 확인할 수 있습니다.
![UItest1](https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/113917104/e80e16c4-4aa9-465e-8306-041d38d8ccc5)
![UItest2](https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/113917104/0e0ff1c9-e5a4-4416-8aec-6dfc4cc1e251)
>### KaKaoMapController.java
* 카카오맵 API를 통해 데이터를 검색할 수 있습니다.
![KakaoMapController](https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/113917104/51016796-7239-4a4f-8e31-45c0d99b234d)
>### FavoriteController.java
* 공공데이터_'한국환경공단 전기차 충전소 위치 및 운영정보' API를 통해 전국의 전기차 충전소 데이터에 접근할 구 있습니다.
* <u>**/favorite/save?충전소명={특정충전소명}**</u>
![AddFavorite](https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/113917104/8fbca018-ab64-49b2-8af9-93c9d4fa8fe1)
>### FavoriteService.java
* FavoriteController의 충전소명에 해당하는 충전소의 모든데이터를 불러온 뒤 원하는 Key값으로 필터링하여 Entity에 저장합니다.
* 검색을 수행할 땐 공공데이터 API에 존재하는 충전소명과 일치해야하며, 일치하지 않는다면 '존재하지 않는 충전소입니다." 문구 출력합니다.
>### FavoriteEntityjava
* 필터링을 통해 얻은 데이터를 DB에 저장하기 위한 Entity입니다.
* AUTOINCREMENT를 수행하는 기본키 id
* 충전소의 이름 _ charger_Name
* 충전소의 주소 _ charger_Address
* 충전소의 충전량(고속충전 여부판단 가능)_charger_Power
* 충전소의 충전타입_charger_Type
![FavoriteAdd](https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/113917104/124917fe-38b5-4113-8abe-cc23eab162b3)

### FlowChart_전기차 충전소 DB CRUD

![image](https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/155924495/08c12707-70c0-4b4d-b2d1-c82703b1368c)
![image](https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/155924495/c5ac7eca-82bf-409d-9213-6d889904ef86)
  >### Charge.java
* Charge라는 클래스를 정의하는 엔터티 파일입니다. 각 충전소에 대한 정보를 저장하고 있습니다.
![image](https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/155924495/3c5104bf-61ab-45ff-b6bb-96f403909514)

 >### ChargeRepository.java
* Spring Data JPA를 사용하여 Charge 엔터티에 액세스하기 위한 리포지토리 인터페이스입니다. 데이터베이스에서 Charge 엔터티를 조회, 저장, 업데이트 및 삭제할 수 있는 메서드를 제공합니다.
![image](https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/155924495/abb7e7a8-7032-4ce8-9f82-8fbbc089a60f)

 >### ChargeService.java
 * 비즈니스 로직을 처리하는 서비스 클래스입니다. ChargeRepository를 통해 데이터베이스에서 데이터를 조작하고, 컨트롤러에게 필요한 기능을 제공합니다.
![image](https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/155924495/47977781-0088-4023-a7ba-716c593ffe91)

 >### ChargeController.java
 * 웹 요청을 처리하는 컨트롤러 클래스입니다. 클라이언트의 요청을 받아 비즈니스 로직이 담긴 서비스 클래스를 호출하고, 그 결과를 뷰에 전달하여 화면에 표시합니다.
![image](https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/155924495/003f5bf8-4450-407f-bfa3-e9c02d0149de)
![image](https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/155924495/d8d177f3-774a-49fa-9f5a-cf20b2206431)


 >### ChargeRestController.java
 * RESTful API 엔드포인트를 처리하는 REST 컨트롤러입니다. JSON 형식으로 데이터를 제공하며, 주로 외부 시스템과의 통신에 사용됩니다.
![image](https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/155924495/0ce8f258-4f53-4e10-bb8f-2127cd9a99aa)


 >### listCharge.html
* 충전소 목록을 보여주는 HTML 템플릿입니다. Thymeleaf를 사용하여 서버에서 전달받은 데이터를 동적으로 표시합니다.

## TestCase
### 전기차 충전소 목록 불러오기 포스트맨
![image](https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/155924495/45110890-7f9d-4ace-a669-5561631c6a65)

### 전기차 충전소 목록 불러오기 뷰
![image](https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/155924495/931bbf8f-88d9-4555-9efc-76ed63d11023)

### 전기차 충전소 [충전소 명] 필터 검색
![image](https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/155924495/f3b4bc69-aba3-45e4-8b9c-a20425f54bbd)

### 전기차 충전소 [충전소 주소] 필터 검색
![image](https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/155924495/536d17b9-604d-4a71-9fab-e5cca1dbf79e)

### 전기차 충전소 [회사명] 필터 검색
![image](https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/155924495/aba87ee8-ae62-44f3-b22c-a478a2f1b20d)

### 전기차 충전소 정보 추가
#### 추가 전
![image](https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/155924495/1eb54ab6-ceab-4b48-916e-cb044442ade0)

#### 추가 후
![image](https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/155924495/ffbd1952-2d7c-41aa-9b6e-0fba1ffee7b5)

![image](https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/155924495/3aabc81a-10e1-404e-bf69-9a4ae714a5bc)

# 4. 마치며...
![빠밥 사진](https://github.com/beyond-sw-camp/be05-2nd-1team-BBABAP/assets/65129708/02b36fd5-7bd3-4b89-919d-3c9a78e9ab15))   
