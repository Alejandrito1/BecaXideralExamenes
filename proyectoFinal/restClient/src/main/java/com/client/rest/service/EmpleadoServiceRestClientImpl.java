package com.client.rest.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.client.rest.model.Empleado;

@Service
public class EmpleadoServiceRestClientImpl implements EmpleadoService {

	private RestTemplate restTemplate;

	private String crmRestUrl;
		
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	public EmpleadoServiceRestClientImpl(RestTemplate theRestTemplate, 
										@Value("${crm.rest.url}") String theUrl) {
		
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
				
		logger.info("Loaded property:  crm.rest.url=" + crmRestUrl);
	}
	
	@Override
	public List<Empleado> getEmpleado() {
		
		logger.info("***OBTENER LISTA DE CLIENTES DESDE EL SERVICE REST CLIENTE");
		logger.info("in getEmpleado(): Calling REST API " + crmRestUrl);

		// make REST call
		ResponseEntity<List<Empleado>> responseEntity = 
											restTemplate.exchange(crmRestUrl, HttpMethod.GET, null, 
													 new ParameterizedTypeReference<List<Empleado>>() {});

		// get the list of customers from response
		List<Empleado> empleado = responseEntity.getBody();

		logger.info("in getEmpleado(): empleados" + empleado);
		
		return empleado;
	}

	@Override
	public Empleado getEmpleado(int theId) {
		logger.info("***OBTENER UN CLIENTE DESDE EL SERVICE REST CLIENTE");

		logger.info("in getEmpleado(): Calling REST API " + crmRestUrl);

		// make REST call
		Empleado elEmpleado = 
				restTemplate.getForObject(crmRestUrl + "/" + theId, 
						Empleado.class);

		logger.info("in saveEmpleado(): elEmpleado=" + elEmpleado);
		
		return elEmpleado;
	}

	@Override
	public void saveEmpleado(Empleado elEmpleado) {

		logger.info("in saveEmpleado(): Calling REST API " + crmRestUrl);
		
		int empleadoId = elEmpleado.getId();

		// make REST call
		if (empleadoId == 0) {
			// add Empleado
			logger.info("***SALVAR UN CLIENTE DESDE EL SERVICE REST CLIENTE");

			restTemplate.postForEntity(crmRestUrl, elEmpleado, String.class);			
		
		} else {
			// update employee
			logger.info("***ACTUALIZAR UN CLIENTE DESDE EL SERVICE REST CLIENTE");

			restTemplate.put(crmRestUrl, elEmpleado);
		}

		logger.info("in saveEmpleado(): success");	
	}

	@Override
	public void deleteEmpleado(int theId) {
		logger.info("***BORRAR UN CLIENTE DESDE EL SERVICE REST CLIENTE");

		logger.info("in deleteEmpleado(): Calling REST API " + crmRestUrl);

		// make REST call
		restTemplate.delete(crmRestUrl + "/" + theId);

		logger.info("in deleteEmpleado(): deleted empleado theId=" + theId);
	}

}
