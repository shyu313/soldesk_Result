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
	
	<c:if test="${count > 0 }">
		<a href="./share.do?pageNum=${startPage }">[이전]</a>
		<c:forEach var="i" begin="1" end="${count/10 }">
			<a href="./share.do?pageNum=${i }">[${i }]</a>
		</c:forEach>
		<a href="./share.do?pageNum=${startPage+11 }">[다음]</a>
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

	<script>
		var searchCondition = "${param.searchCondition}"
		jQuery(document).ready(function($){
			$(".sel option:selected").val();
			if(searchCondition == 0){
				$(".sel").val("0");
			}
			else if(searchCondition == 1){
				$(".sel").val("1");
			}
			else if(searchCondition == 2){
				$(".sel").val("2");
			}
		});
	</script>
	
<%@ include file ="../footer.jsp" %>
	