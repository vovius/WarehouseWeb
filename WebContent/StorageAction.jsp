<%@ page import="java.util.List" %>
<%@ page import="com.dio.javamentoring.warehouse.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${param['storages'] != null}">
  <c:set target="${storageWebState}" property="storageSelected" value="${param['storages']}" />
</c:if>
 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Storage Action Selection</title>
</head>
<body>
Storage <c:out value="${storageWebState.storageSelected}" /> has been selected<br/>
Content:<br/>
<form action="ActionSelect.jsp" method="post">
	<table>
	  <c:forEach var="item" items="${storageWebState.currentStorage.storageList}" varStatus="status">
	    <tr>
	      <td><c:out value="${item}" /></td>
	      <td><input type="submit" name="action" value="Edit" id="${item.id}" /></td>
	      <td><input type="submit" name="action" value="Delete" id="${item.id}" onclick="deleteItem(${item.id})" /></td>
	    </tr> 
	   </c:forEach>
	</table>
	<input type="submit" value="Add new item ->" />
</form>

<form action="StorageSelect.jsp" method="post">
  <input type="submit" value="<- Back" />
</form>

<script type="text/javascript">
function deleteItem(itemId) {
	
} 
</script>

</body>
</html>