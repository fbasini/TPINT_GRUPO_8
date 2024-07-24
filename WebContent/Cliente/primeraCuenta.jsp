<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Primera cuenta</title>
</head>
<body>

<form action="../primeraCuentaServlet" method="post">
	<h5>¡Bienvenido a nuestro sistema de Home Banking!</h5> <br>
	<p>Recuerde solo por utilizar nuestros servicios inmediatemente recibe un bono de $10.000</p> <br>
	<label for="tipocuenta">Seleccione el tipo de su primera cuenta:</label>
	<select name="ddlTipoCuenta" id="tipocuenta" required>
		<option value=1> Caja de ahorro</option>
		<option value=2> Cuenta corriente</option>
	</select>
	<button type="submit" name="btnTipoCuenta">ACEPTAR</button>
</form>
</body>
</html>