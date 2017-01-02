<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/header.jsp" %>

  <!-- 본문 -->
  <section class="content">
    <!-- 왼쪽의 메뉴 부분 -->
    <div class="content__left">
      <section class="navigation">
        <div class="navigation__list">
          <div class="navigation__list__header" role="button" data-toggle="collapse" href="#main" aria-expanded="true" aria-controls="main">
            Main
          </div>

          <div class="collapse in" id="main">
            <a href="#" class="navigation__list__item">
              <i class="ion-ios-browsers"></i>
              <span>Browse</span>
            </a>
          </div>
        </div>
      </section>
    </div>
    
    <!-- 메인에 해당하는 부분 -->
    <div class="content__middle">
    </div>
  </section>
 
 <%@ include file="/footer.jsp" %>