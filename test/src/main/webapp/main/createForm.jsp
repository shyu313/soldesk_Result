<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file ="../header.jsp" %>
	<script<%--  src="<c:url value='https://code.jquery.com/jquery-1.11.0.min.js'/>" --%>>
		$(function(){
	        //전역변수선언
	        var editor_object = [];
	
	        nhn.husky.EZCreator.createInIFrame({
	            oAppRef: editor_object,
	            elPlaceHolder: "content",
	            sSkinURI: "../main/SmartEditor2Skin.html",
	            htParams : {
	                // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
	                bUseToolbar : true,            
	                // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
	                bUseVerticalResizer : true,    
	                // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
	                bUseModeChanger : true,
	            },
	            fCreator:"createSEditor2"
	        });
			         
	        //전송버튼 클릭이벤트
	        $("#cs1").click(function(){
	            //id가 smarteditor인 textarea에 에디터에서 대입
	            editor_object.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);
			             
	            // 이부분에 에디터 validation 검증
			             
	            //폼 submit
	            $("#frm").submit();
	        });
	    });
		

	</script>

	<a style="font:20">감정 공유 게시판!</a>
	<p>
		<a href="share.do">[목록]</a>
	</p>
	<form name="bbsform" method="post" action="create.do">
	<table width="752">
	<tr>
		<th><font color="#FFFFFF">작성자</font></th>
		<td>
			<input type="text" id="wname" name="wname" size="10" readonly>
		</td>
	</tr>
	<tr>
		<th><font color="#FFFFFF">제목</font></th>
		<td><input type="text" name="subject" size="100"></td>
	</tr>
	<tr>
		<th><font color="#FFFFFF">내용</font></th>
		<td>
			<textarea name="content" id="content" style="HEIGHT: 220px; WIDTH: 610px;" rows="10" cols="30"></textarea>
		</td>
	</tr>

	<tr>
		<td colspan="2" align="center">
			<!-- <input type="button" value="쓰기" onClick="bbsCheck(this.form)"> -->
			<input type="submit" id="cs1" value="쓰기">
			<input type="reset" value="취소" onclick="location.href='share.do';">
		</td>
	</tr>
	</table>
	</form>
	
	</div>

	
<%@ include file ="../footer.jsp" %>
	