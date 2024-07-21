<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="entidad.Prestamos" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Autorizar préstamos</title>
	<!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../Style.css">
    <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/2.0.8/css/dataTables.dataTables.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script type="text/javascript" charset="utf8" src="//cdn.datatables.net/2.0.8/js/dataTables.min.js"></script>  
	<script type="text/javascript">
	</script>	
	</head>
<body>
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
                <li class="nav-item">
                    <form action="GestionClientes.jsp" method="post" class="form-inline">
                        <button type="submit" class="btn btn-link nav-link boton-links">Volver</button>
                    </form>
                </li>                
                <li class="nav-item">
                    <form action="../CerrarSesionServlet" method="post" class="form-inline">
                        <button type="submit" class="btn-cerrar-sesion">Cerrar Sesión</button>
                    </form>
                </li>
            </ul>
        </div>
    </nav>
    
    <form method="get" action="/TPINT_GRUPO_8_LAB4/AutorizarPrestamoServlet">
    <table  class="table table-bordered">
    	<thead>
    		<tr>
    			<th>Préstamo</th>
    			<th>Cliente</th>
    			<th>Cuenta</th>
    			<th>Fecha</th>
    			<th>Importe a Pagar</th>
    			<th>Plazo en cuotas</th>
    			<th>Monto Por Cuota</th>
    			<th>Autorizar</th>	
    		</tr>
    	</thead>
    	<tbody>
	    	<%
	    		ArrayList<Prestamos> listaPrestamos=(ArrayList<Prestamos>) request.getAttribute("listaPrestamos");
	    		if(listaPrestamos != null){
	    			for(Prestamos prestamo : listaPrestamos){
	    	%>
	    	 
	    	<tr>
	    		<td><%=prestamo.getIdPrestamo() %></td>
	    		<td><%=prestamo.getIdcuenta() %></td>
	    		<td><%=prestamo.getIdcliente() %></td>
	    		<td><%=prestamo.getFechaPrestamo() %></td>
	    		<td><%=prestamo.getImporteAPagar() %></td>
	    		<td><%=prestamo.getPlazoEnCuotas() %></td>
	    		<td><%=prestamo.getMontoPorCuota() %></td>
	    		<td>
	    			<select name="autorizar" id="autorizar">
	    			<option value="Y">Autorizar</option>
	    			<option value="N">No autorizar</option>
	    			</select>
	    		</td>
	    	</tr>
	    	<%		}
	    	}
	   		 %>
    	</tbody>
    
    </table><br><button type="submit" class="btn btn-link nav-link boton-links" name="btnEnviar">Enviar</button>
    </form>
</body>
</html>