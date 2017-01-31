<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file ="../header.jsp" %>
	<a>랜덤 플레이</a>
<center>
	<table border="1.5" cellpadding="0" cellspacing="0" width="500"  id="randombox">
		<tr style="font-family: 나눔고딕">
			<td><strong><font size="4" color="#ffffff">제목 - Click to play</font></strong></td>
			<td><strong><font size="4" color="#ffffff">가수</font></strong></td>
			<td><strong><font size="4" color="#ffffff">재생횟수</font></strong></td>
			<td><strong><font size="4" color="#ffffff">추천수</font></strong></td>
		</tr>
		<c:forEach var="dto" items="${randomList }">
		<tr>
			<td><font color="#ffffff"><a href="randomplay.do?lyricsNo=${dto.lyricsNo }">${dto.title }</a></font></td>
			<td><font color="#ffffff">${dto.singer}</font></td>
			<td><font color="#ffffff">${dto.playCnt}</font></td>
			<td><font color="#ffffff">${dto.recCnt }</font></td>
		</tr>
		</c:forEach>
	</table>
</center>
	</div>
<%@ include file ="../footer.jsp" %>
	