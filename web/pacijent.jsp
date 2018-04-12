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
      <h2>Rad sa pacijentima</h2>
      <a class="btn btn-info" href="PacijentController?action=lista" role="button">Izlistaj sve pacijente</a><br><br>
    </center> 
<div align="center">
  <div class="container"><!-- container --> 
    <div class="row"><!-- row -->
      <c:if test="${pacijent == null}">
        <h4 class="alert-info">Dodavanje novog pacijenta</h4>
        <form class="form-horizontal" action='PacijentController' method='POST'>
                  
          <div class="form-group col-sm-offset-4 col-sm-offset-4">
            <label for="ime" class="col-sm-4 control-label">Ime</label>
              <div class="col-sm-4">
                <input type="text" class="form-control" name="ime" id="ime"/>
              </div>
          </div>
                  
          <div class="form-group col-sm-offset-4 col-sm-offset-4">
            <label for="prezime" class="col-sm-4 control-label">Prezime</label>
              <div class="col-sm-4">
                <input type="text" class="form-control" name="prezime" id="prezime"/>
              </div>
          </div>
                    
          <div class="form-group col-sm-offset-4 col-sm-offset-4">
            <label for="adresa" class="col-sm-4 control-label">Adresa</label>
              <div class="col-sm-4">
                <input type="text" class="form-control" name="adresa" id="adresa"/>
              </div>
          </div>
                    
          <div class="form-group col-sm-offset-4 col-sm-offset-4">
            <label for="telefon" class="col-sm-4 control-label">Telefon</label>
              <div class="col-sm-4">
                <input type="text" class="form-control" name="telefon" id="telefon" />
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
      <c:if test="${pacijent != null}">
        <h4 class="alert-info">Izmena podataka o pacijentu</h4>
        <form class="form-horizontal" action='PacijentController' method='post'>
          <input type="hidden" name="pacijentID" value="<c:out value='${pacijent.id}' />"/>
            <div class="form-group col-sm-offset-4">
              <label for="ime1" class="col-sm-4 control-label">Ime</label>
                <div class="col-sm-4">
                  <input type="text" class="form-control" name="ime" id="ime1" value="<c:out value='${pacijent.ime}' />"/>
                </div>
            </div>
              
            <div class="form-group col-sm-offset-4">
              <label for="prezime1" class="col-sm-4 control-label">Prezime</label>
                <div class="col-sm-4">
                  <input type="text" class="form-control" name="prezime" id="prezime1" value="<c:out value='${pacijent.prezime}' />"/>
                </div>
            </div>
                
            <div class="form-group col-sm-offset-4">  
              <label for="adresa1" class="col-sm-4 control-label">Adresa</label>  
                <div class="col-sm-4">
                  <input type="text" class="form-control" name="adresa" id="adresa1" value="<c:out value='${pacijent.adresa}' />"/>
                </div>
            </div>

            <div class="form-group col-sm-offset-4">
              <label for="telefon1" class="col-sm-4 control-label">Telefon</label>
                <div class="col-sm-4">
                  <input type="text" class="form-control" name="telefon" id="telefon1" value="<c:out value='${pacijent.telefon}' />"/>
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