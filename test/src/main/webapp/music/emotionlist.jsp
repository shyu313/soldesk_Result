<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file ="../header.jsp" %>
  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> 
<script src="../js/calendar.js"></script>
<link rel="stylesheet" type="text/css" href="../css/calendar.css"> 
<style>
#departure {font-size:20px;height:40px;line-height:40px}
</style>


<input type="text" id="departure" readonly/>

<script>$("#departure").dateDropper();</script>
	
  
    <div id="chart"></div>
  
<%@ include file ="../footer.jsp" %>
	