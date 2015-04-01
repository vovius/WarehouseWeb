<%@page import="java.util.List"%>
<%@ page import="com.dio.javamentoring.warehouse.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <%
  Warehouse warehouse = new Warehouse();
  warehouse.initTVManageService("C:\\111\\");
  TVStorageInterface storage = warehouse.getStorage(StorageType.CSV);
  List<TV> storageList = storage.getStorageList();
  pageContext.setAttribute("storageList", storageList);
  %>
Welcome from WarehouseContent<br/>
<table>
	<c:forEach var="item" items="${storageList}">
    <tr>
		  <td><c:out value="${item}" /></td>
    </tr> 
   </c:forEach>
</table>

</body>
</html>