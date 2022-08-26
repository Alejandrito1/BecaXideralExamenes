<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Lista  Empleados</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Empleados</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
		
			<input type="button" value="Agrega Empleado"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Correo Electrónico</th>
					<th>Acción</th>
				</tr>
				
				<!-- Imprime los Empleados a traves de un ciclo -->
				<c:forEach var="tempEmpleado" items="${empleado}">
				
					<!-- construct an "update" el Empleado por id-->
					<c:url var="updateLink" value="/empleados/showFormForUpdate">
						<c:param name="empleadoId" value="${tempEmpleado.id}" />
					</c:url>					

					<!-- construye el link borrar por id -->
					<c:url var="deleteLink" value="/empleados/delete">
						<c:param name="empleadoId" value="${tempEmpleado.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempEmpleado.firstName} </td>
						<td> ${tempEmpleado.lastName} </td>
						<td> ${tempEmpleado.email} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Actualizar</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('¿Estas seguro de eliminar este empleado?'))) return false">Borrar</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









