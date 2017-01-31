<%@page import="java.util.Arrays"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file ="../header.jsp" %>
  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> 
<script src="../js/calendar.js"></script>
<link rel="stylesheet" type="text/css" href="../css/calendar.css"> 
<style>
#departure {font-size:20px;height:40px;line-height:40px}
</style>
<!-- 

<input type="text" id="departure" readonly/> -->

<script>$("#departure").dateDropper();</script>
	
 
    <div id="chart"></div> 
  	<%-- <%
	
	int arr[][] = new int[7][24];
	%>
	<c:forEach var="dto" items="${datelist }">
	if(${dto.emotion}=="happy")
	{arr[0][${dto.time}] = ${dto.value };
	}
	else if(${dto.emotion}=="sad")
	{arr[1][${dto.time}] = ${dto.value };
	}
	else if(${dto.emotion}=="disgust")
	{arr[2][${dto.time}] = ${dto.value };
	}
	</c:forEach> --%>
  
   <table width="500" border="1" cellpadding="0" cellspacing="0">
		<tr>
			<th><font color="#ffffff">재생 시간</font></th>
			<th><font color="#ffffff">노래 감정</font></th>
			<th><font color="#ffffff">재생 횟수</font></th>
		</tr>
		<c:forEach var="dto" items="${datelist }">
		<tr>
			<td><font color="#ffffff">${dto.time}</font></td>
			<td><font color="#ffffff">${dto.emotion }</font></td>
			<td><font color="#ffffff">${dto.value }</font></td>
		</tr>
		</c:forEach>
	</table>
  
  
<%@ include file ="../footer.jsp" %>

<script src="../js/d3_DayHour_Heatmap.js"></script>