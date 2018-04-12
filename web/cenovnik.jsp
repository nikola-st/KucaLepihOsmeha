<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
      <h3>Usluge</h3>
      <a class="btn btn-info" href="CenovnikController?action=lista" role="button">Izlistaj sve usluge</a><br><br>
  </center> 
<div align="center">
  <div class="container"><!-- container --> 
    <div class="row"><!-- row -->
      <c:if test="${cenovnik == null}">
        <h4 class="alert-info">Dodavanje nove usluge</h4>
        <form class="form-horizontal" action='CenovnikController' method='POST'>
                  
          <div class="form-group col-sm-offset-4">
            <label for="naziv" class="col-sm-4 control-label">Naziv usluge</label>
              <div class="col-sm-4">
                <input type="text" class="form-control" name="naziv" id="naziv"/>
              </div>
          </div>
                  
          <div class="form-group col-sm-offset-4">
            <label for="cena" class="col-sm-4 control-label">Cena</label>
              <div class="col-sm-4">
                <input type="text" class="form-control" name="cena" id="cena"/>
              </div>
          </div>
                    
          <button type="submit" class="btn btn-default">Unesi</button>
          <button type="reset" class="btn btn-default">Odustani</button>
        </form>
      </c:if>
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