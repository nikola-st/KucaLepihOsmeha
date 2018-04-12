<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dobrodosli!</title>
        <!--Bootstrap css-->
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <c:import url="navigacijaPublic.jsp"></c:import>
        <div align="center">
        <div class="container"><!-- container --> 
        <div class="row"><!-- row -->
        <h4 class="alert-info">Logovanje</h4>
        <c:if test="${poruka!=null}">
            <br><span class="label label-danger"><c:out value="${poruka}"></c:out></span><br><br>
        </c:if>
        <form class="form-horizontal" action='StomatologController' method='POST'>
                  
          <div class="form-group col-sm-offset-4 col-sm-offset-4">
            <label for="username" class="col-sm-4 control-label">Username</label>
              <div class="col-sm-4">
                <input type="text" class="form-control" name="username" id="username"/>
              </div>
          </div>
                  
          <div class="form-group col-sm-offset-4 col-sm-offset-4">
            <label for="password" class="col-sm-4 control-label">Lozinka</label>
              <div class="col-sm-4">
                <input type="password" class="form-control" name="password" id="password"/>
              </div>
          </div>
          <button type="submit" class="btn btn-default">Login</button>
          <button type="reset" class="btn btn-default">Odustani</button>
        </form>
    </div><!-- row -->
  </div><!-- container --> 
</div>
</body>
</html>
