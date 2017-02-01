<%@ page contentType="text/html; charset=UTF-8"%>
<link rel="stylesheet" href="../css/randomtable.css">
<%@ include file="../header.jsp"%>
	<div class="table-users">
		<div id="header">Random Play</div>
		<table>
			<tr>
				<th>play</th>
				<th>Title</th>
				<th>Singer</th>
				<th>playCnt</th>
				<th>recCnt</th>
				<th></th>
			</tr>
			<c:forEach var="dto" items="${randomList }">
				<tr>
					<td><a href="randomplay.do?lyricsNo=${dto.lyricsNo }"><img
							src="../img/playbutton1.jpg" alt="" /></a></td>
					<td>${dto.title}</td>
					<td>${dto.singer}</td>
					<td>${dto.playCnt}</td>
					<td>${dto.recCnt }</td>
					<td></td>
				</tr>
			</c:forEach>
			<tr>
			</tr>
		</table>
	</div>
		<%@ include file="../footer.jsp"%>