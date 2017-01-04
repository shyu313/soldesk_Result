<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file ="../header.jsp" %>

	<a style="font:20">감정 공유 게시판!</a><br>
	<input type="button" value="글쓰기" onclick="location.href='../main/create.do'">
	<table cellpadding="0" cellspacing="0" >
		<tr>
			<th><font color="#ffffff">번호</font></th>
			<th><font color="#ffffff">제목</font></th>
			<th><font color="#ffffff">작성자</font></th>
			<th><font color="#ffffff">조회수</font></th>
			<th><font color="#ffffff">등록일</font></th>
		</tr>
		<c:forEach var="dto" items="${list }">
		<tr>
			<td><font color="#ffffff">${dto.bbsno }</font></td>
			<td>
				<font color="#ffffff"><a href="read.do?bbsno=${dto.bbsno }">${dto.subject }</a></font>
				<c:if test="${dto.readcnt==10}">
					<img src="../images/hot.gif">
				</c:if>
			</td>
			<td><font color="#ffffff">${dto.wname}</font></td>
			<td><font color="#ffffff">${dto.readcnt}</font>
			</td>
			<td><font color="#ffffff">${dto.regdt}</font></td>
		</tr>
		</c:forEach>
	</table>
	
	<br><br>
	
	<select>
		<option value="title">제목</option>
		<option value="content">내용</option>
		<option value="wname">작성자</option>
	</select>
	<input type="text" name="search">
	<input type="button" value="검색">
	
	</div>

	
<%@ include file ="../footer.jsp" %>
	