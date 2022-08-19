package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Empleado;

public interface EmpleadoService {

	public List<Empleado> findAll();
	
	public Empleado findById(int theId);
	
	public void save(Empleado theEmployee);
	
	public void deleteById(int theId);
	
}
