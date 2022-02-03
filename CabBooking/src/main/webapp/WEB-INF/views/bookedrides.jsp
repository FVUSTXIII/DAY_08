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
				<td>Name</td>
				<td>Source</td>
				<td>Destination</td>
				<td>Duration</td>
				<td>Date<td>
			</tr>
			
			<c:forEach items="${rideList}" var="ride">
			
				<tr>
					<td>${ride.user_name}</td>
					<td>${ride.source}</td>
					<td>${ride.destination}</td>
					<td>${ride.duration}</td>
					<td>${ride.date_time}</td>				
				</tr>
				
			</c:forEach>
			
		</table>
	
</body>
</html>