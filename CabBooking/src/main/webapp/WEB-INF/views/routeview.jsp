<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Routes</title>
</head>
<body>
		
		<table style="with: 80%">
			<tr>
				<td></td>
				<td>Source</td>
				<td>Destination</td>
				<td>Duration</td>
			</tr>
			
			<c:forEach items="${rList}" var="route">
			<form action="rides" method="post">
				<tr>
					<td><input type="hidden" name="routeId" value=${route.routeId}>${route.routeId}</td>
					<td>${route.source}</td>
					<td>${route.destination}</td>
					<td>${route.duration}</td>
					<td><input  name="userId" value=${userId}></td>
					<td><input type="hidden" name="action" value="Book"></td>
					<td><input value="Book" type="submit" /></td>
				</tr>
				</form>
			</c:forEach>
			
		</table>
		
	
</body>
</html>