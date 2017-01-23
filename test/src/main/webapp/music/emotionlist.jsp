<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file ="../header.jsp" %>
  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> 
<script src="../js/calendar.js"></script>
<link rel="stylesheet" type="text/css" href="../css/calendar.css"> 
<style>
#departure {font-size:20px;height:40px;line-height:40px}
</style>


<input type="text" id="departure" readonly/>

<script>$("#departure").dateDropper();</script>
	
  
  <script>
    $(document).ready(function () {
        var $cnts = $('.text'); // cnt 배열
        $cnts.change(function () { // input값이 변화가 있을 때 발생하는 이벤트
            for (var i = 0; i < $cnts.length; i++) {
                // input 값 가져오기
                console.log(i + ' index input - ' + $cnts.eq(i).val());
                alert("!!!!!!!!!!!");
            }
        });

    });
</script>

    <div id="chart"></div>
  
  
<%@ include file ="../footer.jsp" %>

<script src="../js/d3_DayHour_Heatmap.js"></script>