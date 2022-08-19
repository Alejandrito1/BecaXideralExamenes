package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.dao.EmpleadoDAO;
import com.luv2code.springboot.cruddemo.dao.EmpleadoDAOJdbcImpl;
import com.luv2code.springboot.cruddemo.entity.Empleado;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
	
	private EmpleadoDAO employeeDAO;
	
	@Autowired
    public EmpleadoServiceImpl(@Qualifier("empleadoDAOJdbcImpl") EmpleadoDAO theEmployeeDAO) {
		employeeDAO = theEmployeeDAO;
	}
	
	@Override
	@Transactional
	public List<Empleado> findAll() {
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Empleado findById(int theId) {
		return employeeDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Empleado theEmployee) {
		employeeDAO.save(theEmployee);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		employeeDAO.deleteById(theId);
	}

}






