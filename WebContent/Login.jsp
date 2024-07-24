<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../Style.css">
</head>
<body style="display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0;">
    <div>
        <form action="/TPINT_GRUPO_8_LAB4/LoginServlet" method="post">
       
            <table style="margin: 0 auto;">
                <tr>
                    <td style="text-align: left;"><label for="usuario">Usuario:</label></td>
                    <td><input type="text" id="usuario" name="usuario"></td>
                </tr>
                <tr>
                    <td style="text-align: left;"><label for="contraseña">Contraseña:</label></td>
                    <td><input type="password" id="contraseña" name="contraseña"></td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center; padding-top: 15px;">
                        <button type="submit" class="btn btn-primary mb-2">Ingresar</button>
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