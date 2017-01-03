<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Index</title>
<link href='https://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900italic,900' rel='stylesheet' type='text/css'>

<link rel='stylesheet prefetch'	href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
<link rel='stylesheet prefetch'	href='https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css'>
<link rel='stylesheet prefetch'	href='http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css'>
<link rel='stylesheet prefetch' href='css/nouislider.min.css'>
<link rel="stylesheet" href="css/style.css">
</head>

<body>

	<section class="header">
		<!-- 왼쪽 상단 화살표 2개 -->
		<div class="page-flows">
			<span class="flow"> <i class="ion-chevron-left"></i> </span>
			<span class="flow"> <i class="ion-chevron-right disabled"></i> </span>
		</div>
 
 		<!-- 홈 이동  -->
 		<div class = "home-page">
 			<a href="/test/index.do" class="navigation__home__item">
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
					<span class="first">권</span>
					<span class="last">혁준</span>
				</span>
			</div>

			<div class="user__actions">
				<div class="dropdown">
					<button class="dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
						<i class="ion-chevron-down"></i>
					</button>
					<ul class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenu1">
						<li><a href="./user/Private.do">개인 정보</a></li>
						<li><a href="./user/Customer.do">고객 센터</a></li>
						<li><a href="#">로그 아웃</a></li>
					</ul>
				</div>
			</div>
		</div>
	</section>

	<!-- 본문 -->
	<section class="content">
		<!-- 왼쪽의 메뉴 부분 -->
		<div class="content__left">
			<section class="navigation">
				<!-- Main -->
				<div class="navigation__list">
					<div class="navigation__list__header" role="button" data-toggle="collapse" href="#main" aria-expanded="true" aria-controls="main">
						Main
					</div>

					<div class="collapse in" id="main">
						<a href="./main/Search.do" class="navigation__list__item">
							<i class="ion-ios-browsers"></i>
							<span>감성 검색</span>
						</a>
						<a href="./main/Share.do" class="navigation__list__item">
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
						<a href="./music/Replay.do" class="navigation__list__item">
							<i class="ion-headphone"></i>
							<span>노래 다시듣기</span>
						</a>
						<a href="./music/Emotionlist.do" class="navigation__list__item">
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
						<a href="./playlist/Toplist.do" class="navigation__list__item">
							<i class="ion-ios-musical-notes"></i>
							<span>TOP 100</span>
						</a>
						<a href="./playlist/Emotion.do" class="navigation__list__item">
							<i class="ion-ios-musical-notes"></i>
							<span>감성 보기</span>
						</a>
						<a href="./playlist/Randomplay.do" class="navigation__list__item">
							<i class="ion-ios-musical-notes"></i>
							<span>랜덤 듣기</span>
						</a>
				
					</div>
				</div>
				<!-- / -->
			</section>

		</div>

		<!-- 메인에 해당하는 부분 -->
		<div class="content__middle">
		  <!-- 막대그래프 부분 -->
		  <svg width="600" height="400"></svg>
		  <script src="https://d3js.org/d3.v4.min.js"></script>
		  <script>
			var svg = d3.select("svg"),
			margin = {top: 20, right: 20, bottom: 30, left: 40},
			width = +svg.attr("width") - margin.left - margin.right,
			height = +svg.attr("height") - margin.top - margin.bottom; // 그래프 svg부분을 선택하고 크기조절
			
			var x = d3.scaleBand().rangeRound([0, width]).padding(0.1),
			y = d3.scaleLinear().rangeRound([height, 0]); // x축, y축의 범위 설정
			
			var g = svg.append("g")
			.attr("transform", "translate(" + margin.left + "," + margin.top + ")"); // 그래프에 g 추가
			
			d3.tsv("data.tsv", function(d) { // data.tsv 파일에 있는 데이터 불러오기
			d.song = +d.song;
			return d;
			}, function(error, data) {
			if (error) throw error;
			
			x.domain(data.map(function(d) { return d.emotion; }));       // x값은 tsv 데이터 중 emotion에 해당하는 값
			y.domain([0, d3.max(data, function(d) { return d.song; })]); // y값은 tsv 데이터 중 song에 해당하는 값
			
			g.append("g")
			  .attr("class", "axis axis--x")
			  .attr("transform", "translate(0," + height + ")")
			  .call(d3.axisBottom(x)); // x축 표시
			
			g.append("g")
			  .attr("class", "axis axis--y")
			  .call(d3.axisLeft(y))
        .append("text")
			  .attr("transform", "rotate(-90)")
			  .attr("y", 6)
			  .attr("dy", "0.71em")
			  .attr("text-anchor", "end")
			  .text("song"); // y축 표시
			
			g.selectAll(".bar")
			.data(data)
			.enter().append("rect")
			  .attr("class", "bar")
			  .attr("x", function(d) { return x(d.emotion); })
			  .attr("y", function(d) { return y(d.song); })
			  .attr("width", x.bandwidth())
			  .attr("height", function(d) { return height - y(d.song); }); // 각 데이터를 막대그래프로 표시
			});
		  </script>
		  <!-- 막대그래프 END --> 
		  </div>
	</section>

	<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>
	<script src='js/nouislider.min.js'></script>
	<script src="js/index.js"></script>

</body>
</html>
