package com.examen1.inter;

public class Futbol implements DeporteE{
	int numIntegrantes;
	String nombre;
	
	public Futbol(int i,String n) {
		numIntegrantes=i;
		nombre=n;
	}
	
	@Override
	public void descripcionTiempos() {
		// TODO Auto-generated method stub
		System.out.println("Este deporte deberá Jugarse durante 2 periodos"
				+ " de 45 min cada uno, segun la FIFA ");
		
	}
	@Override
	public String toString() {
		return this.nombre+ " y requiere "
	            +this.numIntegrantes+" Integrantes";
		}
		
	
}