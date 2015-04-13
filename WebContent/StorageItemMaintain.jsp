<%@page import="com.dio.warehouse.*"%>
<%@ page import="com.dio.javamentoring.warehouse.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><c:out value="${param['action']}"></c:out></title>
<script src="datetimepicker_css.js"></script>
</head>
<body>

<form action="StorageAction.jsp">
<table>
  <tr id="id">
    <td>id:</td><td>${param['editId']}<input type="hidden" name="id" value="${param['editId']}" /></td>
  </tr>
  <tr>
    <td>brand:</td><td><input type="text" value="${item.brand}" name="brand" /></td>
  </tr>
  <tr>
    <td>diagonal:</td><td><input type="text" value="${item.diagonal}" name="diagonal" /></td>
  </tr>
  <tr>
    <td>matrixType:</td>
    <td>
	    <select name="matrixType">
		    <c:forEach var="matrixTypeItem" items="<%=MatrixType.values()%>">
		      <option><c:out value="${matrixTypeItem.name()}"/></option>
		    </c:forEach>
	    </select>
    </td>
  </tr>
  <tr>
    <td>dateMade:</td>
    <td>
      <input type="text" value="${item.getDateMadeStr()}" name="dateMade" />
      <img src="images/cal.gif" onclick="javascript:NewCssCal('dateMade','mmddyyyy')" style="cursor:pointer"/> 
    </td>
  </tr>
</table>
<input type="submit" name="action" value="SaveNClose" />
<input type="submit" name="action" value="Close" />
</form>

</body>
</html>