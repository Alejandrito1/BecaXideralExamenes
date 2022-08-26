package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.entity.Empleado;
import com.luv2code.springboot.cruddemo.service.EmpleadoService;

@RestController
@RequestMapping("/api")
public class EmpleadoRestController {

	private EmpleadoService empleadoService;
	
	@Autowired
	public EmpleadoRestController(EmpleadoService elEmpleadoService) {
		empleadoService = elEmpleadoService;
	}
	
	
	@GetMapping("/empleados")
	public List<Empleado> findAll() {
		return empleadoService.findAll();
	}

	// agrega el Mapping para /empleados
	
	@GetMapping("/empleados/{employeeId}")
	public Empleado getEmployee(@PathVariable int employeeId) {
		
		Empleado elEmpleado = empleadoService.findById(employeeId);
		
		if (elEmpleado == null) {
			throw new RuntimeException("id del Empleados no encontrado - " + employeeId);
		}
		
		return elEmpleado;
	}
	
	// add mapping for POST /employees - add new employee
	
	@PostMapping("/empleados")
	public Empleado addEmployee(@RequestBody Empleado theEmployee) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theEmployee.setId(0);
		
		empleadoService.save(theEmployee);
		
		return theEmployee;
	}
	
	// add mapping for PUT /employees - update existing employee
	
	@PutMapping("/empleados")
	public Empleado updateEmployee(@RequestBody Empleado theEmployee) {
		
		empleadoService.save(theEmployee);
		
		return theEmployee;
	}
	
	// add mapping for DELETE /employees/{employeeId} - delete employee
	
	@DeleteMapping("/empleados/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		Empleado tempEmployee = empleadoService.findById(employeeId);
		
		// throw exception if null
		
		if (tempEmployee == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}
		
		empleadoService.deleteById(employeeId);
		
		return "Deleted employee id - " + employeeId;
	}
	
}










