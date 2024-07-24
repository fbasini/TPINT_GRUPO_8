<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="entidad.Provincias" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BIENVENIDO</title>
</head>
<body>

<form action="../primerIngresoServlet" method="post">
<h5>DNI:</h5> <input name="txtDNI" type="number" required value="" min="1" max="100000000" maxlength="11" oninput="this.value=this.value.replace(/[^0-9]/g,'');">

<h5>CUIL:</h5> <input name="txtCUIL" value="" type="number" required min="1" max="1000000000000" maxlength="11" oninput="this.value=this.value.replace(/[^0-9]/g,'');">

<h5>NOMBRE:</h5> <input name="txtNombre" value="" type="text" required maxlenght="60" onkeypress='return ((event.charCode >= 65 && event.charCode <= 90) || (event.charCode >= 97 && event.charCode <= 122) || (event.charCode == 32))'>

<h5>APELLIDO:</h5> <input name="txtApellido" value="" type="text" required maxlenght="60" onkeypress='return ((event.charCode >= 65 && event.charCode <= 90) || (event.charCode >= 97 && event.charCode <= 122) || (event.charCode == 32))'>

<h5>SEXO:</h5> <select name="txtSexo">
			<option value="M">Masculino</option>
			<option value="F">Femenino</option>
			<option value="O">Otro</option>
			</select>

<h5>NACIONALIDAD:</h5> <input name="txtNacionalidad" value="" type="text" required maxlenght="60" onkeypress='return ((event.charCode >= 65 && event.charCode <= 90) || (event.charCode >= 97 && event.charCode <= 122) || (event.charCode == 32))'>

<h5>FECHA DE NACIMIENTO</h5> <input type="date" name="txtFechaNacimiento" required pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))"
		 value="">

<h5>DIRECCION:</h5> <input name="txtDireccion" required value="" type="text" required maxlenght="60">

<h5>LOCALIDAD:</h5> <input name="txtLocalidad" required value="" type="text" required maxlenght="60">

<h5>PROVINCIA:</h5> <select name="ddlProvincia" id="provincia" required>
				<% ArrayList<Provincias> listaProvincias = (ArrayList<Provincias>) request.getSession().getAttribute("listaProvincias");
	                
	   			if (listaProvincias != null) {
	     		for (Provincias provincia : listaProvincias) { %>
	    	 
	    	 <option value= "<%= provincia.getIdProvincias() %>" ><%= provincia.getNombreProvincia() %> </option>
	    	 
	      <%} }%>
	      </select>

<h5>EMAIL:</h5> <input type="email" required name="txtEmail" value="">

<h5>TELEFONO:</h5> <input name="txtTelefono" value="" type="number" required min="1" max="1000000000000" maxlength="11" oninput="this.value=this.value.replace(/[^0-9]/g,'');">
<br>
<button  type="submit" name="btnSolicitar" 
onclick="return confirm('¿Confirma que ingreso sus datos de manera correcta?');">INGRESAR</button>
</form>


</body>
</html>