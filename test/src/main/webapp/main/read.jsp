<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file ="../header.jsp" %>
<link rel="stylesheet" href="../css/sentshareread.css">
<input type="hidden" name="noticeno" value=${dto.bbsno }>

	<a style="font:20">감정 공유 게시판!</a>
	
	* 게시글 상세보기 *<br>
	
	<table border="1" cellpadding="0" cellspacing="0">
		<tr>
			<th><font color="#ffffff">번호</font></th>
			<td><font color="#ffffff">${dto.bbsno}</font></td>
			<th><font color="#ffffff">작성자</font></th>
			<td><font color="#ffffff">${dto.wname }</font></td>
		</tr>
		<tr>
			<th><font color="#ffffff">조회수</font></th>
			<td><font color="#ffffff">${dto.readcnt}</font></td>
			<th><font color="#ffffff">등록일</font></th>
			<td><font color="#ffffff">${dto.regdt }</font></td>
		</tr>
		<tr>
			<th><font color="#ffffff">제목</font></th>
			<td colspan="3"><font color="#ffffff">${dto.subject}</font></td>
		</tr>
		<tr>
			<th><font color="#ffffff">내용</font></th>
			<td colspan="3"><font color="#ffffff">${dto.content}</font></td>
		</tr>
		<tr>
			<td colspan="4" id="a1">
				<input type="button" value="쓰기" onclick="location.href='./create.do'">
				<input type="button" value="목록" onclick="location.href='./share.do'">
				<input type="button" value="수정" onclick="location.href='./update.do?bbsno=${dto.bbsno}'">
				<input type="button" value="삭제" onclick="location.href='./delete.do?bbsno=${dto.bbsno}'">
			</td>
		</tr>
	</table>
	</div>

	
<%@ include file ="../footer.jsp" %>
	