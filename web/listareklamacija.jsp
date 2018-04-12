<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Stomatoloska ordinacija Kuca Lepih Osmeha</title>
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
    <link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <c:import url="navigacija.jsp"></c:import>
    <center>
        <h2>Obrada Reklamacija</h2>
        <a class="btn btn-info" href="PacijentController?action=lista" role="button">Izlistaj sve pacijente</a>
        <a class="btn btn-info" href="PacijentController?action=insert" role="button">Dodaj novog pacijenta</a>
    </center>
    <div class="container"><!-- container --> 
        
        <h4>Lista neresenih reklamacija pacijenta</h4><br>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Datum</th>
                    <th>Opis</th>
                    <th>Status</th>
                    <th>Opcije</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${reklamacije}" var="rp">
                <tr>
                    <td><c:out value="${rp.datum}" /></td>
                    <td><c:out value="${rp.opis}" /></td>
                    <td><c:out value="${rp.status}" /></td>
                    <td>
                    <a class="btn btn-primary" href="ReklamacijeController?action=edit&AMP;pacijentId=<c:out value='${rp.id}'/>" role="button">Izmeni</a>
                    <a class="btn btn-primary" href="ReklamacijeController?action=resi&AMP;pacijentId=<c:out value='${rp.id}'/>" role="button">Resi</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div><!-- container -->   
</body>
</html>