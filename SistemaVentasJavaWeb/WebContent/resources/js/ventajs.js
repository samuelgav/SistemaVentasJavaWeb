$(document).ready(function () {
	ListarCliente();
});


function ListarCliente() {
    $.ajax({
        url: "JsonController?tabla=cliente",
        type: "POST",
        success: function (results) {
            var str = '<option value="-1" selected>-- Seleccione Cliente --</option>';
            $("#selCliente").empty();
            $.each(results, function (i, item) {
                str += '<option value=' + item.codCliente + '>' + item.nombres +' '+ item.apellidos  + '</option>';
            });
            $("#selCliente").append(str);

        },
        error: function (xhr, status, error) {
            var err = JSON.parse(xhr.responseText);
            alert(err);            
        }    
      }); 
}

