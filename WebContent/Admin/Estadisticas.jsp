<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="entidad.Estadistica" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Estadisticas de usuarios</title>
<!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../Style.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css">
    <style>
        /* Estilos espec�ficos para este JSP */
        .form-container {
            background-color: #f0f0f0; 
            border-radius: 8px; 
            padding: 20px; 
            max-width: 600px; 
            margin: 20px auto; 
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        
        .form-container label {
            display: block;
            margin: 10px 0 5px;
            font-weight: bold;
            color: #333;
        }
        
        .form-container select,
        .form-container input {
            width: 100%;
            border-color: #ced4da;
            border-radius: 8px; 
            padding: 8px 12px; 
            font-size: 1rem; 
            margin-bottom: 10px;
        }
        
        .form-container button {
            width: 100%;
            color: #FFF;
            background-color: #007BFF; /* Color de fondo azul */
            border-radius: 12px; /* Borde m�s redondeado */
            padding: 8px; /* Menor espacio interno */
            font-size: 14px; /* Tama�o de fuente m�s peque�o */
            font-weight: 600;
            cursor: pointer;
            text-align: center;
            border: none;
            transition: all .2s linear;
        }

        .form-container button:hover {
            background-color: #0056b3; /* Color de fondo azul m�s oscuro en hover */
            transform: scale(1.05);
        }

        .result-container {
            text-align: center;
            margin: 20px auto;
        }
        
        .result-container h6 {
            font-size: 18px;
            font-weight: bold;
        }
    </style>
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
                <li class="nav-item">
                    <form action="GestionClientes.jsp" method="post" class="form-inline">
                        <button type="submit" class="btn btn-link nav-link boton-links">Volver</button>
                    </form>
                </li>                
                <li class="nav-item">
                    <form action="../CerrarSesionServlet" method="post" class="form-inline">
                        <button type="submit" class="btn-cerrar-sesion">Cerrar Sesi�n</button>
                    </form>
                </li>
            </ul>
        </div>
    </nav>

<div class="form-container">
    <form action="../calcularEstadisticasServlet" method="get">
        <label for="ddlTipo">Seleccione la estadistica de dinero a obtener:</label>
        <select name="ddlTipo">
            <option value="sum">SUMA TOTAL</option>
            <option value="max">MAYOR VALOR</option>
            <option value="min">MENOR VALOR</option>
        </select> 

        <label for="ddlTabla">Seleccione la fuente:</label>
        <select name="ddlTabla">
            <option value="prestamos"> Prestamos a clientes</option>
            <option value="movimientos"> Movimientos de dinero</option>
        </select>

        <label for="txtFechaInicio">Ingrese la fecha incial para recopilar datos:</label>
        <input type="date" name="txtFechaInicio" required pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))">

        <label for="txtFechaFinal">Ingrese la fecha final para recopilar datos:</label>    
        <input type="date" name="txtFechaFinal" required pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))">

        <button type="submit" name="btnMostrarDatos">MOSTRAR</button>
    </form>

    <div class="result-container">
        <% if (request.getAttribute("estadistica") != null) {
            Estadistica estadistica = (Estadistica) request.getAttribute("estadistica"); %>
            <h6>El resultado es: <%= estadistica.getMontoResultado() %> perteneciente al cliente con ID: <%= estadistica.getIdResultado() %></h6>
        <% } %>
    </div>

    <form action="../calcularEstadisticasServlet" method="get">
        <label for="ddlConteo">Cantidad de usuarios de sexo:</label>
        <select name="ddlConteo">
            <option value="M">MASCULINO</option>
            <option value="F">FEMENINO</option>
            <option value="O">NO BINARIO</option>
        </select> 

        <button type="submit" name="btnMostrarConteo">MOSTRAR</button>
    </form>

    <div class="result-container">

