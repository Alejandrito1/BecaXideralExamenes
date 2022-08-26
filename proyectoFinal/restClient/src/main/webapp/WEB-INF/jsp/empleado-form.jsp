<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Guardar Empleado</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/agrega_Empleado-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>Nuevo empleado</h2>
		</div>
	</div>

	<div id="container">
		<h3>Guardar Empleado</h3>
	
		<form:form action="saveEmpleado" modelAttribute="empleado" method="POST">

			<!-- need to associate this data with Empleado id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Nombre:</label></td>
						<td><form:input path="firstName" /></td>
					</tr>
				
					<tr>
						<td><label>Apellido:</label></td>
						<td><form:input path="lastName" /></td>
					</tr>

					<tr>
						<td><label>Correo Electrónico:</label></td>
						<td><form:input path="email" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/empleados/list">Back to List</a>
		</p>
	
	</div>

</body>

</html>










