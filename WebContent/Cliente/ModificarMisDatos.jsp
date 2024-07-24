<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="entidad.Cliente" %>
<%@ page import="entidad.Provincias" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar Mis Datos</title>
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
                        <button type="submit" class="btn-cerrar-sesion">Cerrar Sesion</button>
                    </form>
                </li>
            </ul>
        </div>
    </nav>

<% Cliente clienteActual = (Cliente) request.getSession().getAttribute("clienteActual"); %>
<form action="../ManejarDatosServlet" method="post">
<h5>DNI:</h5> <input name="txtDNI" type="number" required value="<%= clienteActual.getDNIcliente() %>" min="1" max="100000000" maxlength="11" oninput="this.value=this.value.replace(/[^0-9]/g,'');">

<h5>CUIL:</h5> <input name="txtCUIL" value="<%= clienteActual.getCUILcliente() %>" type="number" required min="1" max="1000000000000" maxlength="11" oninput="this.value=this.value.replace(/[^0-9]/g,'');">

<h5>NOMBRE:</h5> <input name="txtNombre" value="<%= clienteActual.getNombreCliente() %>" type="text" required maxlenght="60" onkeypress='return ((event.charCode >= 65 && event.charCode <= 90) || (event.charCode >= 97 && event.charCode <= 122) || (event.charCode == 32))'>

<h5>APELLIDO:</h5> <input name="txtApellido" value="<%= clienteActual.getApellidoCliente() %>" type="text" required maxlenght="60" onkeypress='return ((event.charCode >= 65 && event.charCode <= 90) || (event.charCode >= 97 && event.charCode <= 122) || (event.charCode == 32))'>

<h5>SEXO:</h5> <select name="txtSexo">
			<option value="M">Masculino</option>
			<option value="F">Femenino</option>
			<option value="O">Otro</option>
			</select>

<h5>NACIONALIDAD:</h5> <input name="txtNacionalidad" value="<%= clienteActual.getNacionalidadCliente() %>" type="text" required maxlenght="60" onkeypress='return ((event.charCode >= 65 && event.charCode <= 90) || (event.charCode >= 97 && event.charCode <= 122) || (event.charCode == 32))'>

<h5>FECHA DE NACIMIENTO</h5> <input type="date" name="txtFechaNacimiento" required pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))"
		 value="<%= clienteActual.getFechaNacimientoCliente() %>">

<h5>DIRECCION:</h5> <input name="txtDireccion" required value="<%= clienteActual.getDireccionCliente() %>" type="text" required maxlenght="60">

<h5>LOCALIDAD:</h5> <input name="txtLocalidad" required value="<%= clienteActual.getLocalidadCliente() %>" type="text" required maxlenght="60">

<h5>PROVINCIA:</h5> <select name="ddlProvincia" id="provincia" required>
				<% ArrayList<Provincias> listaProvincias = (ArrayList<Provincias>) request.getSession().getAttribute("listaProvincias");
	                
	   			if (listaProvincias != null) {
	     		for (Provincias provincia : listaProvincias) { %>
	    	 
	    	 <option value= "<%= provincia.getIdProvincias() %>" ><%= provincia.getNombreProvincia() %> </option>
	    	 
	      <%} }%>
	      </select>

<h5>EMAIL:</h5> <input type="email" required name="txtEmail" value="<%= clienteActual.getEmailCliente() %>">

<h5>TELEFONO:</h5> <input name="txtTelefono" value="<%= clienteActual.getTelefonoCliente() %>" type="number" required min="1" max="1000000000000" maxlength="11" oninput="this.value=this.value.replace(/[^0-9]/g,'');">
<br>
<button  type="submit" name="btnSolicitar" 
onclick="return confirm('¿Esta seguro que desea modificar sus datos?');">MODIFICAR</button>
</form>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>