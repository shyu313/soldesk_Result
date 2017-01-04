<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file ="../header.jsp" %>

	<a style="font:20">감정 공유 게시판!</a>
	
	<%-- <table>
		<tr>
			<th>그룹번호</th>
			<th>그룹명</th>
			<th>명령</th>
		</tr>
		<c:forEach var="dto" items="${list }">
		<tr>
			<td>${dto.mediagroupno }</td>
			<td><a href="../media/list.do?mediagroupno=${dto.mediagroupno }">${dto.title }</a></td>
			<td>
				<input type="button" value="수정" onclick="location.href='./update.do?mediagroupno=${dto.mediagroupno}'">
				<input type="button" value="삭제" onclick="location.href='./delete.do?mediagroupno=${dto.mediagroupno}'">
			</td>
		</tr>
		</c:forEach>
	</table> --%>
	
	</div>

	
<%@ include file ="../footer.jsp" %>
	