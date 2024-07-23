<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="entidad.Cliente" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar Mis Datos</title>
</head>
<body>
<% Cliente clienteActual = (Cliente) request.getSession().getAttribute("clienteActual"); %>
<h5>DNI:</h5> <input name="txtDNI" value="<%= clienteActual.getDNIcliente() %>">

<h5>CUIL:</h5> <input name="txtCUIL" value="<%= clienteActual.getCUILcliente() %>">

<h5>NOMBRE:</h5> <input name="txtNombre" value="<%= clienteActual.getNombreCliente() %>">

<h5>APELLIDO:</h5> <input name="txtApellido" value="<%= clienteActual.getApellidoCliente() %>">

<h5>SEXO:</h5> <input name="txtSexo" value="<%= clienteActual.getSexoCliente() %>">

<h5>NACIONALIDAD:</h5> <input name="txtNacionalidad" value="<%= clienteActual.getNacionalidadCliente() %>">

<h5>FECHA DE NACIMIENTO</h5> <input name="txtFechaNacimiento" value="<%= clienteActual.getFechaNacimientoCliente() %>">

<h5>DIRECCION:</h5> <input name="txtDireccion" value="<%= clienteActual.getDireccionCliente() %>">

<h5>LOCALIDAD:</h5> <input name="txtLocalidad" value="<%= clienteActual.getLocalidadCliente() %>">

<h5>PROVINCIA:</h5> <input name="txtProvincia" value="<%= clienteActual.getIdProvincias() %>">

<h5>EMAIL:</h5> <input name="txtEmail" value="<%= clienteActual.getEmailCliente() %>">

<h5>TELEFONO:</h5> <input name="txtTelefono" value="<%= clienteActual.getTelefonoCliente() %>">

<form action="../ManejarDatosServlet" method="post"><button  type="submit" name="btnSolicitar" 
onclick="return confirm('¿Esta seguro que desea modificar sus datos?');">MODIFICAR</button>
</form>

</body>
</html>