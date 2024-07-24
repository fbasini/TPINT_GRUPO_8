<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="entidad.Cuenta" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Transferir Fondos</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../Style.css">
</head>
<body>
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
                <li class="nav-item">
                    <form action="UsuarioHome.jsp" method="post" class="form-inline">
                        <button type="submit" class="btn btn-link nav-link boton-links">Volver</button>
                    </form>
                </li>                
                <li class="nav-item">
                    <form action="../CerrarSesionServlet" method="post" class="form-inline">
                        <button type="submit" class="btn-cerrar-sesion">Cerrar Sesión</button>
                    </form>
                </li>
            </ul>
        </div>
    </nav>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
        	<!-- Cuenta Contenedor -->
    		<form action="/TPINT_GRUPO_8_LAB4/CuentasClienteServlet" method="post"> 
                <div class="cuenta-contenedor text-center">
                <h2>Mis Cuentas</h2>
                    <select name="misCuentas" id="misCuentas" class="form-control mx-auto" style="max-width: 300px;">
                    <option value="" disabled selected>Seleccione una cuenta</option>
                        <% 
                            ArrayList<Cuenta> cuentasCliente = (ArrayList<Cuenta>) session.getAttribute("cuentasCliente");
                            if (cuentasCliente != null) {
                                for (Cuenta cuenta : cuentasCliente) {
                        %>
                                    <option value="<%= cuenta.getIdcuenta() %>">
                                        Cuenta: <%= cuenta.getTipoCuenta() %> - Saldo: $<%= cuenta.getSaldoCuenta() %>
                                    </option>
                        <% 
                                }
                            }
                        %>
                    </select>
                    <button type="submit" class="btn btn-primary mt-2">Seleccionar Cuenta</button>
                </div>
                </form>
                
            <form action="/TPINT_GRUPO_8_LAB4/TransferenciasServlet" method="post">
	            <div class="form-group">
	                <label for="origenCuenta">Cuenta de Origen</label>
	                <input type="text" id="origenCuenta" name="origenCuenta" class="form-control" value="<%= session.getAttribute("idCuentaSeleccionada") != null ? session.getAttribute("idCuentaSeleccionada") : "" %>" readonly>
	            </div>
	            
                <div class="form-group">
                    <label for="cbuDestino">CBU del destinatario:</label>
                    <input type="text" class="form-control" id="cbuDestino" name="cbuDestino" required>
                </div>

                <div class="form-group">
                    <label for="importeATransferir">Importe:</label>
                    <input type="number" class="form-control" id="importeATransferir" name="importeATransferir" step="0.01" min="0" required>
                </div>

                <div class="form-group text-center">
                    <button type="submit" class="btn btn-primary">Transferir</button>
                </div>
            </form>
        </div>
    </div>
    <% 
                Object mensajeObj = request.getAttribute("mensaje");
                if (mensajeObj != null) {
                    String mensaje = (String) mensajeObj;
            %>
            <div class="text-center mt-3">
                <label class="custom-label"><%= mensaje %></label>
            </div>
            <% } %>
</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
