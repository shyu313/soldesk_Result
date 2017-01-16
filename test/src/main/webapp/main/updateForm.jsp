<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file ="../header.jsp" %>
	
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
	        /* $("#savebutton").click(function(){
	            //id가 smarteditor인 textarea에 에디터에서 대입
	            editor_object.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);
			             
	            // 이부분에 에디터 validation 검증
			             
	            //폼 submit
	            $("#frm").submit();
	        }); */
	    });
		
		function statusChangeCallback(response) {
		    //console.log('statusChangeCallback');
		    //console.log(response);
		    // The response object is returned with a status field that lets the
		    // app know the current login status of the person.
		    // Full docs on the response object can be found in the documentation
		    // for FB.getLoginStatus().
		    if (response.status === 'connected') {
		      // Logged into your app and Facebook.
		      testAPI();
		    } else if (response.status === 'not_authorized') {
		      // The person is logged into Facebook, but not your app.
		      /* document.getElementById('status').innerHTML = 'Please log ' +
		        'into this app.'; */
		    } else {
		      // The person is not logged into Facebook, so we're not sure if
		      // they are logged into this app or not.
		      /* document.getElementById('status').innerHTML = 'Please log ' +
		        'into Facebook.'; */
		    }
		  }

		  // This function is called when someone finishes with the Login
		  // Button.  See the onlogin handler attached to it in the sample
		  // code below.
		  function checkLoginState() {
		    FB.getLoginStatus(function(response) {
		      statusChangeCallback(response);
		    });
		  }

		  window.fbAsyncInit = function() {
		  FB.init({
		    appId      : '662302497285882',
		    cookie     : true,  // enable cookies to allow the server to access 
		                        // the session
		    xfbml      : true,  // parse social plugins on this page
		    version    : 'v2.8' // use graph api version 2.8
		  });

		  // Now that we've initialized the JavaScript SDK, we call 
		  // FB.getLoginStatus().  This function gets the state of the
		  // person visiting this page and can return one of three states to
		  // the callback you provide.  They can be:
		  //
		  // 1. Logged into your app ('connected')
		  // 2. Logged into Facebook, but not your app ('not_authorized')
		  // 3. Not logged into Facebook and can't tell if they are logged into
		  //    your app or not.
		  //
		  // These three cases are handled in the callback function.

		  FB.getLoginStatus(function(response) {
		    statusChangeCallback(response);
		  });

		  };
		  
		  // Load the SDK asynchronously
		(function(d, s, id) {
		  var js, fjs = d.getElementsByTagName(s)[0];
		  if (d.getElementById(id)) return;
		  js = d.createElement(s); js.id = id;
		  js.src = "//connect.facebook.net/ko_KR/sdk.js#xfbml=1&version=v2.8&appId=662302497285882";
		  fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));

		  // Here we run a very simple test of the Graph API after login is
		  // successful.  See statusChangeCallback() for when this call is made.
		  function testAPI() {
		    //console.log('Welcome!  Fetching your information.... ');
		    FB.api('/me', function(response) {
		      //console.log('Successful login for: ' + response.name);
		      /* document.getElementById('status').innerHTML =
		        response.name + '님의 로그인을 환영합니다!'; */
		      document.getElementById('wname').value = response.name;
		      //document.getElementById('wname').innerHTML = response.name;
		    });
		  }
	</script>
	
	<a style="font:20">감정 공유 게시판!</a>
	<p>
		<a href="share.do">[목록]</a>
	</p>
	<form name="bbsform" method="post" action="update.do">
	<input type="hidden" name="bbsno" value="${dto.bbsno }">
	<table>
	<tr>
		<th><font color="#FFFFFF">작성자</font></th>
		<td>
			<input type="text" name="wname" value="${dto.wname }" size="10" readonly>
			<!-- <div id="wname" style="color:#FFFFFF;"></div> -->
		</td>
	</tr>
	<tr>
		<th><font color="#FFFFFF">제목</font></th>
		<td><input type="text" name="subject" value="${dto.subject }" size="84"></td>
	</tr>
	<tr>
		<th><font color="#FFFFFF">내용</font></th>
		<td>
			<textarea id="content" style="HEIGHT: 220px; WIDTH: 610px; background: white;" rows="10" cols="30" name="content">
				${dto.content }
			</textarea>
		</td>
	</tr>
	<!-- <tr>
		<th><font color="#FFFFFF">비밀번호</font></th>
		<td><input type="password" name="passwd" size="10"></td>
	</tr> -->
	<tr>
		<td colspan="2" align="center">
			<!-- <input type="button" value="쓰기" onClick="bbsCheck(this.form)"> -->
			<input type="submit" value="쓰기">
			<input type="reset" value="취소" onclick="location.href='share.do';">
		</td>
	</tr>
	</table>
	</form>
	
	</div>

	
<%@ include file ="../footer.jsp" %>
	