<%@ page contentType="text/html; charset=UTF-8"%>


<!-- 프로젝트 실행시 유의해야 할 점 -->
<!-- 
1. 이 프로젝트는 Oauth를 사용하기 때문에 developer.facebook에서 oauth를 생성하여 아이디 값을 facebook.js와 인덱스, 헤더에 링크관련되어서
나와있는 아이디값도 변경해주어야 한다.
2. csv 파일 생성시 MusicController에서 이 프로젝트가 있는 위치를 지정해 두어야 music 폴더에 data.csv가 생성되며
생성되었을 경우 프로젝트를 리프레시 해주어야 화면구현이 된다.
3. 현재 페이스북 아이디를 통해 받아오기 때문에 아이디값을 제대로 저장하지 못하여 History검색에 문제점이 있다.
String값으로 임의값을 지정해 두었기 때문에 그걸 변경하게 되면 작성이 가능하다.
 -->


<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Index</title>
    <link href='https://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900italic,900' rel='stylesheet' type='text/css'>
    <link rel='stylesheet prefetch'	href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
    <link rel='stylesheet prefetch'	href='https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css'>
    <link rel='stylesheet prefetch'	href='http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css'>
    <link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,600,200italic,600italic&subset=latin,vietnamese' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" href="./css/mediaQuery.css">
    <link rel="stylesheet" href="./css/startpage.css"> 
</head>
<body>  
<section class="header">
    <!-- 왼쪽 상단 화살표 2개 -->
    <div class="page-flows">
        <span class="flow"><a href="javascript:history.back();"> <i class="ion-chevron-left"></i> </a></span>
        <span class="flow"> <i class="ion-chevron-right disabled"></i> </span>
    </div>

    <!-- 홈 이동  -->
    <div class = "home-page">
        <a href="index.do" class="navigation__home__item">
            <span>HOME</span>
        </a>
    </div>
    <!-- 검색창
   <div class="search">
       <input type="text" placeholder="Search" />
   </div>
    -->

    <!-- 로그인 시 회원 정보 -->
    <div class="user">
        <div class="user__info">				
            <span class="user__info__name">
            		<span>      </span>
					<span id="status" style="text-align:right; color:#ffffff"></span>
				</span>
        </div>

        <div class="user__actions">
            <div class="dropdown">
                <button class="dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                    <i class="ion-chevron-down"></i>
                </button>
                <ul class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenu1">
                    <li><a href="./user/customer.do">FAQ</a></li>
                    <li><span><fb:login-button scope="public_profile,email"  data-size="xlarge" data-auto-logout-link="true" onlogin="checkLoginState();"/>
					</span></li>
                </ul>
            </div>
        </div>
    </div>
</section>
<!-- 본문 -->
<section class="section-middle">
    <!-- 왼쪽의 메뉴 부분 -->
    <div class="content__left">
        <section class="navigation">
            <!-- Main -->
            <div class="navigation__list">
                <div class="navigation__list__header" role="button" data-toggle="collapse" href="#main" aria-expanded="true" aria-controls="main">
                    Main
                </div>
                <div class="collapse in" id="main">
                    <a href="./main/search.do" class="navigation__list__item">
                        <i class="ion-ios-browsers"></i>
                        <span>감성 검색</span>
                    </a>
                    <a href="./main/share.do" class="navigation__list__item">
                        <i class="ion-person-stalker"></i>
                        <span>감정 공유</span>
                    </a>
                </div>
            </div>
            <!-- / -->

            <!-- Your Music -->
            <div class="navigation__list">
                <div class="navigation__list__header" role="button" data-toggle="collapse" href="#yourMusic" aria-expanded="true" aria-controls="yourMusic">
                    Your Music
                </div>

                <div class="collapse in" id="yourMusic">
                    <a href="http://www.facebook.com/dialog/oauth?client_id=662302497285882&redirect_uri=http://172.16.4.1:9090/test/music/replay.do" class="navigation__list__item">
                        <i class="ion-headphone"></i>
                        <span>청취 기록</span>
                    </a>
                    <a href="http://www.facebook.com/dialog/oauth?client_id=662302497285882&redirect_uri=http://172.16.4.1:9090/test/music/emotionlist.do" class="navigation__list__item">
                        <i class="ion-ios-musical-notes"></i>
                        <span>감정 그래프</span>
                    </a>
                </div>
            </div>
            <!-- / -->

            <!-- Playlists -->
            <div class="navigation__list">
                <div class="navigation__list__header" role="button" data-toggle="collapse" href="#playlists" aria-expanded="true" aria-controls="playlists">
                    Playlists
                </div>

                <div class="collapse in" id="playlists">
                    <a href="./playlist/toplist.do" class="navigation__list__item">
                        <i class="ion-ios-musical-notes"></i>
                        <span>Music TOP 10</span>
                    </a>
                    <!-- <a href="./playlist/emotion.do" class="navigation__list__item">
                        <i class="ion-ios-musical-notes"></i>
                        <span>감성 보기</span>
                    </a> -->
                    <a href="./playlist/randomplaylist.do" class="navigation__list__item">
                        <i class="ion-ios-musical-notes"></i>
                        <span>랜덤 듣기</span>
                    </a>
                </div>
            </div>
            <!--  Bubble Chart-->
            <script>
			var point0 =  '${jsonEmotion.happy }';
			var point1 =  '${jsonEmotion.disgust }'; 
			var point2 =  '${jsonEmotion.fear }';
			var point3 =  '${jsonEmotion.interest }';
			var point4 =  '${jsonEmotion.pain }';
			var point5 =  '${jsonEmotion.rage }';
			var point6 =  '${jsonEmotion.sad }';
            </script>	
            <div class="bubbleChart"></div>
        </section>
    </div>

    <!-- 메인에 해당하는 부분  -->
    <div class="content__middle">
    
    	<div id="wrap">
		<div id="app"></div>
		</div>
    
    	<div id="mainBubble">  </div>
    </div>
    <!-- 유투브 플레이어 부분-->
     <script>									 <!--  변수가 .js 내에서 동작이 안됨. jsp 내에서 선언한다.-->
    	var id = '${videoId}'
		if(!id){	id = "OxgiiyLp5pk" }		 // 이전의 재생중인 영상이 없거나 초기값인경우 '야생화' 재생
    </script>	
    <div class="content__right">
        <div id="content__player" >   <!--  IFrameAPI 에 의해 식별된 div 는 iframe 로 대체 된다.-->
        </div>
        <div id="content__lyrics" style="overflow:scroll;">
        	<div class="lyrics" >${lyrics }</div>
        </div>
    </div>

</section>
<section >
    <br>==================================================================================== Footer ===========================================================================================
</section>

<!-- Etc Script -->
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>
<script src="./js/facebook.js"></script>
<script src="./js/startpage.js"></script>
<script src="./js/youtube.js"></script>

<!-- D3 Bubble Chart Script-->
<script src="http://phuonghuynh.github.io/js/bower_components/jquery/dist/jquery.min.js"></script>
<script src="http://phuonghuynh.github.io/js/bower_components/d3/d3.min.js"></script>
<script src="http://phuonghuynh.github.io/js/bower_components/d3-transform/src/d3-transform.js"></script>
<script src="http://phuonghuynh.github.io/js/bower_components/cafej/src/extarray.js"></script>
<script src="http://phuonghuynh.github.io/js/bower_components/cafej/src/misc.js"></script>
<script src="http://phuonghuynh.github.io/js/bower_components/cafej/src/micro-observer.js"></script>
<script src="http://phuonghuynh.github.io/js/bower_components/microplugin/src/microplugin.js"></script>
<script src="http://phuonghuynh.github.io/js/bower_components/bubble-chart/src/bubble-chart.js"></script>
<script src="http://phuonghuynh.github.io/js/bower_components/bubble-chart/src/plugins/lines/lines.js"></script>
<script src="./js/central-click.js"></script>
<script src="./js/d3_Bubble_Chart.js"></script>
</body>
</html>

