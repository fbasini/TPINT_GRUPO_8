<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="entidad.Estadistica" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Estadisticas de usuarios</title>
</head>
<body>

<div>
<form action="../calcularEstadisticasServlet" method="get">
	<label for="ddlTipo">Seleccione la estadistica de dinero a obtener:</label>
	<select name="ddlTipo">
		<option value="sum">SUMA TOTAL</option>
		<option value="max">MAYOR VALOR</option>
		<option value="min">MENOR VALOR</option>
			
	</select> <br>
	
	<label for="ddlTabla">Seleccione la fuente:</label>
	<select name="ddlTabla">
		<option value="prestamos"> Prestamos a clientes</option>
		<option value="movimientos"> Movimientos de dinero</option>
		
	</select> <br>
	
	<label for="txtFechaInicio">Ingrese la fecha incial para recopilar datos:</label>
	<input type="date" name="txtFechaInicio" required pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))">
	<br>
	
	<label for="txtFechaFinal">Ingrese la fecha final para recopilar datos:</label>	
	<input type="date" name="txtFechaFinal" required pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))">
	<br>
	
	<button type="submit" name="btnMostrarDatos" value="btn2">MOSTRAR</button>
</form>
	<% if (request.getAttribute("estadistica")!= null){
		Estadistica estadistica = new Estadistica();
		estadistica = (Estadistica)request.getAttribute("estadistica");%>
	
	<h6> El resultado es: <%= estadistica.getMontoResultado() %> perteneciente al cliente con ID: <%= estadistica.getIdResultado() %> </h6>
	<%} %>
	<br>
</div>
<div>	
<form action="../calcularEstadisticasServlet" method="get">
	<label for="ddlConteo">Cantidad de usuarios de sexo:</label>
	<select name="ddlConteo">
		<option value="M">Masculino</option>
		<option value="F">Femenino</option>
		<option value="O">Otro</option>
		</select> 
		<br>
	
	<button type="submit" name="btnMostrarConteo" value="btn2">MOSTRAR</button>
</form>
	<% if (request.getAttribute("conteo")!= null){
		%>
	
	<h6> La cantidad de persona/s del sexo seleccionado es: <%= request.getAttribute("conteo") %> </h6>
		
	<%} %>
</div>
</body>
</html>