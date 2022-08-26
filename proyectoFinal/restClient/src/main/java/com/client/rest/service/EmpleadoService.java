package com.client.rest.service;

import java.util.List;
import com.client.rest.model.Empleado;

public interface EmpleadoService {

	public List<Empleado> getEmpleado();

	public void saveEmpleado(Empleado elEmpleado);

	public Empleado getEmpleado(int theId);

	public void deleteEmpleado(int theId);
	
}
