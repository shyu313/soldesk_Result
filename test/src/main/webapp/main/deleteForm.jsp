<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file ="../header.jsp" %>

	<div class="title"><font color="#ffffff">내용 삭제</font></div>
	<form name="frm" method="post" action="./delete.do">
		<input type="hidden" name="bbsno" value="${dto.bbsno }">
		<div class="content">
		<font color="#ffffff">
			<p>해당 내용을 삭제합니다</p>
			<p>해당 내용을 삭제 하시겠습니까?</p>
		</font>
		</div>
		<div class='bottom'>
			<input type="submit" value="삭제진행">
			<input type="button" value="목록" onclick="location.href='./list.do'">
		</div>
	</form>
	
	</div>

	
<%@ include file ="../footer.jsp" %>
	