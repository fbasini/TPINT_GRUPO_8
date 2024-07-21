<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div>
 <h1 id="usuario" style="position: absolute; top:1px; right:6px">Nombre Usuario</h1>
	<h2>Asignación de cuenta</h2>
</div>

<div>
	<form action="../AltaCuentaServlet" method="post">
        <table style="width: 353px; text-align:center;">
            <tbody>
                <tr>
                    <th>Cliente</th>
                    <td style="width: 175px;">
                        <select name="usuarios" id="selectUsuarios">
                            <c:forEach var="cliente" items="${clientes}">
                                <option value="${cliente.idCliente}">${cliente.nombre}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>N° de cuenta</th>
                    <td>
                        <select name="numeroCuentaAsig" id="selectNumeroCuentaAsig">
                            <c:forEach var="cuenta" items="${cuentasDisponibles}">
                                <option value="${cuenta.idCuenta}">${cuenta.idCuenta}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" style="height:50px;">
                        <button type="submit" name="btnAsignar" style="text-align:center; border-radius: 5px;">Asignar</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </form>
</div>



<div>
<h2>Eliminar Cuenta</h2>
	<form action="EliminarCuentaServlet" method="post">
	<table style="width: 200px; text-align:center;">
		<tbody>
			<tr>
				<th>Cliente</th>
				<td style="width: 104px; ">
					<select name="usuarios" id="usuarios">
				        
				    </select>
				</td>	
				
			</tr>
			<tr>
					<th>N° de cuenta</th>
					<td><select name="numeroCuentaElim" id="numeroCuentaElim">
					</select>
					</td>	
					
				</tr>
			
			<tr>
	
				<td colspan="2" style=" height:50px; width: 210px"><button type="submit" name="btnEliminar" style="text-align:center; border-radius: 5px;">Eliminar</button>
			</tr>
		</tbody>
	</table>
	</form>
</div>

<div>
	<h2>Modificar Cuenta</h2>
	<form action="ModificarCuentaServlet" method="post">
		<table style="width: 353px; text-align:center;">
			<tbody>
				<tr>
					<th>Cliente</th>
					<td style="width: 175px; ">
						<select name="usuarios" id="usuarios">
					        
					        
					    </select>
					</td>	
					
				</tr>
				
				<tr>
					<th>N° de cuenta</th>
					<td><select name="numeroCuenta" id="numeroCuenta">
					</select>
					</td>	
					
				</tr>
				
				
				<tr>
					<th>Tipo de cuenta</th>
					<td><select name="tipoCuenta" id="tipoCuenta">
							 
					    </select>
					</td>	
				</tr>
				
				<tr>
					<th>CBU</th>
					<td><input type="number" name="txtCBU" id="txtCBU"></td>	
					
				</tr>
				<tr>
					<th>Saldo</th>
					<td><input type="number" name="txtMontoInicial" id="txtMontoInicial"></td>	
				</tr>
				<tr>
		
					<td colspan="2" style=" height:50px;"><button type="submit" name="btnModificar" style="text-align:center; border-radius: 5px;">Modificar</button>
				</tr>
			</tbody>
		</table>
	</form>
</div>

<div>
	<h2>Listar Cuenta</h2>
	<form action="ListarCuentaServlet" method="post">
		<table style="width: 353px; text-align:center;">
			<tbody>
				<tr>
					<th>Cliente</th>
					<th>Fecha de creación</th>
					<th>Tipo de cuenta</th>
					<th>N° de cuenta</th>
					<th>CBU</th>
					<th>Saldo</th>
				</tr>
				<tr>
					<td></td> <td></td> <td></td> <td></td>	<td></td> <td></td>		
				
			</tbody>
		</table>
	</form>
</div>
</body>
</html>