<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file ="../header.jsp" %>
<!-- 대시보드 호출 -->
	 <script>
	 	var jsonTopTen='${jsonTopTen }'			// top10 감정별 점수 jsonArray
	 	</script>	
<center>
<div id='dashboard'></div>
</center>

<!-- 탑 리스트 -->
	<center><a style="font:20"> Music Top 10 </a></center>
	<br>
	
	<center>
	<table width="500" border="1" cellpadding="0" cellspacing="0" id="randombox">
		<tr style="font-family: 나눔고딕">
			<td><strong><font size="4"  color="#ffffff">Top</font></strong></td>
			<td><strong><font size="4"  color="#ffffff">제목 - Click to play</font></strong></td>
			<td><strong><font size="4"  color="#ffffff">가수</font></strong></td>
			<td><strong><font size="4"  color="#ffffff">재생횟수</font></strong></td>
			<td><strong><font size="4"  color="#ffffff">추천수</font></strong></td>
		</tr>
		<c:forEach var="dto" items="${topList }">
		<tr>
			<td><font color="#ffffff">${dto.RNUM }</font></td>
			<td><font color="#ffffff"><a href="toplistplay.do?lyricsNo=${dto.lyricsNo }">${dto.title }</a></font></td>
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