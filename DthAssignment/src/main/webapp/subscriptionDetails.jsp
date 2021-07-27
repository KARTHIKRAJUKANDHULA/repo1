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
<table style="border:2px solid;margin-left:650px;margin-top:300px;background-color:aqua">
<tr><td>SubscriptionId : ${ subscriber.get(0).getCustomer().getSubscriberId()}</td></tr>
<tr><td>Customer Name :  ${ subscriber.get(0).getCustomer().getFirstName()}  ${ subscriber.get(0).getCustomer().getLastName()}
</td><tr>
<tr><td><c:forEach var="subscribers" items="${subscriber}">
	 
	 ${subscribers.getChannel().getChannelName() }   ${subscribers.getChannel().getCostPerMonth() } <br>
</c:forEach></td></tr>
<tr><td>${total}</td></tr>
</table>
</body>
</html>