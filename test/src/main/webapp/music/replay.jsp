<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file ="../header.jsp" %>
<link rel="stylesheet" type="text/css" href="../css/faq.css"/>


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

<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.3.min.js"></script>  	
<%@ include file ="../footer.jsp" %>
	