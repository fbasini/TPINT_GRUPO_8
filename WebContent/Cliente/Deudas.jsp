<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pago de Préstamo</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../Style.css">
</head>

<body >
 <!-- Header -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-bank" viewBox="0 0 16 16">
                <path d="m8 0 6.61 3h.89a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-.5.5H15v7a.5.5 0 0 1 .485.38l.5 2a.498.498 0 0 1-.485.62H.5a.498.498 0 0 1-.485-.62l.5-2A.5.5 0 0 1 1 13V6H.5a.5.5 0 0 1-.5-.5v-2A.5.5 0 0 1 .5 3h.89zM3.777 3h8.447L8 1zM2 6v7h1V6zm2 0v7h2.5V6zm3.5 0v7h1V6zm2 0v7H12V6zM13 6v7h1V6zm2-1V4H1v1zm-.39 9H1.39l-.25 1h13.72z"/>
            </svg>
        </a>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <span class="nav-link">Usuario: <%= session.getAttribute("usuario") %> </span>
                </li>
                <!-- 
                <li class="nav-item">
                    <form action="volver" method="post" class="form-inline">
                        <button type="submit" class="btn btn-link nav-link boton-links">Volver</button>
                    </form>
                </li>
                -->
                <li class="nav-item">
                    <form action="../CerrarSesionServlet" method="post" class="form-inline">
                        <button type="submit" class="btn-cerrar-sesion">Cerrar Sesiï¿½n</button>
                    </form>
                </li>
            </ul>
        </div>
    </nav>



<div>
	<select name="misCuentas" id="misCuentas">
        <option value="Cuenta1">Mi cuenta 1</option>
        <option value="Cuenta2">Mi cuenta 2</option>
        <option value="Cuenta3">Mi cuenta 3</option>
    </select>
 </div>
 

<h2>Pago de Préstamos</h2>
<div>
<table style="text-align:center;">
	<thead >
		<tr>
			<th style="width: 41px; "></th>
			<th style="width: 162px; ">Cuota a pagar</th>
			<th>Importe</th>
			<th style="width: 115px; ">Cuenta</th>
		</tr>
	</thead>
	<tbody>
		<tr style="width: 482px; ">
			<td style=" 30px; height: 13px"><input type="radio" name="radio" value="radio1"></td>	
			<td>4/6</td>
			<td style="width: 128px">10000</td>
			<td><select name="cuentas">
					<option value="cuenta1">Cuenta 1</option>
					<option value="cuenta1">Cuenta 2</option>
					<option value="cuenta1">Cuenta 3</option>
				</select> </td>
		</tr>
		<tr style="width: 482px; ">
			<td style=" 30px; height: 13px"><input type="radio" name="radio" value="radio2"></td>	
			<td>1/12</td>
			<td style="width: 128px">4166,666</td>
			<td><select name="cuentas">
					<option value="cuenta1">Cuenta 1</option>
					<option value="cuenta1">Cuenta 2</option>
					<option value="cuenta1">Cuenta 3</option>
				</select> </td>
		</tr>
		<tr>
			<td colspan="4" style=" height:50px;"><button type="submit" name="btnPagar" style="text-align:center; border-radius: 5px;">Pagar</button>
			</td>
		</tr>
		
	</tbody>
</table>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>