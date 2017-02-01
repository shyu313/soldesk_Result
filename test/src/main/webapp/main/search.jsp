<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file ="../header.jsp" %>
<form method="post" action="./search.do" name="searchForm" id="searchForm">
	<input type="text" id="#1"  name="word1">
	<input type="text" id="#2"  name="word2">
	<input type="text" id="#3"  name="word3"> 
	<input type="submit" value="검색">
</form>
	
	<script>	
		// mainBubble div 를 생성하기 전에 데이터를 받아야 하므로 스크립트 삽입
		var jsonBubbleMenu = '${jsonBubbleMenu }'
		</script>
	
	<div id="mainBubble"></div>
	
	<!-- 추천 리스트 -->
	<center><a style="font:20"> Emotion Music List </a></center>
	<br>
	
	<center>
	<table width="500" border="1" cellpadding="0" cellspacing="0" id="randombox">
		<tr style="font-family: 나눔고딕">
			<td><strong><font size="4"  color="#ffffff">감정타입</font></strong></td>
			<td><strong><font size="4"  color="#ffffff">제목 - Click to play</font></strong></td>
			<td><strong><font size="4"  color="#ffffff">가수</font></strong></td>
			<td><strong><font size="4"  color="#ffffff">재생횟수</font></strong></td>
			<td><strong><font size="4"  color="#ffffff">추천수</font></strong></td>
			
		</tr>
		<c:forEach var="dto" items="${recommendList }">
		<tr>
			<td><font color="#ffffff">${dto.emotion }</font></td>
			<td><font color="#ffffff"><a href="searchplay.do?lyricsNo=${dto.lyricsNo }&emotion=${dto.emotion }">${dto.title }</a></font></td>
			<td><font color="#ffffff">${dto.singer}</font></td>
			<td><font color="#ffffff">${dto.playCnt}</font></td>
			<td><font color="#ffffff">${dto.recCnt }</font></td>
		</tr>
		</c:forEach>
	</table>
	<br><br>
	</center>
	
	
</div>
<%@ include file ="../footer.jsp" %>
<script src="../js/d3_Bubble_Menu.js"></script>
