<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="entidad.Cuenta" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Solicitar Préstamo</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../Style.css">
</head>
<body>
 <!-- Header -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-bank" viewBox="0 0 16 16">
                <path d="m8 0 6.61 3h.89a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-.5.5H15v7a.5.5 0 0 1 .485.38l.5 2a.498.498 0 0 1-.485.62H.5a.498.498 0 0 1-.485-.62l.5-2A.5.5 0 0 1 1 13V6H.5a.5.5 0 0 1-.5-.5v-2A.5.5 0 0 1 .5 3h.89zM3.777 3h8.447L8 1zM2 6v7h1V6zm2 0v7h2.5V6zm3.5 0v7h1V6zm2 0v7H12V6zM13 6v7h1V6zm2-1V4H1v1zm-.39 9H1.39l-.25 1h13.72z"/>
            </svg>
        </a>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <span class="nav-link">Usuario: <%= session.getAttribute("usuario") %> </span>
                </li>
                <!-- 
                <li class="nav-item">
                    <form action="volver" method="post" class="form-inline">
                        <button type="submit" class="btn btn-link nav-link boton-links">Volver</button>
                    </form>
                </li>
                -->
                <li class="nav-item">
                    <form action="../CerrarSesionServlet" method="post" class="form-inline">
                        <button type="submit" class="btn-cerrar-sesion">Cerrar Sesion</button>
                    </form>
                </li>
            </ul>
        </div>
    </nav>

<div>
	<select name="misCuentas" id="misCuentas">
        <option value="Cuenta1">Mi cuenta 1</option>
        <option value="Cuenta2">Mi cuenta 2</option>
        <option value="Cuenta3">Mi cuenta 3</option>
    </select>
 </div>


<div>
<table style="text-align:center;">
	<thead >
		<tr>
			<td ></td>
			
			<td >
			
		</td>
		
		<td style="width: 74px; ">
		Importe
		</td>
		
		</tr>
		
		
	</thead>
	<tbody>
			
			
		<tr style="width: 482px; ">
				
			<td style="width: 162px; "></td>
			
			<td>Cuotas</td>
			<td style="width: 128px">
				
			<form action="../calcularPrestamoServlet" method=get>
				<input type="number" required value="5000.0" min="5000.0" max="100000000" name="txtImporte" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*?)\..*/g, '$1').replace(/^0[^.]/, '0');">
				<select name="ddlCuotas" id="ddlCuotas">
			    	
			        <option value="3">3 cuotas</option>
			        <option value="6">6 cuotas</option>
			        <option value="12">12 cuotas</option>
			    </select>
			    
			    <button type="submit" class="btn btn-primary mb-2" name="btnCalcular">Calcular</button>
			    </form>
			</td>
			
			</tr>
			<tr>
			<% if (request.getSession().getAttribute("importeFinal") != null){
				double importeFinal = (double) request.getSession().getAttribute("importeFinal");%>
			<td>Interes: <%= importeFinal %> </td>
			<td>Importe por cuota : <%= request.getSession().getAttribute("montoCuota") %></td> 
			
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
			
			<button type="submit"  class="btn btn-primary mb-2" name="btnSolicitar" onclick="return confirm('¿Esta seguro?');"
				style="text-align:center; border-radius: 5px;">Solicitar</button>
			</form>
			</td>
			<%} %>
		</tr>
		<tr>
			
			
		</tr>
		
	</tbody>
</table>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>