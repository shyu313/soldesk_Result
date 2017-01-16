<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file ="../header.jsp" %>
<link rel="stylesheet" type="text/css" href="../css/faq.css"/>

<h2 style ="color:#ffffff">FAQ</h2>
  
  <start>
        <li class="collapsible">
            <h2 class="title"><a href="#emotion">감정 사전이란 무엇인가요</a></h2>
            <p class="content">감정 사전은 각 단어에 대해 점수를 매긴 것입니다.</p>
        </li>
        <li class="collapsible">
            <h2 class="title"><a href="#search">검색은 어떻게 하나요</a></h2>
            <p class="content">Bubble로 뿌려진 각 감정에 대해 키워드를 클릭함으로써 감정 점수를 모으고 그에 따른 추천 노래를 검색해 줍니다</p>
        </li>
        <li class="collapsible">
            <h2 class="title"><a href="#api">노래 점수는 어떻게 매겨졌나요</a></h2>
            <p class="content">노래에 대해 형태소 분석을 실시하고, 감정 사전을 통해 점수를 만들어 둔것을 적용시켜 총 노래에 대한 점수를 매기는 방식입니다</p>
        </li>
    </start>

<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="../js/customer.js"></script>  	
<%@ include file ="../footer.jsp" %>
	