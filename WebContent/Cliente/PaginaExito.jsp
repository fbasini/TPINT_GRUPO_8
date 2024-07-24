<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Operacion exitosa</title>
</head>
<body>


<h3>${requestScope.mensaje}</h3>
<button onclick="history.back()">VOLVER</button>
<form action ="Cliente/UsuarioHome.jsp">
<button type="submit" value="home">VOLVER AL INICIO</button>
</form>

</body>
</html>