<%@ page import="java.util.List" %>
<%@ page import="com.dio.javamentoring.warehouse.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Storage selection</title>
</head>
<body>
<%
String storageSelected = (String)session.getAttribute("storageSelected");
if (storageSelected != null) {
	request.setAttribute("storageSelected", storageSelected);
}
%>
<form action="StorageAction.jsp" method="post">
	The following storage(s) are initialized:<br/>
	<table>
	  <c:forEach var="item" items="${warehouse.storages}" varStatus="status">
	    <tr>
	      <td><input type="radio" name="storages" id="${item.getType()}" value="${item.getType()}" ${item.getType().toString().equals(storageSelected) ? 'checked' :''} onclick="storageOnClick(${item.getType()})" /><c:out value="${item.getType()}" /></td>
	    </tr> 
	   </c:forEach>
	   <tr>
	    <td><input type="submit" value="Next ->" /></td>
	   </tr>
	</table>
</form>

<script type="text/javascript">
function storageOnClick(storageSelected) {
	<%
	session.setAttribute("storageSelected",storageSelected);
	%>
}
</script>

</body>
</html>