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
      <!-- SELECT2 EXAMPLE -->
      <div class="box box-default">
        <div class="box-header with-border">
          <h3 class="box-title">${formtitle}</h3>
        </div>
        <form id="frmRegistro">
        <!-- /.box-header -->
        <div class="box-body">
        <c:if test="${producto != null}">
          <input type="hidden" name="txtId" id="txtId"  value="<c:out value='${producto.codProducto}'/>" />
        </c:if>
        <c:if test="${book == null}">
          <input type="hidden" name="txtId" id="txtId" value="0" />
        </c:if>
          <div class="row">
            <div class="col-md-6">
              <div class="form-group">
                <label>Nombre</label>
                <input type="text" class="form-control" name="nombre" id="nombre"  value="<c:out value='${producto.nombreProducto}'/>" >
              </div>
            </div>
            <div class="col-md-6">
              <div class="form-group">
                <label>Precio</label>
                <div oncopy="return false;" onpaste="return false;">
                	<input type="text" class="form-control" name="precio" value="<c:out value='${producto.precioVenta}'/>" onkeypress="return filterFloat(event,this);" id="precio">
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-md-6">
              <div class="form-group">
                <label>Stock Minimo</label>
                <div oncopy="return false;" onpaste="return false;">
                	<input type="text" class="form-control" name="stockminimo" value="<c:out value='${producto.stockMinimo}'/>"  onkeypress="return valideKey(event);" id="stockminimo">
                </div>
              </div>
            </div>
            <div class="col-md-6">
              <div class="form-group">
                <label>Stock Actual</label>
                <div oncopy="return false;" onpaste="return false;">
                	<input type="text" class="form-control" name="stockactual" value="<c:out value='${producto.stockActual}'/>"  onkeypress="return valideKey(event);" id="stockactual" >
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-md-6">
              <div class="form-group">
                <label>Codigo de Barra</label>
                <input type="text" class="form-control" name="cbarra" value="<c:out value='${producto.codBarra}'/>" id="cbarra">
              </div>
            </div>            
          </div>
          
        </div>
        <!-- /.box-body -->
        <div class="box-footer">
          <button class="btn bg-purple" type="submit" id="btnGuardar"><i class="fa fa-save"></i> ${btnSave}</button>
          <a href="${contextRoot}/PageController?ruta=listProduct" class="btn bg-maroon"><i class="fa fa-arrow-circle-left"></i> Cancelar</a>
        </div>
        </form>
      </div>
      <!-- /.box -->
    </section>
    <!-- /.content -->	
	        
			
  </div>
  <!-- /.content-wrapper -->
  
  <%@include file="../WEB-INF/jspf/footer.jspf" %>

  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->


<%@include file="../WEB-INF/jspf/js/jsSrc.jspf" %>
<script src="${contextRoot}/resources/js/productojs.js"></script>
</body>
</html>