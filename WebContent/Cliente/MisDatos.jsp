<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="entidad.Cliente" %>
<%@ page import="entidad.Provincias" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MIS DATOS</title>
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
                        <button type="submit" class="btn-cerrar-sesion">Cerrar Sesion</button>
                    </form>
                </li>
            </ul>
        </div>
    </nav>

<div class="recuadro-gris">
    <% Cliente clienteActual = (Cliente) request.getSession().getAttribute("clienteActual"); %>

    <table class="datos">
        <tr> 
            <td>DNI:</td>
            <td><%= clienteActual.getDNIcliente() %></td>
        </tr>
        <tr>
            <td>CUIL:</td>
            <td><%= clienteActual.getCUILcliente() %></td>
        </tr>
        <tr>
            <td>NOMBRE:</td>
            <td><%= clienteActual.getNombreCliente() %></td>
        </tr>
        <tr>
            <td>APELLIDO:</td>
            <td><%= clienteActual.getApellidoCliente() %></td>
        </tr>
        <tr>
            <td>SEXO:</td>
            <td><%= clienteActual.getSexoCliente() %></td>
        </tr>
        <tr>
            <td>NACIONALIDAD:</td>
            <td><%= clienteActual.getNacionalidadCliente() %></td>
        </tr>
        <tr>
            <td>FECHA DE NACIMIENTO:</td>
            <td><%= clienteActual.getFechaNacimientoCliente() %></td>
        </tr>
        <tr>
            <td>DIRECCION:</td>
            <td><%= clienteActual.getDireccionCliente() %></td>
        </tr>
        <tr>
            <td>LOCALIDAD:</td>
            <td><%= clienteActual.getLocalidadCliente() %></td>
        </tr>
        <tr>
            <td>PROVINCIA:</td>
            <% ArrayList<Provincias> listaProvincias = (ArrayList<Provincias>) request.getSession().getAttribute("listaProvincias");
                 
                String nombreProvincia = "";
                if (listaProvincias != null) {
                    for (Provincias provincia : listaProvincias) {
                        if(provincia.getIdProvincias() == clienteActual.getIdProvincias()){
                            nombreProvincia = provincia.getNombreProvincia();
                        }
                    }
                } %>
            <td><%= nombreProvincia %></td>
        </tr>
        <tr>
            <td>EMAIL:</td>
            <td><%= clienteActual.getEmailCliente() %></td>
        </tr>
        <tr>
            <td>TELEFONO:</td>
            <td><%= clienteActual.getTelefonoCliente() %></td>
        </tr>
    </table>

    <form action="ModificarMisDatos.jsp">
        <button type="submit" class="btn-modificar">MODIFICAR DATOS</button>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

