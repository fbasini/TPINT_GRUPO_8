<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="entidad.Cuenta" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>UsuarioHome</title>
	<!-- Bootstrap CSS -->
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
                <!-- 
                <li class="nav-item">
                    <form action="volver" method="post" class="form-inline">
                        <button type="submit" class="btn btn-link nav-link boton-links">Volver</button>
                    </form>
                </li>
                -->
                <li class="nav-item">
                    <form action="../CerrarSesionServlet" method="post" class="form-inline">
                        <button type="submit" class="btn-cerrar-sesion">Cerrar Sesi�n</button>
                    </form>
                </li>
            </ul>
        </div>
    </nav>
    
    
     <!-- Main Content -->
    <div class="container" style="display: flex; justify-content: center; align-items: center; height: 100vh;">
    	<div class="text-center">
    	
    		<!-- Cuenta Contenedor -->
    		<form action="/TPINT_GRUPO_8_LAB4/CuentasClienteServlet" method="post">
                <div class="cuenta-contenedor">
                <h2>Mis Cuentas</h2>
                    <select name="misCuentas" id="misCuentas" class="form-control">
                        <% 
                            ArrayList<Cuenta> cuentasCliente = (ArrayList<Cuenta>) session.getAttribute("cuentasCliente");
                            if (cuentasCliente != null) {
                                for (Cuenta cuenta : cuentasCliente) {
                        %>
                                    <option value="<%= cuenta.getIdcuenta() %>">
                                        Cuenta: <%= cuenta.getIdcuenta() %> - Saldo: $<%= cuenta.getSaldoCuenta() %>
                                    </option>
                        <% 
                                }
                            }
                        %>
                    </select>
                </div>
                </form>
                
                <div class="btn-group-vertical">
                <form action="../manejarDatosServlet" method="get">
                    <button type="submit" id="misDatos" name="misDatos" class="btn btn-primary mb-2">MIS DATOS</button>
                </form>
                <form action="MisMovimientos.jsp" method="post">
                    <button type="submit" id="misMovimientos" name="misMovimientos" class="btn btn-primary mb-2">MIS MOVIMIENTOS</button>
				</form>
				<form action="Deudas.jsp" method="post">                   
                    <button type="submit" id="misDeudas" name="misDeudas" class="btn btn-primary mb-2">PAGO DE DEUDAS</button>
				</form>
				<form action="TransferirFondos.jsp" method="post">                    
                    <button type="submit" id="transferirFondos" name="transferirFondos" class="btn btn-primary mb-2">TRANSFERIR FONDOS</button>
				</form>	                    
                <form action="../solicitarPrestamoServlet" method="get">
                    <button type="submit" id="solicitarPrestamo" name="solicitarPrestamo" class="btn btn-primary mb-2">SOLICITAR PRESTAMO</button>
                </form>
            </div>
    	</div>
   	</div>
   	
   	 <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>