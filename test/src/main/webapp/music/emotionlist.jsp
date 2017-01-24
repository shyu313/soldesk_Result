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
	
 
    <div id="chart"></div>
  
  
 <table width="500" border="1" cellpadding="0" cellspacing="0">
		<tr>
			<th><font color="#ffffff">사용자</font></th>
			<th><font color="#ffffff">노래 제목</font></th>
			<th><font color="#ffffff">재생 시간</font></th>
			<th><font color="#ffffff">노래 감정</font></th>
		</tr>
		<c:forEach var="dto" items="${list }">
		<tr>
			<td><font color="#ffffff">${dto.userId }</font></td>
			<td><font color="#ffffff">${dto.title}</font></td>
			<td><font color="#ffffff">${dto.time}</font>
			</td>
			<td><font color="#ffffff">${dto.emotion }</font></td>
		</tr>
		</c:forEach>
	</table>
  
<%@ include file ="../footer.jsp" %>

<script src="../js/d3_DayHour_Heatmap.js"></script>