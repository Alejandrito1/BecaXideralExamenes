package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.dao.EmpleadoDAO;
import com.luv2code.springboot.cruddemo.entity.Empleado;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	private EmpleadoDAO empleadoDAO;
	
	@Autowired
	public EmpleadoServiceImpl(EmpleadoDAO elEmpleadoDAO) {
		empleadoDAO = elEmpleadoDAO;
	}
	
	@Override
	@Transactional
	public List<Empleado> findAll() {
		return empleadoDAO.findAll();
	}

	@Override
	@Transactional
	public Empleado findById(int theId) {
		return empleadoDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Empleado elEmpleado) {
		empleadoDAO.save(elEmpleado);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		empleadoDAO.deleteById(theId);
	}

}






