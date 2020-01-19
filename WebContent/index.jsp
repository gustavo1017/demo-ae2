<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table >
            <caption><h2>List of Mascotas</h2></caption>
            <tr>
                <th>ID</th>
                <th>nombre</th>
                <th>edad</th>
            </tr>
            <c:forEach var="mascota" items="${listMascota}">
                <tr>
                    <td><c:out value="${mascota.id}" /></td>
                    <td><c:out value="${mascota.nombre}" /></td>
                    <td><c:out value="${mascota.edad}" /></td>
                    <td>
                    	<a href="edit?id=<c:out value='${mascota.id}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete?id=<c:out value='${mascota.id}' />">Delete</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
        
             <h3 align="center">
        	<a href="new">Add New User</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">List All Users</a>
</body>
</html>