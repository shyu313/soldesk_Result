<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file ="../header.jsp" %>

	<a style="font:20">감정 공유 게시판!</a>
	<p>
		<a href="bbsList.jsp">[목록]</a>
	</p>
	<form name="bbsform" method="post" action="update.do">
	<input type="hidden" name="bbsno" value="${dto.bbsno }">
	<table>
	<tr>
		<th><font color="#FFFFFF">작성자</font></th>
		<td><input type="text" name="wname" value="${dto.wname }" size="10"></td>
	</tr>
	<tr>
		<th><font color="#FFFFFF">제목</font></th>
		<td><input type="text" name="subject" value="${dto.subject }" size="30"></td>
	</tr>
	<tr>
		<th><font color="#FFFFFF">내용</font></th>
		<td>
			<textarea rows="5" cols="30" name="content">${dto.content }</textarea>
		</td>
	</tr>
	<tr>
		<th><font color="#FFFFFF">비밀번호</font></th>
		<td><input type="password" name="passwd" size="10"></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<!-- <input type="button" value="쓰기" onClick="bbsCheck(this.form)"> -->
			<input type="submit" value="쓰기">
			<input type="reset" value="취소">
		</td>
	</tr>
	</table>
	</form>
	
	</div>

	
<%@ include file ="../footer.jsp" %>
	