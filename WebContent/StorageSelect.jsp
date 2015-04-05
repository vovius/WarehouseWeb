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
<form action="StorageAction.jsp" method="post">
	 <%
	 Warehouse warehouse = new Warehouse();
	 warehouse.initTVManageService("C:\\111\\");
	 List<TVStorageInterface> storageList = warehouse.getStorages();

	 session.setAttribute("warehouse",warehouse);
	 pageContext.setAttribute("storageList", storageList);
	 %>

	The following storage(s) are initialized:<br/>
	<table>
	  <c:forEach var="item" items="${storageList}" varStatus="status">
	    <tr>
	      <td><input type="radio" name="storages" id="${item.getType()}" value="${item.getType()}" ${status.isFirst() ? 'checked' :''} /><c:out value="${item.getType()}" /></td>
	    </tr> 
	   </c:forEach>
	   <tr>
	    <td><input type="submit" value="Next ->" /></td>
	   </tr>
	</table>
</form>



</body>
</html>