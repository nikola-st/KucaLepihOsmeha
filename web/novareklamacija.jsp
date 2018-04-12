<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Stomatoloska ordinacija Kuca Lepih Osmeha</title>
    
    <!--Bootstrap css-->
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
    <link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>

</head>
<body>
  <c:import url="navigacija.jsp"></c:import>
  <center>
      <h3>Reklamacije</h3>
      <a class="btn btn-info" href="ReklamacijeController?action=neresena" role="button">Izlistaj sve neresene reklamacije</a><br><br>
  </center> 
<div align="center">
  <div class="container"><!-- container --> 
    <div class="row"><!-- row -->
      
        <h4 class="alert-info">Nova reklamacija</h4>
        <form class="form-horizontal" action='ReklamacijeController' method='post'>
                  
          <div class="form-group col-sm-offset-4">
            <label for="datum" class="col-sm-4 control-label">Datum</label>
              <div class="col-sm-4">
                <fmt:formatDate pattern = "yyyy-MM-dd" value = "${now}" />
                <input type="text" class="form-control" name="datum" id="datum" value="${now}"/>
              </div>
          </div>
                  
          <div class="form-group col-sm-offset-4">
            <label for="opis" class="col-sm-4 control-label">Opis</label>
              <div class="col-sm-4">
                <input type="text" class="form-control" name="opis" id="opis"/>
              </div>
          </div>
            
          <div class="form-group col-sm-offset-4">
            <label for="status" class="col-sm-4 control-label">Status</label>
              <div class="col-sm-4">
                  <input type="text" class="form-control" name="status" id="status" value="neresena"/>
              </div>
          </div>
              
          <div class="form-group col-sm-offset-4">
            <label for="id_pacijenta" class="col-sm-4 control-label">ID pacijenta</label>
              <div class="col-sm-4">
                  <input type="text" value="<c:out value="${nova}"></c:out>" class="form-control" name="id_pacijenta" id="id_pacijenta"/>
              </div>
          </div>
                    
          <button type="submit" class="btn btn-default">Unesi</button>
          <button type="reset" class="btn btn-default">Odustani</button>
        </form>
      
    </div><!-- row -->
  </div><!-- container --> 
          
  <div class="container"><!-- container -->
    <div class="row"><!-- row -->
      <c:if test="${cenovnik != null}">
        <h4 class="alert-info">Izmena podataka o uslugama</h4>
        <form class="form-horizontal" action='CenovnikController' method='post'>
          <input type="hidden" name="cenovnikID" value="<c:out value='${cenovnik.id}' />"/>
            <div class="form-group col-sm-offset-4">
              <label for="naziv1" class="col-sm-4 control-label">Naziv usluge</label>
                <div class="col-sm-4">
                  <input type="text" class="form-control" name="naziv" id="naziv1" value="<c:out value='${cenovnik.naziv}' />"/>
                </div>
            </div>
              
            <div class="form-group col-sm-offset-4">
              <label for="cena1" class="col-sm-4 control-label">Cena</label>
                <div class="col-sm-4">
                  <input type="text" class="form-control" name="cena" id="cena1" value="<c:out value='${cenovnik.cena}' />"/>
                </div>
            </div>
            <button type="submit" class="btn btn-default">Sacuvaj</button>               
        </form>      
      </c:if>        
    </div><!-- row -->    
  </div><!-- container --> 
</div>
</body>
</html>