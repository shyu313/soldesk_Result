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
		<c:forEach var="dto" items="${articleList }">
		<tr>
			<td><font color="#ffffff">${dto.bbsno }</font></td>
			<td>
				<font color="#ffffff"><a href="read.do?bbsno=${dto.bbsno }">${dto.subject }</a></font>
				<c:if test="${dto.readcnt==10}">
					<img src="../image/hot.gif">
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
	
	<%-- <c:if test="${count > 0 }">
		<a href="./share.do?pageNum=${startPage }">[이전]</a>
		<c:forEach var="i" begin="1" end="${count/10 }">
			<a href="./share.do?pageNum=${i }">[${i }]</a>
		</c:forEach>
		<a href="./share.do?pageNum=${startPage+11 }">[다음]</a>
	</c:if> --%>
	
	<!-- 페이지 리스트 -->
	<c:if test="${count>0 }">
		<c:set var="pageCount" value="${totalPage }"/>
		<c:set var="startPage" value="${startPage }"/>
		<c:set var="endPage" value="${endPage }"/>
		
		<c:if test="${endPage>pageCount }">
			<c:set var="endPage" value="${pageCount+1 }"/>
		</c:if>
		
		<c:if test="${startPage>0 }">
			<a href="./share.do?pageNum=${startPage }">[이전]</a>
		</c:if>
		
		<c:forEach var="i" begin="${startPage+1 }" end="${endPage-1 }">
			<a href="./share.do?pageNum=${i }">[${i }]</a>
		</c:forEach>
		
		<c:if test="${endPage<pageCount }">
			<a href="./share.do?pageNum=${startPage+11 }">[다음]</a>
		</c:if>
	</c:if>
	<br><br>
	
	<form name="frm" action="./share.do">
	<select name="searchCondition" class="sel">
		<option value="0" <c:if test="${searchCondition == 0 }">selected</c:if>>제목</option>
		<option value="1" <c:if test="${searchCondition == 1 }">selected</c:if>>내용</option>
		<option value="2" <c:if test="${searchCondition == 2 }">selected</c:if>>작성자</option>
	</select>
	<input type="text" name="word" value="${word}">
	<input type="submit" value="검색">
	</form>
	</center>
	</div>
<%@ include file ="../footer.jsp" %>
	