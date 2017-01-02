<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Index Page</title>
<link href='https://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900italic,900' rel='stylesheet' type='text/css'>
<link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
<link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css'>
<link rel='stylesheet prefetch' href='http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css'>
<link rel='stylesheet prefetch' href='css/nouislider.min.css'>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

	<section class="header">
		<!-- 왼쪽 상단 화살표 2개 -->
		<div class="page-flows">
			<span class="flow"> <i class="ion-chevron-left disabled"></i>
			</span> <span class="flow"> <i class="ion-chevron-right disabled"></i>
			</span>
		</div>

		<!-- 검색창 -->
		<div class="search">
			<input type="text" placeholder="Search" />
		</div>

		<!-- 회원 정보 -->
		<div class="user">
			<!-- 로그인 하면 보여 줄 것
      <div class="user__notifications">
        <i class="ion-android-notifications"></i>
      </div>

      <div class="user__inbox">
        <i class="ion-archive"></i>
      </div>

      <div class="user__info">
        <span class="user__info__img">
          <img src="./image/adam_proPic.jpg" alt="Profile Picture" class="img-responsive" />
        </span>
        <span class="user__info__name">
          <span class="first">Adam</span>
          <span class="last">Lowenthal</span>
        </span>
      </div>
      -->

			<div class="user__actions">
				<div class="dropdown">
					<button class="dropdown-toggle" type="button" id="dropdownMenu1"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
						<i class="ion-chevron-down"></i>
					</button>
					<ul class="dropdown-menu dropdown-menu-right"
						aria-labelledby="dropdownMenu1">
						<!-- 로그인 하면 보여줄 것
            <li><a href="#">Private Session</a></li>
            <li><a href="#">Account</a></li>
            <li><a href="#">Settings</a></li>
            <li><a href="#">Log Out</a></li>
            -->
						<li><a href="#">Sign In</a></li>
						<li><a href="#">Sign Up</a></li>
					</ul>
				</div>
			</div>
		</div>
	</section>