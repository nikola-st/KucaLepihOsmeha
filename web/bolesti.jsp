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
      <h2>Rad sa siframa bolesti zuba</h2>
      <a class="btn btn-info" href="BolestiController?action=lista" role="button">Izlistaj sve sifre bolesti zuba</a><br><br>
  </center> 
<div align="center">
  <div class="container"><!-- container --> 
    <div class="row"><!-- row -->
      <c:if test="${bolest == null}">
        <h4 class="alert-info">Dodavanje nove sifre bolesti zuba</h4>
        <form class="form-horizontal" action='BolestiController' method='POST'>
                  
          <div class="form-group">
            <label for="sifra" class="col-sm-6 control-label">Sifra</label>
              <div class="col-sm-6 col-sm-offset-3">
                <input type="text" class="form-control" name="sifra" id="sifra"/>
              </div>
          </div>
                  
          <div class="form-group">
            <label for="naziv" class="col-sm-6 control-label">Naziv</label>
              <div class="col-sm-6 col-sm-offset-3">
                <input type="text" class="form-control" name="naziv" id="naziv"/>
              </div>
          </div>
                    
          <div class="form-group">
            <label for="opis" class="col-sm-6 control-label">Opis</label>
              <div class="col-sm-6 col-sm-offset-3">
                <input type="text" class="form-control" name="opis" id="opis"/>
              </div>
          </div>
          <div class="col-sm-6 col-sm-offset-3">
            <br>
            <button type="submit" class="btn btn-default">Unesi</button>
            <button type="reset" class="btn btn-default">Odustani</button>
        </div>
        </form>
      </c:if>
    </div><!-- row -->
  </div><!-- container --> 
          
  <div class="container"><!-- container -->
    <div class="row"><!-- row -->
      <c:if test="${bolest != null}">
        <h4 class="alert-info">Izmena podataka o siframa bolesti zuba</h4>
        <form class="form-horizontal" action='BolestiController' method='post'>
          <input type="hidden" name="bolestID" value="<c:out value='${bolest.id}' />"/>
            
            <div class="form-group">
              <label for="sifra1" class="col-sm-6 control-label">Sifra</label>
                <div class="col-sm-6 col-sm-offset-3">
                  <input type="text" class="form-control" name="sifra" id="sifra1" value="<c:out value='${bolest.sifra}' />"/>
                </div>
            </div>
              
            <div class="form-group">
              <label for="naziv1" class="col-sm-6 control-label">Naziv</label>
                <div class="col-sm-6 col-sm-offset-3">
                  <input type="text" class="form-control" name="naziv" id="naziv1" value="<c:out value='${bolest.naziv}' />"/>
                </div>
            </div>
                
            <div class="form-group">  
              <label for="opis1" class="col-sm-6 control-label">Opis</label>  
                <div class="col-sm-6 col-sm-offset-3">
                  <input type="text" class="form-control" name="opis" id="opis1" value="<c:out value='${bolest.opis}' />"/>
                </div>
            </div>
            <div class="col-sm-6 col-sm-offset-3">
              <br>
              <button type="submit" class="btn btn-default">Sacuvaj</button>  
            </div>             
        </form>      
      </c:if>        
    </div><!-- row -->    
  </div><!-- container --> 
</div>
</body>
</html>