<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file ="../header.jsp" %>
<form method="post" action="./search.do" name="searchForm" id="searchForm">
	<input type="hidden" id="#emotion1"  name="word1Emotion">
	<input type="hidden" id="#emotion2"  name="word2Emotion">
	<input type="hidden" id="#emotion3"  name="word3Emotion">
	
	<input type="text" id="#1"  name="word1">
	<input type="text" id="#2"  name="word2">
	<input type="text" id="#3"  name="word3"> 
	<input type="submit" value="검색">
</form>
	
	<script>	
		// mainBubble div 를 생성하기 전에 데이터를 받아야 하므로 스크립트 삽입
		var jsonBubbleMenu = '${jsonBubbleMenu }'
		</script>
	
	<div id="mainBubble"></div>
	
	<!-- 탑 리스트 -->
	<center><a style="font:20"> Emotion Music List </a></center>
	<br>
	
	<center>
	<table width="500" border="1" cellpadding="0" cellspacing="0">
		<tr>
			<th><font color="#ffffff">번호</font></th>
			<th><font color="#ffffff">노래제목</font></th>
			<th><font color="#ffffff">가수</font></th>
			<th><font color="#ffffff">재생횟수</font></th>
			<th><font color="#ffffff">추천수</font></th>
		</tr>
		<c:forEach var="dto" items="${topList }">
		<tr>
			<td><font color="#ffffff"></font></td>
			<td>
				<font color="#ffffff"><a href="read.do?lyricsNo=${dto.lyricsNo }">${dto.title }</a></font>
			</td>
			<td><font color="#ffffff">${dto.singer}</font></td>
			<td><font color="#ffffff">${dto.playCnt}</font>
			</td>
			<td><font color="#ffffff">${dto.recCnt }</font></td>
		</tr>
		</c:forEach>
	</table>
	
	<br><br>
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
		<option value="0">제목</option>
		<option value="1">내용</option>
		<option value="2">작성자</option>
	</select>
	<input type="text" name="word" value="${param.word}">
	<input type="submit" value="검색">
	</form>
	</center>
	</div>
	
	
	
<%@ include file ="../footer.jsp" %>
<script src="../js/d3_Bubble_Menu.js"></script>
