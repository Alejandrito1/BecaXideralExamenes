package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Empleado;

public interface EmpleadoDAO {

	public List<Empleado> findAll();
	
	public Empleado findById(int theId);
	
	public void save(Empleado elEmpleado);
	
	public void deleteById(int theId);
	
}
