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
        <h2>Cenovnik stomatoloskih usluga</h2>
        <a class="btn btn-info" href="CenovnikController?action=lista" role="button">Izlistaj sve usluge</a>
        <a class="btn btn-info" href="CenovnikController?action=insert" role="button">Dodaj novu uslugu</a>
    </center>
    <div class="container"><!-- container --> 
        
        <h4>Lista Usluga</h4><br>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Naziv</th>
                    <th>Cena</th>
                    <th>Opcije</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${usluge}" var="u">
                <tr>
                <td><c:out value="${u.naziv}" /></td>
                <td><c:out value="${u.cena}" /></td>
                <td>
                <a class="btn btn-primary" href="CenovnikController?action=edit&AMP;cenovnikId=<c:out value='${u.id}'/>" role="button">Izmeni</a>
                <a class="btn btn-primary" href="CenovnikController?action=delete&AMP;cenovnikId=<c:out value='${u.id}'/>" role="button">Obrisi</a>
                </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        
        <!-- Search -->
        <div class="row">
            <div class="col-md-6">
              <h4>Pretraga usluga po imenu</h4>
                <div id="search">
                    <div class="input-group col-md-12">
                        <form class="form-horizontal" action='SearchCenovnikServlet' method='get'>
                            <span class="input-group-btn">
                                <input type="text" name="trazi" id='name' class="form-control input-sm" placeholder="Unesite trazenu uslugu" />
                                <button type="submit" class="btn btn-primary" role="button"><i class="glyphicon glyphicon-search"></i></button>
                            </span>
                        </form>
                    </div>
                </div>
            </div>
        </div>

    </div><!-- container -->   
</body>
</html>