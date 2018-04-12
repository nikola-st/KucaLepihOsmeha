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
        <h2>Rad sa siframa bolesti zuba</h2>
        <a class="btn btn-info" href="BolestiController?action=lista" role="button">Izlistaj sve sifre bolesti</a>
        <a class="btn btn-info" href="BolestiController?action=insert" role="button">Dodaj novu sifru bolesti</a>
    </center>
    <div class="container"><!-- container --> 
        
        <h4>Lista bolesti zuba</h4><br>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Sifra</th>
                    <th>Naziv</th>
                    <th>Opis</th>
                    <th>Opcije</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${bolesti}" var="bol">
                <tr>
                    <td><c:out value="${bol.sifra}" /></td>
                    <td><c:out value="${bol.naziv}" /></td>
                    <td><c:out value="${bol.opis}" /></td>
                    <td>
                    <a class="btn btn-primary" href="BolestiController?action=edit&AMP;bolestId=<c:out value='${bol.id}'/>" role="button">Izmeni</a>
                    <a class="btn btn-primary" href="BolestiController?action=delete&AMP;bolestId=<c:out value='${bol.id}'/>" role="button">Obrisi</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        
        <!-- Search -->
        <div class="row">
            <div class="col-md-6">
    		  <h4>Pretraga sifri bolesti po nazivu</h4>
                <div id="search">
                    <div class="input-group col-md-12">
                        <form class="form-horizontal" action='SearchBolestiServlet' method='get'>
                            <span class="input-group-btn">
                                <input type="text" name="trazi" id='name' class="form-control input-sm" placeholder="Unesite trazeni naziv" />
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