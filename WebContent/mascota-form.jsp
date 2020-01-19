<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Veterinaria</title>
	<style>
   
	</style>
</head>
<body>

		<h2 align="center">Mascotas</h2>

    <div align="center">
		<c:if test="${mascota != null}">
			<form action="update" method="post">
        </c:if>
        <c:if test="${mascota == null}">
			<form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${mascota != null}">
            			Edit Mascota
            		</c:if>
            		<c:if test="${mascota == null}">
            			Add New Mascota
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${mascota != null}">
        			<input type="hidden" name="id" value="<c:out value='${mascota.id}' />" />
        		</c:if>            
            <tr>
                <th>Mascota Nombre: </th>
                <td>
                	<input type="text" name="nombre" size="45"
                			value="<c:out value='${mascota.nombre}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>Mascota Edad: </th>
                <td>
                	<input type="text" name="edad" size="45"
                			value="<c:out value='${mascota.edad}' />"
                	/>
                </td>
            </tr>
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Save" />
            	</td>
            </tr>
        </table>
        </form>
    </div>	
        <h3 align="center">
        	<a href="new">Add New Mascota</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">List All Mascotas</a>
        	
        </h3>
</body>
</html>
