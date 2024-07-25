<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="entidad.Movimiento" %>
      <%@ page import="entidad.Cuenta" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Movimientos</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="../Style.css">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css">
</head>
<body>

<!-- Header -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">
        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-bank" viewBox="0 0 16 16">
            <path d="m8 0 6.61 3h.89a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-.5.5H15v7a.5.5 0 0 1-.485.38l.5 2a.498.498 0 0 1-.485.62H.5a.498.498 0 0 1-.485-.62l.5-2A.5.5 0 0 1 1 13V6H.5a.5.5 0 0 1-.5-.5v-2A.5.5 0 0 1 .5 3h.89zM3.777 3h8.447L8 1zM2 6v7h1V6zm2 0v7h2.5V6zm3.5 0v7h1V6zm2 0v7H12V6zM13 6v7h1V6zm2-1V4H1v1zm-.39 9H1.39l-.25 1h13.72z"/>
        </svg>
    </a>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <span class="nav-link">Usuario: <%= session.getAttribute("usuario") %> </span>
            </li>
            <li class="nav-item">
                <form action="GestionCuentas.jsp" method="post" class="form-inline">
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


<div>
       
        <table class="table table-bordered">
            <thead>
                <tr>
                	 <th>idMovimiento</th>
                	  <th>idCuenta</th>
                	   <th>Tipo Movimiento</th>
                    <th>Fecha</th>
                    <th>Detalle</th>
                    <th>Importe</th>
                    <th>Destinatario</th>
                </tr>
                </thead>
                <tbody>
                
                <% 
                    ArrayList<Movimiento> movimientos = (ArrayList<Movimiento>) request.getAttribute("movimientos");
                    if (movimientos != null) {
                        for (Movimiento movimiento : movimientos) {
                %>
                
                <tr>
                	<td>
                	<%= movimiento.getIdMovimiento() %>
                	</td>
                	<td>
                	<%= movimiento.getIdcuenta() %>
                	</td>
                	<td>
                	<%= movimiento.getTipoMovimiento() %>
                	</td>
                	<td>
                	<%= movimiento.getFechaMovimiento() %>
                	</td>
                	<td>
                	<%= movimiento.getDetalleMovimiento() %>
                	</td>
                	<td>
                	<%= movimiento.getImporteMovimiento() %>
                	</td>
                	<td>
                	<%= movimiento.getDestinatario() %>
                	</td>
                </tr>
                  <% 
                        }
                    } 
                %>
            </tbody>
        </table>
    </div>

<!-- Bootstrap JS and dependencies -->
<!-- jQuery, Bootstrap JS and DataTables JS -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>  
</body>
</html>