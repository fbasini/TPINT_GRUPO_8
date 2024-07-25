<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="entidad.Cuenta" %>
<%@ page import="entidad.Cliente" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrar Cuentas</title>
<!-- Bootstrap CSS -->
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

<!-- Main Content -->
<div class="container mt-5">
    <h2>Asignación de Cuenta</h2>
    <form action="../AltaCuentaServlet" method="post">
        <table style="width: 353px; text-align:center;">
            <tbody>
                <tr>
                    <th>Cliente</th>
                    <td style="width: 175px;">
                        <select name="usuarios" id="selectUsuarios">
                            <% ArrayList<Cliente> clientes = (ArrayList<Cliente>) request.getSession().getAttribute("allClientes");
                                if (clientes != null) {
                                    for (Cliente cliente : clientes) { %>
                                        <option value="<%= cliente.getIdCliente() %>">Cliente:<%= cliente.getNombreUsuario() %></option>
                            <% } } %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>N° de cuenta</th>
                    <td>
                        <select name="numeroCuentaAsig" id="selectNumeroCuentaAsig">
                            <% ArrayList<Cuenta> cuentasCliente1 = (ArrayList<Cuenta>) request.getSession().getAttribute("cuentasDisp");
                                if (cuentasCliente1 != null) {
                                    for (Cuenta cuenta : cuentasCliente1) { %>
                                        <option value="<%= cuenta.getIdcuenta() %>">Cuenta:<%= cuenta.getIdcuenta() %></option>
                            <% } } %>
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

<!-- Main Content -->
<div class="container mt-5">
    <h2>Administrar Cuentas</h2>
    
        <table id="tablaCuentas" class="table table-bordered">
            <thead>
                <tr>
                    <th>Id Cuenta</th>
                    <th>Id Cliente</th>
                    <th>Tipo Cuenta</th>
                    <th>Fecha Creación</th>
                    <th>CBU Cuenta</th>
                    <th>Saldo Cuenta</th>
                    <th>Modificar</th>
                    <th>Eliminar</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    ArrayList<Cuenta> cuentas = (ArrayList<Cuenta>) request.getSession().getAttribute("allCuentas");
                    if (cuentas != null) {
                        for (Cuenta cuenta : cuentas) { 
                %>
                    <tr>
                  <form action="../ModificarCuentaServlet" method="post">
                        <td><%= cuenta.getIdcuenta() %></td>
                            <td><%= cuenta.getIdcliente() %></td>
                        <td><input type="text" name="tipoCuenta" value="<%= cuenta.getTipoCuenta() %>"></td>
                        <td><%= cuenta.getFechaCreacion() %></td>
                        <td><input type="text" name="cbuCuenta" value="<%= cuenta.getCBUCuenta() %>"></td>
                        <td><input type="text" name="saldoCuenta" value="<%= cuenta.getSaldoCuenta() %>"></td>
                        <td>
                        <input type="hidden" name="idCliente" value="<%= cuenta.getIdcliente() %>">
                        <input type="hidden" name="idCuenta" value="<%= cuenta.getIdcuenta() %>">
                        <input type="hidden" name="fechaCreacion" value="<%= cuenta.getFechaCreacion() %>">
                            <button type="submit" class="btn btn-warning" name="btnModificar" value="<%= cuenta.getIdcuenta() %>">Modificar</button>
                             
                        </td>
                       </form>
                        <td>
                            <form action="../EliminarCuentaServlet" method="post" onsubmit="confirmarEliminacion(event)" class="d-inline">
                                <input type="hidden" name="idCuenta" value="<%= cuenta.getIdcuenta() %>">
                                <button type="submit" class="btn btn-danger">Eliminar</button>
                            </form>
                        </td>
                    </tr>
                <% 
                    }
                } else {
                    out.println("La lista de cuentas es nula o vacía.");
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
<script type="text/javascript">
    $(document).ready(function (){
        $('#tablaCuentas').DataTable();
    });

    function confirmarEliminacion(event) { 
        if (!confirm('¿Estás seguro de que deseas eliminar esta cuenta? ')) {
            event.preventDefault();
        }
    }
</script>  
</body>
</html>