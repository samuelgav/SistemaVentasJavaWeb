<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ventas | ${title}</title>
<style type="text/css">

.table>tbody>tr>td, .table>tfoot>tr>td{
    vertical-align: middle;
}
@media screen and (max-width: 600px) {
    table#cart tbody td .form-control{
		width:20%;
		display: inline !important;
	}
	.actions .btn{
		width:36%;
		margin:1.5em 0;
	}
	
	.actions .btn-info{
		float:left;
	}
	.actions .btn-danger{
		float:right;
	}
	
	table#cart thead { display: none; }
	table#cart tbody td { display: block; padding: .6rem; min-width:320px;}
	table#cart tbody tr td:first-child { background: #333; color: #fff; }
	table#cart tbody td:before {
		content: attr(data-th); font-weight: bold;
		display: inline-block; width: 8rem;
	}
	table#cart tfoot td{display:block; }
	table#cart tfoot td .btn{display:block;}	
}

</style>
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
    <c:if test="${not empty message}">		
		<div class="alert alert-warning">
			<h3 class="text-center">${message}</h3>
		</div>			
	</c:if>  
      
   <div class="row">
        <!-- left column -->
        <div class="col-md-12">
          <!-- general form elements -->
          <div class="panel panel-primary">
            <div class="panel-heading">DATOS GENERALES</div>
            <!-- form start -->
            <form id="frmVenta" action="ManageController" method="post">
   				<div class="panel-body">
			      <div class="row" style="margin-top:5px;">
			        <!-- left column -->
			        <div class="col-sm-offset-1 col-sm-5" >
			          <!-- general form elements -->
			          <div class="panel panel-warning">
			            <div class="panel-heading">DATOS CLIENTE</div>			            
			              <div class="panel-body">
			                <div class="form-group" style="margin-top:5px;">
			                  <label for="selCliente">Cliente</label>
			                  <select class="form-control select2" style="width: 100%;" id="selClientes" name="selClientes">  
			                  		<c:forEach items="${listCliente}" var="cliente">
						                <option value="${cliente.codCliente}"
						                    <c:if test="${cliente.codCliente eq selectedClienteId}">selected="selected"</c:if>
						                    >
						                    ${cliente.nombres} ${cliente.apellidos}
						                </option>
					            	</c:forEach>                
			                  </select>
			                </div>
			              </div>			              
			          </div>
			      </div>
			      <div class="col-md-5">
			          <!-- Horizontal Form -->
			          <div class="panel panel-info">
			            <div class="panel-heading">DATOS PRODUCTOS</div>
			            <!-- /.box-header -->
			              <div class="panel-body">
			              	<c:if test="${producto != null}">
					          <input type="hidden" name="txtId" id="txtId"  value="<c:out value='${producto.codProducto}'/>" />
					        </c:if>
			                <div class="form-group" style="margin-top:5px;">
			                  <label for="" class="col-sm-3 control-label">Cod Barra</label>
			                  <div class="col-sm-5">
			                    <input type="text"  class="form-control" value="<c:out value='${producto.codBarra}'/>" name="codbarra" id="codbarra" placeholder="Codigo Barra">
			                  </div>
			                  <div class="col-sm-4">
			              		<input type="submit" name="op" value="Buscar" class="btn bg-blue btn-sm">
			                  </div>
			                </div>
			                <div class="form-group">
			                  <label for="producto" class="col-sm-3 control-label">Producto</label>
			                  <div class="col-sm-9">
			                    <input type="text" class="form-control" name="producto" id="producto" value="<c:out value='${producto.nombreProducto}'/>">
			                  </div>
			                </div>
			                
			                <div class="form-group">
			                  <label for="producto" class="col-sm-3 control-label">Precio</label>
			                  <div class="col-sm-9">
			                    <input type="text" class="form-control" id="precio" name="precio" value="<c:out value='${producto.precioVenta}'/>">
			                  </div>
			                </div>
			                <div class="form-group">
			                  <label for="producto" class="col-sm-3 control-label">Cantidad</label>
			                  <div class="col-sm-9">
			                    <input type="number" class="form-control" value="1" id="cantidad" name="cantidad">                
			                  </div>
			                </div>
			                  
			                <div class="form-group">
			                  <label for="producto" class="col-sm-3 control-label">Stock</label>
			                  <div class="col-sm-9">
			                    <input type="text" class="form-control" id="stock" name="stock" value="<c:out value='${producto.stockActual}'/>">
			                  </div>
			                </div>
			              </div>      
			          </div>
			          
			   </div>
			   </div>  
			   </div> 
			   <div class="panel-footer">
			   		<button type="submit" name="op" value="Agregar" class="btn bg-red btn-sm">Agregar</button>
			   </div>
  </form>
  </div>
   </div>
   </div> 
 
      <div class="box box-default" style="display:none">
        <div class="box-header with-border">
          <h3 class="box-title">Datos Producto</h3>
        </div>
        <form id="frmRegistro">
        <!-- /.box-header -->
        <div class="box-body">        
          <div class="row">
            <div class="col-md-6">
              <div class="form-group">
                <label>Nro Factura</label>
                <input type="text" class="form-control" name="nombre" id="nroFactura" disabled="disabled" value="000001" >
              </div>
            </div>
            <div class="col-md-6">
              <div class="form-group">
                <label>Cliente</label>
                <select class="form-control select2" style="width: 100%;" id="selCliente">                  
                </select>
              </div>
            </div>
          </div>
          
          <div class="row">
            <div class="col-md-6">
              <div class="form-group">
              	<a data-toggle="modal" href="#myModal">
                	<button class="btn bg-purple" type="submit" id="btnAgregarProd"><span class="fa fa-plus"></span>Agregar Productos</button>
                </a>                
              </div>
            </div>            
          </div>
          
        </div>
        <!-- /.box-body -->
        <div class="box-footer">          
          <a href="${contextRoot}/PageController?ruta=listVenta" class="btn bg-maroon"><i class="fa fa-arrow-circle-left"></i> Cancelar</a>
        </div>
        </form>
      </div>
      <!-- /.box -->
      
      
      <div class="row">
          	   <div class="col-lg-12 col-sm-12 col-md-12 col-xs-12">
                            <div class="box">
						<div class="box-header">
							<h3 class="box-title">Detalle Productos</h3>
						</div>
						<!-- /.box-header -->
						<div class="box-body">
							<div class="pull-right">
								 <div class="form-group">			
									<label class="col-sm-4 control-label">Nro. Serie</label>
									<div class="col-sm-8">
									<input type="text" name="" class="form-control">
									</div>
								 </div>
							</div>	
								
							<table id="cart" class="table table-hover table-condensed" style="margin-top:100px;">
								<thead>
									<tr>
										<th>Codigo Barra</th>
										<th>Producto</th>
										<th>Cantidad</th>
										<th>Precio Venta</th>
										<th>SubTotal</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
								
								<c:forEach items="${detalleproductos}" var="detalleproducto">
									<tr>
										<td>${detalleproducto.getCodBarra()}</td>
										<td>${detalleproducto.getNombreProducto()}</td>
										<td>${detalleproducto.getCantidad()}</td>										
										<td>${detalleproducto.getPrecioVenta()}</td>
										<td>${detalleproducto.getTotal()}</td>
										<td class="actions" data-th="">	
											<button class="btn bg-blue btn-sm pull-right" name="refreshCart" value="${cartLine.id}"
											>
												<span class="glyphicon glyphicon-refresh"></span>
											</button>
											<a class="btn bg-red btn-sm pull-right" href="${contextRoot}/cart/${cartLine.id}/delete" >
												<span class="glyphicon glyphicon-trash"></span>
											</a>										
										</td>
									</tr>								
								</c:forEach>	
								</tbody>							
								<tfoot>
									<tr>
										<th>Codigo Barra</th>
										<th>Producto</th>
										<th>Cantidad</th>
										<th>Precio Venta</th>
										<th>SubTotal</th>
										<th></th>
									</tr>
								</tfoot>
							</table>
						</div>
						<!-- /.box-body -->
						<div class="box-footer">
						 <div class="col-sm-6">
				          <button class="btn bg-purple" type="submit" id="btnGuardar"><i class="fa fa-save"></i> Generar Venta</button>
				          <a href="${contextRoot}/PageController?ruta=listProduct" class="btn bg-maroon"><i class="fa fa-arrow-circle-left"></i> Cancelar</a>
				         </div>
				         <div class="pull-right">
				         	<div class="form-group">			
								<label class="col-sm-4 control-label">Total</label>
								<div class="col-sm-8">
									<input type="text" name="txtTotal" value="${totalPagar}" class="form-control">
								</div>
				        	</div>
					    </div>
					<!-- /.box -->
           		</div>
          </div>
      
      
      
    </section>
    <!-- /.content -->	
	
	
	<!-- Modal -->
  <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
    <div class="modal-dialog" style="width: 65% !important;">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          <h4 class="modal-title">Seleccione un Producto</h4>
        </div>
        <div class="modal-body">
          <table id="tblProductos" class="table table-striped table-bordered table-condensed table-hover">
            <thead>
                <th>Opciones</th>
                <th>Codigo Barra</th>
                <th>Producto</th>
                <th>Stock</th>                
                <th>Precio Venta</th>                
            </thead>
            <tbody>
              
            </tbody>
            <tfoot>
              	<th>Opciones</th>
                <th>Codigo Barra</th>
                <th>Producto</th>
                <th>Stock</th>                
                <th>Precio Venta</th>                
            </tfoot>
          </table>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
        </div>        
      </div>
    </div>
  </div>  
  <!-- Fin modal -->
	
	
	        
			
  </div>
  <!-- /.content-wrapper -->
  
  <%@include file="../WEB-INF/jspf/footer.jspf" %>

  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->


<%@include file="../WEB-INF/jspf/js/jsSrc.jspf" %>
<script src="${contextRoot}/resources/js/ventajs.js"></script>
<script type="text/javascript">
$(function() {

//code for jquery dataTable
var $table = $('#tblProductos');
// execute the below code only where we have this table
if ($table.length) {
	// console.log('Inside the table!');
	var jsonUrl = '';
	jsonUrl = window.contextRoot + '/JsonController?tabla=producto';
	
	$table
			.DataTable({
				"paging": true,
		        "lengthChange": true,
		        "searching": true,
		        "ordering": true,
		        "info": false,
		        "responsive": true,
		        "autoWidth": false,			        
				ajax : {
					url : jsonUrl,
					dataSrc : ''
				},
				columns : [
						{
							data : 'codBarra',
							bSortable : false,
							mRender : function(data, type, row) {

								var str = '';
								if (row.stockActual < 1) {
									str += '<a href="javascript:void(0)" class="btn bg-blue disabled"><span class="fa fa-plus"></span></a>';
								} else {

									str += '<a href="'
											+ window.contextRoot+'/ManageController?op=add&codBarra='+data+'" class="btn bg-blue"><span class="fa fa-plus"></span></a>';
								}
								return str;
		 					}
						},
						{
							data : 'codBarra'
						},
						{
							data : 'nombreProducto'
						},
						{
							data : 'stockActual',
							mRender : function(data, type, row) {

								if (data < 1) {
									return '<span style="color:red">fuera de Stock!</span>';
								}

								return data;

							}
						},
						{
							data : 'precioVenta'
						}
					]
			});
}
		
});
</script>
</body>
</html>