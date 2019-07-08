$(document).ready(function () {
	 $(document).on('click', '#deleteP', function(e){			
			var productoId = $(this).data('id');	
			SwalDeleteProducto(productoId);
			e.preventDefault();		
	 });
});

function ValidarCampos() {
	
	if ($("#nombre").val() == '') {		
		swal("Faltan Datos", "Debe ingresar el nombre de producto", "warning");
		return false;				
	}
	if ($("#precio").val() == '') {
		swal("Faltan Datos", "Debe ingresar el precio", "warning");
		return false;				
	}
	if ($("#stockminimo").val() == '') {		
		swal("Faltan Datos", "Debe ingresar el stock minimo", "warning");
		return false;				
	}
	if ($("#stockactual").val() == '') {
		swal("Faltan Datos", "Debe ingresar el stock actual", "warning");
		return false;				
	}
	if ($("#cbarra").val() == '') {
		swal("Faltan Datos", "Debe ingresar el codigo de barra", "warning");
		return false;				
	}

	return true;
} 	

function Mantenimiento() {
    var datos = $("#frmRegistro").serialize();
    Url = 'ManageController?op=Registrar';
        $('#frmRegistro').submit(function () {
        $.ajax({
            type: 'POST',
            url: Url,
            data: datos,
            success: function (results) {
                window.location.href = "PageController?ruta=listProduct";
                alert("Resultado: " + results);
            },
            error: function (xhr, status, error) {
                DisplayError(xhr);
            }
        })
        return false;
    });
}
function DisplayError(xhr) {
    var msg = JSON.parse(xhr.responseText);
    alert(msg.Message);
}

$('#btnGuardar').click(function () {
	
    if (!ValidarCampos()) {
        $('#frmRegistro').submit(function () {
            return false;
        });
    }
    else{
        Mantenimiento();
    }  
});


function valideKey(evt)
{
  var code = (evt.which) ? evt.which : evt.keyCode;
  if(code==8) 
  { 
    return true;
  }
  else if(code>=48 && code<=57) 
  {
    //is a number
    return true;
  }
  else
  {
    return false;
  }
}

function filterFloat(evt,input){
    // Backspace = 8, Enter = 13, ‘0′ = 48, ‘9′ = 57, ‘.’ = 46, ‘-’ = 43
    var key = window.Event ? evt.which : evt.keyCode;    
    var chark = String.fromCharCode(key);
    var tempValue = input.value+chark;
    if(key >= 48 && key <= 57){
        if(filter(tempValue)=== false){
            return false;
        }else{       
            return true;
        }
    }else{
          if(key == 8 || key == 13 || key == 0) {     
              return true;              
          }else if(key == 46){
                if(filter(tempValue)=== false){
                    return false;
                }else{       
                    return true;
                }
          }else{
              return false;
          }
    }
}
function filter(__val__){
    var preg = /^([0-9]+\.?[0-9]{0,2})$/; 
    if(preg.test(__val__) === true){
        return true;
    }else{
       return false;
    }
    
}


function SwalDeleteProducto(productoId){
	swal({
		title: 'Esta seguro?',
		text: "Estos datos se eliminaran permanentemente.!",
		type: 'warning',
		showCancelButton: true,
		confirmButtonColor: '#3085d6',
		cancelButtonColor: '#d33',
		confirmButtonText: 'Si, Deseo!',
		showLoaderOnConfirm: true,				
		preConfirm: function() {
		  return new Promise(function(resolve) {
		       
		     $.ajax({
		   		url: window.contextRoot+'/ManageController?op=delete&productoId='+productoId,
		    	type: 'POST',
		    	timeout : 100000		    	
		     })
		     .done(function(response){
		     	 swal('Deleted!', response.message, response.status);
		     	 var tableProducto = $('#productListTable').DataTable(); 
		     	 tableProducto.ajax.reload(null,false);
		     })
		     .fail(function(){
		     	swal('Oops...', 'Something went wrong with ajax !', 'error');
		     });
		  });
	    },
		allowOutsideClick: false			  
	});	
}









