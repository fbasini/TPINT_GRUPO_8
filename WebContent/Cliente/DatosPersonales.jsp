<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Datos Personales</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../Style.css">
</head>
<body >

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
                        <button type="submit" class="btn-cerrar-sesion">Cerrar Sesiï¿½n</button>
                    </form>
                </li>
            </ul>
        </div>
    </nav>

    <div>
        <h1 style="text-align: center;">Datos Personales</h1>
        <h3 style="text-align: center;">Ingrese sus datos personales:</h3>
        <form action="DatosPersonalesServlet" method="post">
            <table style="margin: 0 auto;">
                <tr>
                    <td style="text-align: left;"><label for="dni">DNI:</label></td>
                    <td><input type="number" id="dni" name="dni"></td>
                </tr>
                <tr>
                    <td style="text-align: left;"><label for="cuil">CUIL:</label></td>
                    <td><input type="text" id="cuil" name="cuil"></td>
                </tr>
                <tr>
                    <td style="text-align: left;"><label for="nombre">Nombre:</label></td>
                    <td><input type="text" id="nombre" name="nombre"></td>
                </tr>
                <tr>
                    <td style="text-align: left;"><label for="apellido">Apellido:</label></td>
                    <td><input type="text" id="apellido" name="apellido"></td>
                </tr>
                <tr>
                    <td style="text-align: left;"><label for="sexo">Sexo:</label></td>
                    <td>
                        <select id="sexo" name="sexo">
                            <option value="Masculino">Masculino</option>
                            <option value="Femenino">Femenino</option>
                            <option value="Otro">Otro</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td style="text-align: left;"><label for="nacionalidad">Nacionalidad:</label></td>
                    <td>
                        <select id="nacionalidad" name="nacionalidad">
                            <option value="Argentina">Argentina</option>
                            <option value="Brasil">Brasil</option>
                            <option value="Chile">Chile</option>
                            <option value="Uruguay">Uruguay</option>
                           
                        </select>
                    </td>
                </tr>
                <tr>
                    <td style="text-align: left;"><label for="fechaNacimiento">Fecha Nacimiento:</label></td>
                    <td><input type="date" id="fechaNacimiento" name="fechaNacimiento"></input></td>
                </tr>
                <tr>
                    <td style="text-align: left;"><label for="direccion">Dirección:</label></td>
                    <td><input type="text" id="direccion" name="direccion"></td>
                </tr>
                <tr>
                    <td style="text-align: left;"><label for="localidad">Localidad:</label></td>
                    <td><input type="text" id="localidad" name="localidad"></td>
                </tr>
                <tr>
                    <td style="text-align: left;"><label for="provincia">Provincia:</label></td>
                    <td>
                        <select id="provincia" name="provincia">
                            <option value="Buenos Aires">Buenos Aires</option>
                            <option value="Córdoba">Córdoba</option>
                            <option value="Santa Fe">Santa Fe</option>
                           
                        </select>
                    </td>
                </tr>
                <tr>
                    <td style="text-align: left;"><label for="email">Email:</label></td>
                    <td><input type="email" id="email" name="email"></td>
                </tr>
                <tr>
                    <td style="text-align: left;"><label for="telefono">Teléfono:</label></td>
                    <td><input type="tel" id="telefono" name="telefono"></td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center; padding-top: 15px;">
                        <button type="submit">Enviar</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>