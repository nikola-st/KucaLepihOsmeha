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
        <h2>Pregled</h2>
        <a class="btn btn-info" href="PacijentController?action=lista" role="button">Izlistaj sve pacijente</a>
        <a class="btn btn-info" href="PacijentController?action=insert" role="button">Dodaj novog pacijenta</a>
    </center>
    <div class="container"><!-- container --> 
        
        <h4>Lista Pregleda</h4><br>
        
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>id</th>
                    <th>datum</th>
                    <th>nalaz</th>
                    <th>id pacijenta</th>
                    <th>id lekara</th>
                    <th>Opcije</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${preglediP}" var="pac">
                <tr>
                    <td><c:out value="${pac.id}" /></td>
                    <td><c:out value="${pac.datum}" /></td>
                    <td><c:out value="${pac.nalaz}" /></td>
                    <td><c:out value="${pac.id_pacijenta}" /></td>
                    <td><c:out value="${pac.id_lekara}" /></td>
                    <td>
                    <a class="btn btn-primary" href="PregledController?action=edit&AMP;pregledID=<c:out value='${pac.id}'/>" role="button">Izmeni</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div><!-- container -->   
</body>
</html>