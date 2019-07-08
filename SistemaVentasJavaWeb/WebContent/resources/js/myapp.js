$(function() {
	
	switch (menu) {
	case 'Home':
		$('#modhome').addClass('active treeview');
		$('#home').addClass('active');
		break;
	case 'Producto':
		$('#modalmacen').addClass('active treeview');
		$('#producto').addClass('active');
		break;
	case 'Cliente':
		$('#modventa').addClass('active treeview');
		$('#cliente').addClass('active');
		break;
	case 'Vendedor':
		$('#modventa').addClass('active treeview');
		$('#vendedor').addClass('active');		
		break;
	case 'Factura':
		$('#modventa').addClass('active treeview');
		$('#venta').addClass('active');
		break;	
	default: 
		break;	
	}	
	
	// code for jquery dataTable
	var $table = $('#clienteListTable');
	// execute the below code only where we have this table
	if ($table.length) {
		// console.log('Inside the table!');
		var jsonUrl = '';
		jsonUrl = window.contextRoot + '/JsonController?tabla=cliente';
		
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
								data : 'codCliente'
							},
							{
								data : 'nombres'
							},
							{
								data : 'apellidos'
							},
							{
								data : 'direccion'								
							},
							{
								data : 'direccion'
								
							} ]
				});
	}
	
	// code for jquery dataTable
	var $table2 = $('#vendedorListTable');
	// execute the below code only where we have this table
	if ($table2.length) {
		// console.log('Inside the table!');
		var jsonUrl2 = '';
		jsonUrl2 = window.contextRoot + '/JsonController?tabla=vendedor';
		
		$table2
				.DataTable({
					"paging": true,
			        "lengthChange": true,
			        "searching": true,
			        "ordering": true,
			        "info": false,
			        "responsive": true,
			        "autoWidth": false,			        
					ajax : {
						url : jsonUrl2,
						dataSrc : ''
					},
					columns : [
							{
								data : 'codVendedor'
							},
							{
								data : 'nombres'
							},
							{
								data : 'apellidos'
							},
							{
								data : 'dui'
							},
							{
								data : 'celular'
							},
							{
								data : 'direccion'								
							},
							{
								data : 'codVendedor',
								bSortable : false,
								mRender : function(data, type, row) {

									var str = '';
									str += '<button class="btn bg-purple"><span class="glyphicon glyphicon-pencil"></span></a> &#160;';
									return str;
								}
								
							} ]
				});
	}
	
	
	// code for jquery dataTable
	var $table3 = $('#productListTable');
	// execute the below code only where we have this table
	if ($table3.length) {
		// console.log('Inside the table!');
		var jsonUrl3 = '';
		jsonUrl3 = window.contextRoot + '/JsonController?tabla=producto';
		
		$table3
				.DataTable({
					"paging": true,
			        "lengthChange": true,
			        "searching": true,
			        "ordering": true,
			        "info": false,
			        "responsive": true,
			        "autoWidth": false,			        
					ajax : {
						url : jsonUrl3,
						dataSrc : ''
					},
					columns : [
							{
								data : 'codProducto'
							},
							{
								data : 'nombreProducto'
							},
							{
								data : 'precioVenta'
							},
							{
								data : 'stockActual'								
							},
							{
								data : 'codBarra'
								
							}, 
							{
								data : 'codProducto',
								bSortable : false,
								mRender : function(data, type, row) {

									var str = '';
									str += '<a href="'+window.contextRoot+'/ManageController?op=edit&id='+data+'" class="btn bg-purple"><span class="glyphicon glyphicon-pencil"></span></a> &#160;';
									str += '<a href="javascript:void(0)" id="deleteP" data-id="'+data+'" class="btn bg-orange"><span class="glyphicon glyphicon-trash"></span></a>';
									return str;
								}
								
							}
							]
				});
	}
	
	
	
	
	
	
			
});