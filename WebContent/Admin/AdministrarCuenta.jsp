<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="entidad.Cuenta" %>
    <%@ page import="entidad.Cliente" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../Style.css">
    <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/2.0.8/css/dataTables.dataTables.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script type="text/javascript" charset="utf8" src="//cdn.datatables.net/2.0.8/js/dataTables.min.js"></script> 
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
                         <% ArrayList<Cliente> clientes = (ArrayList<Cliente>) request.getSession().getAttribute("clientesAll");
                           
                           if (clientes != null) {
						     for (Cliente cliente : clientes) { %>
                           
                                <option value="<%= cliente.getIdCliente() %>" >Cliente:<%= cliente.getNombreUsuario() %></option>
                                
                                
                            <%} }%>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>N° de cuenta</th>
                    <td>
                        <select name="numeroCuentaAsig" id="selectNumeroCuentaAsig">
                        
                            <% ArrayList<Cuenta> cuentasCliente1 = (ArrayList<Cuenta>) request.getSession().getAttribute("cuentasClientesDisp");
	                
						   if (cuentasCliente1 != null) {
						     for (Cuenta cuenta : cuentasCliente1) { %>
	    	 
                                <option value="<%= cuenta.getIdcuenta() %>" >Cuenta:<%= cuenta.getIdcuenta() %></option>
                             <%} }%>
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
				        <% ArrayList<Cliente> clientes2 = (ArrayList<Cliente>) request.getSession().getAttribute("allClientes");
                           
                           if (clientes2 != null) {
						     for (Cliente cliente : clientes2) { %>
						     <option value="<%= cliente.getIdCliente() %>" >Cliente:<%= cliente.getNombreUsuario() %></option>
                                
                                
                            <%} }%>
				    </select>
				</td>	
				
			</tr>
			<tr>
					<th>N° de cuenta</th>
					<td><select name="numeroCuentaElim" id="numeroCuentaElim">
					<% ArrayList<Cuenta> cuentasCliente2 = (ArrayList<Cuenta>) request.getSession().getAttribute("cuentasCliente1");
	                
						   if (cuentasCliente2 != null) {
						     for (Cuenta cuenta : cuentasCliente2) { %>
	    	 
                                <option value="<%= cuenta.getIdcuenta() %>" >Cuenta:<%= cuenta.getIdcuenta() %></option>
                             <%} }%>
					
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
					        <% ArrayList<Cliente> clientes3 = (ArrayList<Cliente>) request.getSession().getAttribute("allClientes");
                           
                           if (clientes3 != null) {
						     for (Cliente cliente : clientes3) { %>
						     <option value="<%= cliente.getIdCliente() %>" >Cliente:<%= cliente.getNombreUsuario() %></option>
                                
                                
                            <%} }%>
					        
					    </select>
					</td>	
					
				</tr>
				
				<tr>
					<th>N° de cuenta</th>
					<td><select name="numeroCuenta" id="numeroCuenta">
					<% ArrayList<Cuenta> cuentasCliente3 = (ArrayList<Cuenta>) request.getSession().getAttribute("cuentasCliente1");
	                
						   if (cuentasCliente3 != null) {
						     for (Cuenta cuenta : cuentasCliente3) { %>
	    	 
                                <option value="<%= cuenta.getIdcuenta() %>" >Cuenta:<%= cuenta.getIdcuenta() %></option>
                             <%} }%>
					
					</select>
					</td>	
					
				</tr>
				
				
				<tr>
					<th>Tipo de cuenta</th>
					<td><select name="tipoCuenta" id="tipoCuenta">
							 <option value="1">Tipo de Cuenta: Caja de ahorro</option>
							 <option value="2">Tipo de Cuenta: Cuenta corriente</option>
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
		<table class="table table-bordered" style="width: 353px; text-align:center;">
		<thead>
	            <tr>
	                <th>IdCuenta</th>
	                <th>IdCliente</th>
	                <th>Tipo Cuenta</th>
	                <th>Fecha Creacion</th>
	                <th>CBU Cuenta</th>
	                <th>Saldo Cuenta</th>
	                <th>Cuenta Activa</th>
	            </tr>
	        </thead>
		
			<tbody>
			<% ArrayList<Cuenta> cuentasCliente4 = (ArrayList<Cuenta>) request.getSession().getAttribute("cuentasCliente1");
	                
						   if (cuentasCliente4 != null) {
						     for (Cuenta cuenta : cuentasCliente4) { %>
			
				<tr>
					<th>
					<%= cuenta.getIdcuenta() %>
					</th>
					<th>
					<%= cuenta.getIdcliente() %>
					</th>
					<th>
					<%= cuenta.getTipoCuenta() %>
					</th>
					<th>
					<%= cuenta.getFechaCreacion() %>
					</th>
					<th>
					<%= cuenta.getCBUCuenta() %>
					</th>
					<th>
					<%= cuenta.getSaldoCuenta() %>
					</th>
					<th>
					<%= cuenta.getCuentaActiva() %>
					</th>
				</tr>
					
				  <% 
	                    }
		            } else {
	                    out.println("La lista de cuentas es nula o vacía.");
	                }
	            %>
			</tbody>
		</table>
	</form>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>