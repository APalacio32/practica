$(document).ready(function() {
	/*
	 * Evento para Guardar la informacion del cliente
	 * */
	$("#btnGuardar").click(function(e) {
		event.preventDefault();
		
		//Peticion AJAX para enviar la informacion al servidor
		$.ajax({
			method : "post",
			url : "http://localhost:8080/Practica-Examen/AdminClient?action=add",
			data: $("#registroCliente").serialize()
		}).done(function(response) {
			console.log(response);
			if(response == "true"){
				//Mostrar alerta
				Swal.fire(
						  'Exito',
						  'Informacion guardada exitosamente.',
						  'success'
						)
						
				//Limpiar formulario
				$("#registroCliente")[0].reset();		
			}
		});
	});
	
	/*
	 * Evento para traer la informacion de los clientes
	 */

	$("#obtenerInformacion").click(function(e) {

		$.ajax({
			method : "get",
			url : "http://localhost:8080/Practica-Examen/AdminClient?action=list",
			dataType : "json"
		}).done(function(response) {
			if(response.result.length === 0){
				console.log("Esta vacio");
			}else{
				var html = '';
				var contador = 1;
				
				for(var i = 0; i < response.result.length; i++) {
					html += '<tr><td>' + contador++ + '</td><td>' + response.result[i].nombre+' '+response.result[i].apellidos + '</td><td>' + response.result[i].correo + '</td><td>' + response.result[i].telefono + '</td><td id="consecutivo">'+'<a href="#" data-href="' + response.result[i].id + '" class="btn btn-danger eliminar"><i class="fa fa-trash"></i></a>'+'</td></tr>';
				}
				$('#listaClientes tbody').append(html);
			}
		});
	});
	
	//Eliminar
	/*$(".eliminar").click(function(e) {
		console.log("eliminar");
		$.ajax({
			method : "post",
			url : "http://localhost:8080/Practica-Examen/AdminClient?action=eliminar",
			dataType : "json"
		}).done(function(response) {
			
		});
	});*/
	
	$(document).on('click', '.eliminar', function (event) {
	    event.preventDefault();
	    //console.log("Eliminar dato");
	    
	    //var idFila = $("#consecutivo").val();
	    //console.log(idFila);
	    $(this).closest('tr').remove();
	    
	    var id = $(this).attr('data-href');
	    
	    
	    $.ajax({
			method : "post",
			url : "http://localhost:8080/Practica-Examen/AdminClient?action=eliminar",
			data : {id:id},
		}).done(function(response) {
			console.log(response);
		});
	});
});
