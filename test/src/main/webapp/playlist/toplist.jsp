<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file ="../header.jsp" %>
<!-- 대시보드 호출 -->
 <script>
/*   var freqData=[
	  {State:'top1',freq:{happy:10, sad:2, rage:0.8, disgust:0, interest:0, pain:0, fear:0}}
  	,{State:'top2',freq:{happy:0, sad:20, rage:0, disgust:5, interest:0, pain:0, fear:9}}
  	,{State:'top3',freq:{happy:0, sad:0, rage:33, disgust:20, interest:31, pain:0, fear:0}}
  	,{State:'top4',freq:{happy:1, sad:2, rage:3, disgust:2, interest:0, pain:70, fear:2}}
  	,{State:'top5',freq:{happy:0, sad:2, rage:3, disgust:2, interest:7, pain:22, fear:1}}
  	,{State:'top6',freq:{happy:0, sad:90, rage:3, disgust:22, interest:15, pain:0, fear:0}}
  	,{State:'top7',freq:{happy:15, sad:0, rage:33, disgust:22, interest:0, pain:0, fear:0}}
  	,{State:'top8',freq:{happy:17, sad:2, rage:3, disgust:0, interest:0, pain:2, fear:0}}
  	,{State:'top9',freq:{happy:1, sad:25, rage:3, disgust:2, interest:55, pain:1, fear:0}}
  	,{State:'top10',freq:{happy:10, sad:10, rage:10, disgust:10, interest:10, pain:10, fear:10}}
	     ]; */
 </script>	
<div id='dashboard'></div>
<!-- 탑 리스트 -->
	<center><a style="font:20"> Music Top 10 </a></center>
	<br>
	
	<center>
	<table width="500" border="1" cellpadding="0" cellspacing="0">
		<tr>
			<th><font color="#ffffff">Top</font></th>
			<th><font color="#ffffff">제목 - Click play</font></th>
			<th><font color="#ffffff">가수</font></th>
			<th><font color="#ffffff">재생횟수</font></th>
			<th><font color="#ffffff">추천수</font></th>
		</tr>
		<c:forEach var="dto" items="${topList }">
		<tr>
			<td><font color="#ffffff">${dto.RNUM }</font></td>
			<td>
				<font color="#ffffff"><a href="toplistplay.do?lyricsNo=${dto.lyricsNo }">${dto.title }</a></font>
			</td>
			<td><font color="#ffffff">${dto.singer}</font></td>
			<td><font color="#ffffff">${dto.playCnt}</font>
			</td>
			<td><font color="#ffffff">${dto.recCnt }</font></td>
		</tr>
		</c:forEach>
	</table>
	<br><br>
	</center>
	
	</div>
<%@ include file ="../footer.jsp" %>