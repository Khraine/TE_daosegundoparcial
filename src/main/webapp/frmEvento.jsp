<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <c:if test="${evento.id==0}"> NUEVO </c:if>
            <c:if test="${evento.id!=0}"> EDITAR </c:if>
            REGISTRO
        </h1>
            <form action="EventoControlador" method="post">
                <input type="hidden" name="id" value="${evento.id}">
                <table>
                    <tr>
                        <td>Titulo: </td>
                        <td><input type="text" name="titulo" value="${evento.titulo}" placeholder="Ingrese el titulo" required></td>
                    </tr>
                    <tr>
                        <td>Expositor: </td>
                        <td><input type="text" name="expositor" value="${evento.expositor}" placeholder="Ingrese el expositor" required></td>
                    </tr>
                    <tr>
                        <td>Fecha: </td>
                        <td><input type="text" name="fecha" value="${evento.fecha}" placeholder="AAAA-MM-DD" required></td>
                    </tr>
                    <tr>
                        <td>Hora: </td>
                        <td>
                            <input type="text" name="hora" value="${evento.hora}" placeholder="HoraInicio - HoraFinal" required> 
                        </td>
                    </tr>
                    <tr>
                        <td>Cupo: </td>
                        <td><input type="number"  min = 0 name="cupo" value="${evento.cupo}" required></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit"value="Enviar"></td>
                    </tr>
                </table>
            </form>
    </body>
</html>
