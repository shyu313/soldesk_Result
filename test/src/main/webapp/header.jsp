<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <!DOCTYPE html>
        <html lang="ko">
        <head>
        <meta charset="UTF-8">
        <title>Index</title>
        <link
        href='https://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900italic,900'
        rel='stylesheet' type='text/css'>
        <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
        <link rel='stylesheet prefetch'
        href='https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css'>
        <link rel='stylesheet prefetch' href='http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css'>
        <link
        href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,600,200italic,600italic&subset=latin,vietnamese'
        rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="../css/style.css">
        <link rel="stylesheet" href="../css/mediaQuery.css">
        <link rel="stylesheet" href="../css/smart_editor2_in.css">
        <link rel="stylesheet" href="../css/smart_editor2_items.css">
        <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
        
        
        </head>

        <body>

        <section class="header">
        <!-- 왼쪽 상단 화살표 2개 -->
        <div class="page-flows">
      	<span class="flow"><a href="javascript:history.back();"> <i class="ion-chevron-left"></i> </a></span>		
        <span class="flow"> <i class="ion-chevron-right disabled"></i> </span>
        </div>

        <!-- 홈 이동 -->
        <div class = "home-page">
        <a href="../index.do" class="navigation__home__item">
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
                    <li><a href="../user/customer.do">FAQ</a></li>
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
        <div class="navigation__list__header" role="button" data-toggle="collapse" href="#main" aria-expanded="true"
        aria-controls="main">
        Main
        </div>

        <div class="collapse in" id="main">
        <a href="../main/search.do" class="navigation__list__item">
        <i class="ion-ios-browsers"></i>
        <span>감성 검색</span>
        </a>
        <a href="../main/share.do" class="navigation__list__item">
        <i class="ion-person-stalker"></i>
        <span>감정 공유</span>
        </a>

        </div>
        </div>
        <!-- / -->

        <!-- Your Music -->
        <div class="navigation__list">
        <div class="navigation__list__header" role="button" data-toggle="collapse" href="#yourMusic"
        aria-expanded="true" aria-controls="yourMusic">
        Your Music
        </div>

        <div class="collapse in" id="yourMusic">
        <a href="http://www.facebook.com/dialog/oauth?client_id=662302497285882&redirect_uri=http://localhost:9090/test/music/replay.do" class="navigation__list__item">
                    </a>
                        <i class="ion-headphone"></i>
                        <span>노래 다시듣기</span>
                    </a>
                    <a href="http://www.facebook.com/dialog/oauth?client_id=662302497285882&redirect_uri=http://localhost:9090/test/music/emotionlist.do" class="navigation__list__item">
                        <i class="ion-ios-musical-notes"></i>
                        <span>감정 그래프</span>
                    </a>
        </div>
        </div>
        <!-- / -->

        <!-- Playlists -->
        <div class="navigation__list">
        <div class="navigation__list__header" role="button" data-toggle="collapse" href="#playlists"
        aria-expanded="true" aria-controls="playlists">
        Playlists
        </div>

        <div class="collapse in" id="playlists">
        <a href="../playlist/toplist.do" class="navigation__list__item">
        <i class="ion-ios-musical-notes"></i>
        <span>Music TOP 10</span>
        </a>
        <a href="../playlist/emotion.do" class="navigation__list__item">
        <i class="ion-ios-musical-notes"></i>
        <span>감성 보기</span>
        </a>
        <a href="../playlist/randomplay.do" class="navigation__list__item">
        <i class="ion-ios-musical-notes"></i>
        <span>랜덤 듣기</span>
        </a>

        </div>
        </div>
        <!-- Bubble Chart-->
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

        <!-- 메인에 해당하는 부분 -->
        <div class="content__middle">

