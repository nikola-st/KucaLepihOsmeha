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
    <nav class="navbar navbar-default navbar-static-top">
        <div class="container-fluid">
            <a class="navbar-brand" href="login.jsp"><img alt="Brand" src="slike/klo.jpg"></a>
            <div class="navbar-header">
                <ul class="nav nav-pills">
                    <li role="presentation"><a href="PacijentController?action=lista">Rad sa pacijentima</a></li>
                    <li role="presentation"><a href="BolestiController?action=lista">Sifre bolesti zuba</a></li>
                    <li role="presentation"><a href="CenovnikController?action=lista">Cenovnik usluga</a></li>
                </ul>
            </div>
            <c:if test="${sessionScope.stomatolog != null}">
            <p class="navbar-text navbar-right">Ulogovani ste kao: <c:out value="${stomatolog}"></c:out>
                &nbsp;<a href="StomatologLogout" class="btn btn-sm btn-info" role="button">Logout</a>&nbsp;&nbsp;&nbsp;</p>
                </c:if>
        </div>
    </nav>        
</body>
</html>