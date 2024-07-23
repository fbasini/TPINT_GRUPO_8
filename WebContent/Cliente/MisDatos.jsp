<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="entidad.Cliente" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MIS DATOS</title>
</head>
<body>
<% Cliente clienteActual = (Cliente) request.getSession().getAttribute("clienteActual"); %>

<table>
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
	<td><%= clienteActual.getIdProvincias() %></td>
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


<button onclick="history.back()" > VOLVER</button>
<form action="ModificarMisDatos.jsp"> <button type= "submit"> MODIFICAR DATOS</button>
</form>

</body>
</html>