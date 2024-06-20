<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar Cliente</title>
</head>
<div>
	<h1 id="usuario" style="position: absolute; top: 1px ;right:6px " >Nombre usuario</h1>
</div>
<body style="display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0;">

 <div>
<label  for="lbMenu">Agregar Usuario</label>
        <form action="AgregarClienteServlet" method="post">
            <table style="margin: 0 auto;">
                <tr>
                    <td style="text-align: left;"><label for="usuario">Usuario:</label></td>
                    <td><input type="text" id="usuario" name="usuario"></td>
                </tr>
                <tr>
                    <td style="text-align: left;"><label for="contraseña">Contraseña:</label></td>
                    <td><input type="password" id="contraseña" name="contraseña"></td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center; padding-top: 15px;">
                        <button type="submit">Agregar</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>


</body>
</html>