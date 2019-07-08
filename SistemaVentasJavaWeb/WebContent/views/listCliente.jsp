<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ventas | ${title}</title>
<script>
	  window.menu = '${title}';	
	  window.contextRoot = '${contextRoot}';	  
</script>

<%@include file="../WEB-INF/jspf/css/cssLinks.jspf" %>	
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
	
  <%@include file="../WEB-INF/jspf/header.jspf" %>
  	
  <!-- Left side column. contains the logo and sidebar -->
  <%@include file="../WEB-INF/jspf/sidebar.jspf" %>
  
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    		
        <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">Cliente <button class="btn bg-olive" id="btnagregar"><i class="fa fa-plus-circle"></i> Agregar</button></h3>
            </div> 
            <!-- /.box-header -->
            <div class="box-body">
              <table id="clienteListTable" class="table table-bordered table-striped">
                <thead>
                <tr>
                  <th>Codigo</th>
                  <th>Nombres</th>
                  <th>Apellidos</th>
                  <th>Direccion</th>
                  <th></th>
                </tr>
                </thead>               
                <tfoot>
                <tr>
                  <th>Codigo</th>
                  <th>Nombres</th>
                  <th>Apellidos</th>
                  <th>Direccion</th>
                  <th></th>
                </tr>
                </tfoot>
              </table>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
    </section>
    <!-- /.content -->		
	        
			
  </div>
  <!-- /.content-wrapper -->
  
  <%@include file="../WEB-INF/jspf/footer.jspf" %>

  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->


<%@include file="../WEB-INF/jspf/js/jsSrc.jspf" %>
</body>
</html>