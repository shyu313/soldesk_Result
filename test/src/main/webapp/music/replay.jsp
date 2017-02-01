<%@ page contentType="text/html; charset=UTF-8"%>
<link rel="stylesheet" href="../css/replaytable.css">
<%@ include file ="../header.jsp" %>
	<div class="table-users">
		<div id="header">Replay</div>
		<table>
			<tr>
				<th>사용자</th>
				<th>노래 제목</th>
				<th>재생 시간</th>
				<th>노래 감정</th>
			</tr>
			<c:forEach var="dto" items="${list }">
				<tr>
					<td>${dto.userId }</td>
					<td>${dto.title}</td>
					<td>${dto.time}</td>
					<td>${dto.emotion }</td>
				</tr>
			</c:forEach>
			<tr>
			</tr>
		</table>
	</div>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.3.min.js"></script>  	
<%@ include file ="../footer.jsp" %>