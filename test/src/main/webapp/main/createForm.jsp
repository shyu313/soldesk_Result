<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file ="../header.jsp" %>
<link rel="stylesheet" href="../css/sentshareinsert.css">
<script type="text/javascript" src="../js/createForm.js"></script>

	<script>
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
	<form name="bbsform" method="post" action="create.do">
	<table border="1" cellpadding="0" cellspacing="0">
	<tr>
		<th><font color="#FFFFFF">작성자</font></th>
		<td>
			<!-- <input type="text" id="wname" name="wname" size="20" readonly> -->
			<input type="text" id="wname" name="wname" readonly>
		</td>
	</tr>
	<tr>
		<th><font color="#FFFFFF">제목</font></th>
		<!-- <td><input type="text" id="subject" name="subject" size="100"></td> -->
		<td><input type="text" id="subject" name="subject"></td>
	</tr>
	<tr>
		<th><font color="#FFFFFF">내용</font></th>
		<td>
			<!-- <textarea name="content" id="content" style="HEIGHT: 220px; WIDTH: 610px;" rows="10" cols="30"></textarea> -->
			<textarea name="content" id="content" style="max-width: 100%"></textarea>
		</td>
	</tr>

	<tr>
		<td colspan="2" id="a1">
			<input type="button" id="cs1" value="쓰기" onclick="validate(this.form);">
			<!-- <input type="submit" id="cs1" value="쓰기" onclick="validate(this.form)"> -->
			<input type="reset" value="취소" onclick="location.href='share.do';">
		</td>
	</tr>
	</table>
	</form>
	
	</div>

	
<%@ include file ="../footer.jsp" %>
	