package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Empleado;

@Repository
public class EmpleadoDAOHibernateImpl implements EmpleadoDAO {

	// define field for entitymanager	
	private EntityManager entityManager;
		
	// set up constructor injection
	@Autowired
	public EmpleadoDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@Override
	public List<Empleado> findAll() {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Empleado> theQuery =
				currentSession.createQuery("from Empleado", Empleado.class);
		
		// execute query and get result list
		List<Empleado> empleados = theQuery.getResultList();
		
		// return the results		
		return empleados;
	}


	@Override
	public Empleado findById(int theId) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// get the employee
		Empleado elEmpleado =
				currentSession.get(Empleado.class, theId);
		System.out.println("PAso por empleado DAO");
		// return the employee
		return elEmpleado;
		
	}


	@Override
	public void save(Empleado elEmpleado) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// save employee
		currentSession.saveOrUpdate(elEmpleado);
	}


	@Override
	public void deleteById(int theId) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery(
						"delete from Empleado where id=:employeeId");///Ojito aqui
		theQuery.setParameter("employeeId", theId);
		
		theQuery.executeUpdate();
	}

}







