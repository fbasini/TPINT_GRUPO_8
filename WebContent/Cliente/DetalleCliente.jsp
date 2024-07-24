<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="entidad.Cliente" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Detalle del Cliente</title>
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
                    <form action="../AdministrarClientes.jsp" method="post" class="form-inline">
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
        <h2>Detalle del Cliente</h2>
        <% Cliente clienteActual = (Cliente) request.getSession().getAttribute("clienteActual"); %>
            

            <ul class="list-group">
                <li class="list-group-item">ID: <%= clienteActual.getIdCliente() %></li>
                <li class="list-group-item">Usuario: <%= clienteActual.getNombreUsuario() %></li>
                <li class="list-group-item">DNI: <%= clienteActual.getDNIcliente() %></li>
                <li class="list-group-item">CUIL: <%= clienteActual.getCUILcliente() %></li>
                <li class="list-group-item">Nombre: <%= clienteActual.getNombreCliente() %> <%= clienteActual.getApellidoCliente() %></li>
                <li class="list-group-item">Sexo: <%= clienteActual.getSexoCliente() %></li>
                <li class="list-group-item">Nacionalidad: <%= clienteActual.getNacionalidadCliente() %></li>
                <li class="list-group-item">Fecha de Nacimiento: <%= clienteActual.getFechaNacimientoCliente() %></li>
                <li class="list-group-item">Dirección: <%= clienteActual.getDireccionCliente() %></li>
                <li class="list-group-item">Localidad: <%= clienteActual.getLocalidadCliente() %></li>
                <li class="list-group-item">Provincia: <%= clienteActual.getIdProvincias() %></li>
                <li class="list-group-item">Email: <%= clienteActual.getEmailCliente() %></li>
                <li class="list-group-item">Teléfono: <%= clienteActual.getTelefonoCliente() %></li>
            </ul>
        
    </div>
    
    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>