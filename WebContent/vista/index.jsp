<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<!-- FontAwesome 4.7 -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Estilo principal -->	
<link rel="stylesheet" href="assets/css/main.css">

<title>Practica Examen</title>
</head>
<body>
	<section id="panel-cliente">
	<div class="container container-margin">
		<h3 class="text-center">
			<b>Practica Examen</b>
		</h3>
		<div class="">
			<div class="row">
				<div class="col-sm">
					<h5>
						<b>Registro de Clientes</b>
					</h5>
					<form id="registroCliente">
						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="inputNombre">Nombre:</label>
								<input type="text" class="form-control" id="inputNombre" name="nombre" placeholder="Jhon">
							</div>
							<div class="form-group col-md-6">
								<label for="inputApellidos">Apellidos:</label>
								<input type="text" class="form-control" id="inputApellidos" name="apellidos" placeholder="Smith Doe">
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="inputCorreo">Correo electronico:</label>
								<input type="text" class="form-control" id="inputCorreo" name="correo" placeholder="tucorreo@gmail.com">
							</div>
							<div class="form-group col-md-6">
								<label for="inputTelefono">Telefono:</label>
								<input type="text" class="form-control" id="telefono" name="telefono" placeholder="000 000 0000">
							</div>
						</div>
						<button type="submit" id="btnGuardar" class="btn btn-success">Guardar</button>
					</form>
				</div>
				<div class="col-sm content-center">
					<h5>
						<b>Listado de Clientes</b>
					</h5>
					<div class="row" style="margin: 10px">
						<div class="col">
							<button type="button" id="obtenerInformacion" class="btn btn-info">Obtener
								clientes</button>
						</div>
					</div>
					<div class="table-responsive">
						<table class="table table-bordered" id="listaClientes">
							<thead class="thead-dark">
								<tr>
									<th scope="col-md-2">#</th>
									<th scope="col-md-3">Nombre Completo</th>
									<th scope="col-md-3">Correo</th>
									<th scope="col-md-2">Telefono</th>
									<th scope="col-md-2">Opciones</th>
								</tr>
							</thead>
							<tbody>
							
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	</section>
	
	<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
	<script src="assets/js/main.js"></script>
</body>
</html>