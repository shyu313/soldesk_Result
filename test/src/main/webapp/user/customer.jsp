<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file ="../header.jsp" %>
<link rel="stylesheet" type="text/css" href="../css/faq.css"/>

<div class="faq">
	<div class="faqHeader">
		<h1>FAQ</h1>
		<button type="button" class="showAll">답변 모두 여닫기</button>
	</div>
	<ul class="faqBody">
		<li class="article" id="a1">
			<p class="q" height="90px"><a href="#a1">Q: 공지사항 1</a></p>
			<p class="a">A:공지사항1 내용입니다</p>
		</li>
		<li class="article" id="a2">
			<p class="q"><a href="#a2">Q:공지사항2</a></p>
			<p class="a">A:공지사항2 내용</p>
		</li>
		<li class="article" id="a3">
			<p class="q"><a href="#a3">Q: 공지사항3</a></p>
			<p class="a">A: 공지사항3 내용</p>
		</li>
	</ul>
</div>
<br />
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script> 
<script type="text/javascript" src="../js/customer.js"></script>

<%@ include file ="../footer.jsp" %>
	