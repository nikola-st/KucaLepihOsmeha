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
      <h2>Pregled</h2>
      <a class="btn btn-info" href="PregledController" role="button">Izlistaj sve preglede</a><br><br>
  </center> 
<div align="center">
  <div class="container"><!-- container --> 
    <div class="row"><!-- row -->
        <h4 class="alert-info">Novi pregled</h4>
        <form class="form-horizontal" action='PregledController' method='POST'>
            <input type="hidden" name="pregledID" value="<c:out value="${pregled.id}"></c:out>">        
          <div class="form-group col-sm-offset-4 col-sm-offset-4">
            <label for="idP" class="col-sm-4 control-label">ID pacijenta</label>
              <div class="col-sm-4">
                <input type="text" class="form-control" name="pacijentID" id="idP" value="<c:out value="${pregled.id_pacijenta}"></c:out>"/>
              </div>
          </div>
                  
          <div class="form-group col-sm-offset-4 col-sm-offset-4">
            <label for="lekar" class="col-sm-4 control-label">ID lekara</label>
              <div class="col-sm-4">
                <input type="text" class="form-control" name="lekarID" id="lekar" value="<c:out value="${pregled.id_lekara}"></c:out>"/>  
              </div>
          </div>
        
          <div class="form-group col-sm-offset-4 col-sm-offset-4">
            <label for="datum" class="col-sm-4 control-label">Datum</label>
              <div class="col-sm-4">
                <input type="text" class="form-control" name="datum" id="datum" value="<c:out value="${pregled.datum}"></c:out>"/>
              </div>
          </div>
                    
          <div class="form-group col-sm-offset-4 col-sm-offset-4">
            <label for="nalaz" class="col-sm-4 control-label">Nalaz</label>
              <div class="col-sm-4">
                <textarea class="form-control" rows="5" name="nalaz" id="nalaz"><c:out value="${pregled.nalaz}"></c:out></textarea>
              </div>
          </div>
          <button type="submit" class="btn btn-default">Unesi</button>
          <button type="reset" class="btn btn-default">Odustani</button>
        </form>

    </div><!-- row -->
  </div><!-- container --> 
</div>
</body>
</html>