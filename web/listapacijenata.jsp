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
        <h2>Rad sa pacijentima</h2>
        <a class="btn btn-info" href="PacijentController?action=lista" role="button">Izlistaj sve pacijente</a>
        <a class="btn btn-info" href="PacijentController?action=insert" role="button">Dodaj novog pacijenta</a>
    </center>
    <div class="container"><!-- container --> 
        
        <h4>Lista Pacijenata</h4><br>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Ime</th>
                    <th>Prezime</th>
                    <th>Adresa</th>
                    <th>Telefon</th>
                    <th>Opcije</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${pacijenti}" var="pac">
                <tr>
                    <td><c:out value="${pac.ime}" /></td>
                    <td><c:out value="${pac.prezime}" /></td>
                    <td><c:out value="${pac.adresa}" /></td>
                    <td><c:out value="${pac.telefon}" /></td>
                    <td>
                    <a class="btn btn-primary" href="PacijentController?action=edit&AMP;pacijentId=<c:out value='${pac.id}'/>" role="button">Izmeni</a>
                    <a class="btn btn-primary" href="PacijentController?action=delete&AMP;pacijentId=<c:out value='${pac.id}'/>" role="button">Obrisi</a>
                    <a class="btn btn-primary" href="PregledController?action=novi&AMP;pacijentId=<c:out value='${pac.id}'/>" role="button">Novi Pregled</a>
                    <a class="btn btn-primary" href="ReklamacijeController?action=listaP&AMP;pacijentId=<c:out value='${pac.id}'/>" role="button">Reklamacije</a>
                    <a class="btn btn-info" href="ReklamacijeController?action=new&AMP;pacijentId=<c:out value='${pac.id}'/>" role="button">Nova reklamacija</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        
        <!-- Search -->
        <div class="row">
            <div class="col-md-6">
    		  <h4>Pretraga pacijenata po imenu</h4>
                <div id="search">
                    <div class="input-group col-md-12">
                        <form class="form-horizontal" action='SearchServlet' method='get'>
                            <span class="input-group-btn">
                                <input type="text" name="trazi" id='name' class="form-control input-sm" placeholder="Unesite trazeno ime" />
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