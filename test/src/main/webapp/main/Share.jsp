<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file ="../header.jsp" %>

	
	<center><a style="font:20">감정 공유 게시판!</a></center>
	<br>
	
	<center>
	<table width="500" border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td colspan="5" align="right"><input type="button" value="글쓰기" onclick="location.href='../main/create.do'"></td>
		</tr>
		<tr>
			<td colspan="5" align="right"><font color="#ffffff">전체 글 : ${count }</font></td>
		</tr>
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
			<%-- <td><font color="#ffffff">${dto.regdt}</font></td> --%>
			<td><font color="#ffffff">${fn:substring(dto.regdt, 0, 16)}</font></td>
		</tr>
		</c:forEach>
	</table>
	
	<br><br>
		<%-- <a href="./Share.do?pageNum=${startPage }">[이전]</a>
		<a href="./Share.do?pageNum=${i }">[${i }]</a>
		<a href="./Share.do?pageNum=${startPage+11 }">[다음]</a> --%>
	<br><br>
	
	<select>
		<option value="title">제목</option>
		<option value="content">내용</option>
		<option value="wname">작성자</option>
	</select>
	<input type="text" name="word">
	<input type="button" value="검색">
	</center>
	
	</div>

	
<%@ include file ="../footer.jsp" %>
	