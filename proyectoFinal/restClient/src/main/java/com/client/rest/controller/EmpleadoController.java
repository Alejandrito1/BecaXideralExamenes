package com.client.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.client.rest.model.Empleado;
import com.client.rest.service.EmpleadoService;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

	// Aqui se inyecta el EmpleadoService
	@Autowired
	private EmpleadoService empladoService;
	
	@GetMapping("/list")
	public String listEmpleados(Model theModel) {
		
		// get customers from the service
		List<Empleado> elEmpleado = empladoService.getEmpleado();
				
		// add the customers to the model
		theModel.addAttribute("empleado", elEmpleado);//ojito anteriormente customers
		
		return "list-empleados";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Empleado elEmpleado = new Empleado();
		
		theModel.addAttribute("empleado", elEmpleado);//anteriormente customer
		
		return "empleado-form";
	}
	
	@PostMapping("/saveEmpleado")
	public String saveEmpleado(@ModelAttribute("empleado") Empleado elEmpleado) {
		
		// save the customer using our service
		empladoService.saveEmpleado(elEmpleado);	
		
		return "redirect:/empleados/list";//empleados Anteriormente
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("empleadoId") int theId,
									Model theModel) {
		
		// get the customer from our service
		Empleado elEmpleado = empladoService.getEmpleado(theId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("empleado", elEmpleado);
		
		// send over to our form		
		return "empleado-form";
	}
	
	@GetMapping("/delete")
	public String deleteEmpleado(@RequestParam("empleadoId") int theId) {
		
		// delete the empleado
		empladoService.deleteEmpleado(theId);
		
		return "redirect:/empleados/list";
	}
}










