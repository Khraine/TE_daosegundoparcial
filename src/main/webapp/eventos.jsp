<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1" align="center" cellspacing="5">
            <tr>
                <td>SEGUNDO PARCIAL TEM-742<br>Nombre: Gadiel Randall Valdez Alvarado<br>Carnet: 7094963LP</td>
            </tr>
        </table>
        <h1 align="center">REGISTRO DE SEMINARIOS</h1>
        <a href="EventoControlador?action=add">Nuevo</a>
        <table border="1" align="center" >
            <tr>
                <th>ID</th>
                <th>TITULO</th>
                <th>EXPOSITOR</th>
                <th>FECHA</th>
                <th>HORA</th>
                <th>CUPO</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${eventos}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.titulo}</td>
                    <td>${item.expositor}</td>
                    <td>${item.fecha}</td>
                    <td>${item.hora}</td>
                    <td>${item.cupo}</td>
                    <td><a href="EventoControlador?action=edit&id=${item.id}">Editar</a></td>
                    <td><a href="EventoControlador?action=delete&id=${item.id}" onclick="return(confirm ('Está seguro de eliminar el registro???'))">Eliminar</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
