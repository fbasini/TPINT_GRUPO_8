<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Creacion de Cuenta</title>
</head>
<body>
 <div>
 <h1 id="usuario" style="position: absolute; top:1px; right:6px">Nombre Usuario</h1>
	<h2>Creacion de Cuenta</h2>
</div>

<div>
<form action="../agregarCuentaServlet" method="post">
<table style="width: 353px; text-align:center;">
	<tbody>
		
		
		<tr>
			<th>Tipo de cuenta</th>
			<td><select name="tipoCuenta" id="tipoCuenta">
					 <option value="Caja de ahorro">Caja de ahorro</option>
			        <option value="Cuenta corriente">Cuenta corriente</option>
			    </select>
			</td>	
		
		<tr>
			<th>CBU</th>
			<td><input type="number" name="txtCBU" id="txtCBU"></td>	
			
		</tr>
		
		<tr>

			<td colspan="2" style=" height:50px;"><button type="submit" name="btnAsignar" style="text-align:center; border-radius: 5px;">Crear</button>
		</tr>
	</tbody>
</table>
</form>
</div>
</body>
</html>