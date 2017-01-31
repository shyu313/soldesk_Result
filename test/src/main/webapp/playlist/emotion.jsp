<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file ="../header.jsp" %>

	<center><a style="font:20">감성 노래 리스트 </a></center>
	<br>
	
	<center>
	<table border="1" cellpadding="0" cellspacing="0">
		<tr style="font-family: 나눔고딕">
			<td><strong><font size="4"  color="#ffffff">감정타입</font></strong></td>
			<td><strong><font size="4"  color="#ffffff">제목 - Click to play</font></strong></td>
			<td><strong><font size="4"  color="#ffffff">가수</font></strong></td>
			<td><strong><font size="4"  color="#ffffff">재생횟수</font></strong></td>
			<td><strong><font size="4"  color="#ffffff">추천수</font></strong></td>
		</tr>
		<c:forEach var="dto" items="${emotionMusicList }">
		<tr>
			<td><font color="#ffffff">${dto.emotion }</font></td>
			<td><font color="#ffffff"><a href="searchplay.do?lyricsNo=${dto.lyricsNo }">${dto.title }</a></font></td>
			<td><font color="#ffffff">${dto.singer}</font></td>
			<td><font color="#ffffff">${dto.playCnt}</font></td>
			<td><font color="#ffffff">${dto.recCnt }</font></td>
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
	</table>
	</center>
	</div>
<%@ include file ="../footer.jsp" %>
	