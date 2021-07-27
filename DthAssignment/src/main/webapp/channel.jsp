<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="subscribeChannel">
<table style="border:2px solid;margin-left:650px;margin-top:300px;background-color:aqua;">
<tr><td><h2>DTH Subscription</h2></td></tr>
<tr><td>Subscription Id :</td><td><input type="text" name = "customer"></td></tr>
<tr><td>Channels : </td><td><select name="channel">
<option>select</option>

 <c:forEach var="channels" items="${channel}">
	 
	 <option value="${channels.channelId}">${channels.channelName}</option>
</c:forEach>
</select></td></tr>
<tr><td>Date Of Subscription : </td><td><input type ="date" name = "subscriptionDate" ></td><tr>
<tr><td><button type="submit">Subscribe</button></td></tr>
<tr><td></td></tr>
</table>
</form>
<button style="margin-left: 800px"onclick="location.href='home.jsp';">Clear</button>
</body>
</html>


