<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file ="../header.jsp" %>
<!-- 대시보드 호출 -->
<div id='dashboard'></div>
<!-- 탑 리스트 -->
	<center><a style="font:20"> Music Top 10 </a></center>
	<br>
	
	<center>
	<table width="500" border="1" cellpadding="0" cellspacing="0">
		<tr>
			<th><font color="#ffffff">Top</font></th>
			<th><font color="#ffffff">제목 - Click play</font></th>
			<th><font color="#ffffff">가수</font></th>
			<th><font color="#ffffff">재생횟수</font></th>
			<th><font color="#ffffff">추천수</font></th>
		</tr>
		<c:forEach var="dto" items="${topList }">
		<tr>
			<td><font color="#ffffff">${dto.RNUM }</font></td>
			<td>
				<font color="#ffffff"><a href="toplistplay.do?lyricsNo=${dto.lyricsNo }">${dto.title }</a></font>
			</td>
			<td><font color="#ffffff">${dto.singer}</font></td>
			<td><font color="#ffffff">${dto.playCnt}</font>
			</td>
			<td><font color="#ffffff">${dto.recCnt }</font></td>
		</tr>
		</c:forEach>
	</table>
	<br><br>
	</center>
	
	</div>
<%@ include file ="../footer.jsp" %>