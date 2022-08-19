package com.luv2code.springboot.cruddemo.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Empleado;

@Repository

public class EmpleadoDAOJdbcImpl implements EmpleadoDAO {

	@Autowired
	DataSource dataSource;

	@Override
	public List<Empleado> findAll() {
		System.out.println("Implementación DAO con JDBC: " + dataSource);

		List<Empleado> listaEmpleados = new ArrayList<>();

		try (Connection con = dataSource.getConnection();

				Statement myStmt = con.createStatement();
				ResultSet myRs = myStmt.executeQuery("select *from empleado")) {
			while (myRs.next()) {

				// retrieve data from result set row
				int id = myRs.getInt("id");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");

				// create new student object
				Empleado elEmpleado = new Empleado(id, firstName, lastName, email);

				// add it to the list of students
				listaEmpleados.add(elEmpleado);
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return listaEmpleados;
	}

	@Override
	public Empleado findById(int theId) {
		Empleado elEmpleado = null;
		try (
				// obtener conexión db
				Connection myConn = dataSource.getConnection();
				
				// sql para insertar
				PreparedStatement myStmt = myConn.prepareStatement("select * from empleado where id=?");
			

		) {
			myStmt.setInt(1, theId);
			
			try(ResultSet myRs = myStmt.executeQuery()){
				
				//Recupera los datos
				if (myRs.next()) {
					String first_name = myRs.getString("first_name");
					String last_name = myRs.getString("last_name");
					String email = myRs.getString("email");
					// usar theId durante la construcción
					elEmpleado = new Empleado(theId, first_name, last_name, email);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return elEmpleado;

	}
	@Override
	public void save(Empleado theEmployee) {
		
			
			if (theEmployee.getId()==0) {
			try (
					// obtener conexión db
					Connection myConn = dataSource.getConnection();

					// sql para insertar
					PreparedStatement myStmt = myConn.prepareStatement(
							"insert into empleado " + "(first_name, last_name, email) " + "values (?, ?, ?)");) {

				myStmt.setString(1, theEmployee.getFirstName());
				myStmt.setString(2, theEmployee.getLastName());
				myStmt.setString(3, theEmployee.getEmail());

				// ejecutar insertar sql
				myStmt.execute();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			}else {
				try (
						// obtener conexión db
						Connection myConn = dataSource.getConnection();

						
						PreparedStatement myStmt = myConn.prepareStatement("update empleado set first_name=?, last_name=?, email=? where id=?");) {
				
					myStmt.setString(1, theEmployee.getFirstName());
					myStmt.setString(2, theEmployee.getLastName());
					myStmt.setString(3, theEmployee.getEmail());
					myStmt.setInt(4, theEmployee.getId());


					// ejecutar insertar sql
					myStmt.execute();

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	

	@Override
	public void deleteById(int theId) {

		System.out.println("Entro a deleteById");
		System.out.println(theId);

		try (Connection con = dataSource.getConnection();
				PreparedStatement myStmt = con.prepareStatement("delete from empleado where id=?")) {
			myStmt.setInt(1, theId);
			myStmt.execute();
			System.out.println(myStmt);
			System.out.println("llego hasta aca");

		} catch (Exception e) {
			e.getStackTrace();
		}

	}

}
