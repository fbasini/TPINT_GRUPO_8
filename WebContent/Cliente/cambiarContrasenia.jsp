<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="../cambiarContraseniaServlet" method="post">
<label for="pssNueva1">Ingrese nueva contraseñia</label>
<input type= "password" name="pssNueva1" maxlenght="35" required>
<label for="pssNueva2">Ingrese repita nueva contraseñia</label>
<input type= "password" name="pssNueva2" maxlenght="35" required>
<br>
<button type="submit">CAMBIAR</button>

</form>

</body>
</html>