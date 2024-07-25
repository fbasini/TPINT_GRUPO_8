<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="entidad.Cliente" %>
<%@ page import="entidad.Provincias" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
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
                
                <li class="nav-item">
                    <form action="MisDatos.jsp" method="post" class="form-inline">
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
    <form action="../manejarDatosServlet" method="post">
        <table class="datos">
            <tr>
                <td><label class="custom-label" for="txtDNI">DNI:</label></td>
                <td><input id="txtDNI" name="txtDNI" type="number" class="custom-input" required value="<%= clienteActual.getDNIcliente() %>" min="1" max="100000000" maxlength="11" oninput="this.value=this.value.replace(/[^0-9]/g,'');"></td>
            </tr>
            <tr>
                <td><label class="custom-label" for="txtCUIL">CUIL:</label></td>
                <td><input id="txtCUIL" name="txtCUIL" type="number" class="custom-input" required value="<%= clienteActual.getCUILcliente() %>" min="1" max="1000000000000" maxlength="11" oninput="this.value=this.value.replace(/[^0-9]/g,'');"></td>
            </tr>
            <tr>
                <td><label class="custom-label" for="txtNombre">NOMBRE:</label></td>
                <td><input id="txtNombre" name="txtNombre" type="text" class="custom-input" required value="<%= clienteActual.getNombreCliente() %>" maxlength="60" onkeypress='return ((event.charCode >= 65 && event.charCode <= 90) || (event.charCode >= 97 && event.charCode <= 122) || (event.charCode == 32))'></td>
            </tr>
            <tr>
                <td><label class="custom-label" for="txtApellido">APELLIDO:</label></td>
                <td><input id="txtApellido" name="txtApellido" type="text" class="custom-input" required value="<%= clienteActual.getApellidoCliente() %>" maxlength="60" onkeypress='return ((event.charCode >= 65 && event.charCode <= 90) || (event.charCode >= 97 && event.charCode <= 122) || (event.charCode == 32))'></td>
            </tr>
            <tr>
                <td><label class="custom-label" for="txtSexo">SEXO:</label></td>
                <td>
                    <select id="txtSexo" name="txtSexo" class="custom-input">
					    <option value="M" <%= clienteActual.getSexoCliente() == 'M' ? "selected" : "" %>>Masculino</option>
					    <option value="F" <%= clienteActual.getSexoCliente() == 'F' ? "selected" : "" %>>Femenino</option>
					    <option value="O" <%= clienteActual.getSexoCliente() == 'O' ? "selected" : "" %>>Otro</option>
					</select>
                </td>
            </tr>
            <tr>
                <td><label class="custom-label" for="txtNacionalidad">NACIONALIDAD:</label></td>
                <td><input id="txtNacionalidad" name="txtNacionalidad" type="text" class="custom-input" required value="<%= clienteActual.getNacionalidadCliente() %>" maxlength="60" onkeypress='return ((event.charCode >= 65 && event.charCode <= 90) || (event.charCode >= 97 && event.charCode <= 122) || (event.charCode == 32))'></td>
            </tr>
            <tr>
                <td><label class="custom-label" for="txtFechaNacimiento">FECHA DE NACIMIENTO:</label></td>
                <td><input id="txtFechaNacimiento" type="date" name="txtFechaNacimiento" class="custom-input" required pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))" value="<%= clienteActual.getFechaNacimientoCliente() %>"></td>
            </tr>
            <tr>
                <td><label class="custom-label" for="txtDireccion">DIRECCION:</label></td>
                <td><input id="txtDireccion" name="txtDireccion" type="text" class="custom-input" required value="<%= clienteActual.getDireccionCliente() %>" maxlength="60"></td>
            </tr>
            <tr>
                <td><label class="custom-label" for="txtLocalidad">LOCALIDAD:</label></td>
                <td><input id="txtLocalidad" name="txtLocalidad" type="text" class="custom-input" required value="<%= clienteActual.getLocalidadCliente() %>" maxlength="60"></td>
            </tr>
            <tr>
                <td><label class="custom-label" for="ddlProvincia">PROVINCIA:</label></td>
                <td>
                    <select id="ddlProvincia" name="ddlProvincia" class="custom-input" required>
                        <% ArrayList<Provincias> listaProvincias = (ArrayList<Provincias>) request.getSession().getAttribute("listaProvincias");
                        if (listaProvincias != null) {
                            for (Provincias provincia : listaProvincias) { %>
                            <option value="<%= provincia.getIdProvincias() %>" <%= clienteActual.getIdProvincias() == provincia.getIdProvincias() ? "selected" : "" %>> <%= provincia.getNombreProvincia() %> </option>
                        <% } } %>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label class="custom-label" for="txtEmail">EMAIL:</label></td>
                <td><input id="txtEmail" type="email" name="txtEmail" class="custom-input" required value="<%= clienteActual.getEmailCliente() %>"></td>
            </tr>
            <tr>
                <td><label class="custom-label" for="txtTelefono">TELEFONO:</label></td>
                <td><input id="txtTelefono" name="txtTelefono" type="number" class="custom-input" required value="<%= clienteActual.getTelefonoCliente() %>" min="1" max="1000000000000" maxlength="11" oninput="this.value=this.value.replace(/[^0-9]/g,'');"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <button type="submit" name="btnSolicitar" class="btn-modificar" onclick="return confirm('¿Está seguro que desea modificar sus datos?');">MODIFICAR</button>
                </td>
            </tr>
        </table>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
