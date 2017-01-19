<%@ page contentType="text/html; charset=UTF-8"%>
  </div>
    <!-- 유투브 플레이어 부분-->
    <script> var id = '${videoId}'</script>	 <!--  변수가 .js 내에서 동작이 안됨. jsp 내에서 선언한다.-->
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
    <script src="../js/share.js"></script>
	<script src="../js/youtube.js"></script>
	<script src="../js/facebook.js"></script>
	
	
    <!-- D3 Script-->
    <script src="http://phuonghuynh.github.io/js/bower_components/jquery/dist/jquery.min.js"></script>
    <script src="http://phuonghuynh.github.io/js/bower_components/d3/d3.min.js"></script>
    <script src="http://phuonghuynh.github.io/js/bower_components/d3-transform/src/d3-transform.js"></script>
    <script src="http://phuonghuynh.github.io/js/bower_components/cafej/src/extarray.js"></script>
    <script src="http://phuonghuynh.github.io/js/bower_components/cafej/src/misc.js"></script>
    <script src="http://phuonghuynh.github.io/js/bower_components/cafej/src/micro-observer.js"></script>
    <script src="http://phuonghuynh.github.io/js/bower_components/microplugin/src/microplugin.js"></script>
    <script src="http://phuonghuynh.github.io/js/bower_components/bubble-chart/src/bubble-chart.js"></script>
    <script src="http://phuonghuynh.github.io/js/bower_components/bubble-chart/src/plugins/central-click/central-click.js"></script>
    <script src="http://phuonghuynh.github.io/js/bower_components/bubble-chart/src/plugins/lines/lines.js"></script>
    <script src="../js/d3_Bubble_Chart.js"></script>
    <script src="../js/d3_Simple_Dashboard.js"></script>

	<!-- smartEdit Script -->
    <script type="text/javascript" charset="utf-8" src="../js/smartEdit/HuskyEZCreator.js"></script> 	
    </body>
    </html>
    