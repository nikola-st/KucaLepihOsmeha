<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Stomatoloska ordinacija Kuca lepih osmeha</title>
    </head>
    <body>
        <c:import url="navigacijaPublic.jsp"></c:import>
        <center>
        <h3>Cenovnik stomatoloških usluga</h3>
        </center><br><br>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Naziv</th>
                    <th>Cena</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${usluge}" var="u">
                <tr>
                <td><c:out value="${u.naziv}" /></td>
                <td><c:out value="${u.cena}" /> dinara</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </body>
</html>
