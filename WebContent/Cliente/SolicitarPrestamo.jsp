<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="entidad.Cuenta" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Solicitar Préstamo</title>
</head>
<body>
<div>
	<select name="misCuentas" id="misCuentas">
        <option value="Cuenta1">Mi cuenta 1</option>
        <option value="Cuenta2">Mi cuenta 2</option>
        <option value="Cuenta3">Mi cuenta 3</option>
    </select>
 </div>
 
<h1 id="usuario" style="position: absolute; top:1px; right:6px">Nombre Usuario</h1>
<h2>Solicitar Préstamo</h2>
<div>
<table style="text-align:center;">
	<thead >
		<tr>
			<td style="width: 74px; ">Importe</td>
		</tr>
	</thead>
	<tbody>
			
			
		<tr style="width: 482px; ">
				
			<td style="width: 162px; "></td>
			<td>Cuotas</td>
			<td style="width: 128px">
				
			<form action="../calcularPrestamoServlet" method=get>
				<input type="number" name="txtImporte">
				<select name="ddlCuotas" id="ddlCuotas">
			    	
			        <option value="3">3 cuotas</option>
			        <option value="6">6 cuotas</option>
			        <option value="12">12 cuotas</option>
			    </select>
			    
			    <button type="submit" name="btnCalcular">Calcular</button>
			    </form>
			</td>
			<td><h1 id="txtInteres" name="mostrarInteres"></h1></td>
			</tr>
			<tr>
			<% if (request.getSession().getAttribute("importeFinal") != null){
				double importeFinal = (double) request.getSession().getAttribute("importeFinal");%>
			<td>Interes: <%= importeFinal %> </td>
			<td>Importe por cuota : <%= request.getSession().getAttribute("montoCuota") %></td> 
			<%} %>
			</tr>
		<tr style="width: 482px; ">
			
			<td>Cuenta a depositar</td>
			<td style="width: 128px"> 
			<form action="../calcularPrestamoServlet" method=post>
			<select name="misCuentas" id="Cuentas">
   			<% ArrayList<Cuenta> cuentasCliente = (ArrayList<Cuenta>) request.getSession().getAttribute("cuentasCliente");
	                
	   			if (cuentasCliente != null) {
	     		for (Cuenta cuenta : cuentasCliente) { %>
	    	 
	    	 <option value= "<%= cuenta.getIdcuenta() %>" >Cuenta:<%= cuenta.getIdcuenta() %> </option>
	    	 
	      <%} }%>
     
    		</select></td>
			<td colspan="3" style=" height:50px;">
			
			<button type="submit" name="btnSolicitar" onclick="return confirm('¿Esta seguro?');"
				style="text-align:center; border-radius: 5px;">Solicitar</button>
			</form>
			</td>
		</tr>
		<tr>
			
			
		</tr>
		
	</tbody>
</table>
</div>
</body>
</html>