<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file ="../header.jsp" %>
<link rel="stylesheet" href="../css/sentshare.css">
	
	<center><a style="font:20">감정 공유 게시판!</a></center>
	<br>
	
	<center>
	<table border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td id="a1" colspan="5" align="right"><input type="button" value="글쓰기" onclick="location.href='http://www.facebook.com/dialog/oauth?client_id=662302497285882&redirect_uri=http://localhost:9090/test/main/create.do'"></td>
		</tr>
		<tr>
			<td id="a2" colspan="5" align="right">전체 글 : ${count }</td>
		</tr>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>등록일</th>
		</tr>
		<c:forEach var="dto" items="${articleList }">
		<tr>
			<td>${dto.bbsno }</td>
			<td>
				<a href="http://www.facebook.com/dialog/oauth?client_id=662302497285882&redirect_uri=http://localhost:9090/test/main/read.do?bbsno=${dto.bbsno }">
					${dto.subject }
				</a>
				<c:if test="${dto.readcnt==10}">
					<img src="../image/hot.gif">
				</c:if>
			</td>
			<td>${dto.wname}</td>
			<td>${dto.readcnt}</td>
			<td>${fn:substring(dto.regdt, 0, 16)}</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="5" id="a3">
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
			</td>
		</tr>
		<tr>
			<td colspan="5" id="a4">
				<form name="frm" action="./share.do">
				<select name="searchCondition" class="sel">
					<option value="0" <c:if test="${searchCondition == 0 }">selected</c:if>>제목</option>
					<option value="1" <c:if test="${searchCondition == 1 }">selected</c:if>>내용</option>
					<option value="2" <c:if test="${searchCondition == 2 }">selected</c:if>>작성자</option>
				</select>
				<input type="text" name="word" value="${word}">
				<input type="submit" value="검색">
				</form>
			</td>
		</tr>
	</table>
	
	<!-- 페이지 리스트 -->
	</center>
	</div>
<%@ include file ="../footer.jsp" %>
	