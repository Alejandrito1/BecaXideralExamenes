package com.examen1.inter;

public class Basquetbol implements DeporteE{
	int numIntegrantes;
	String nombre;
	
	public Basquetbol(int i,String n) {
		numIntegrantes=i;
		nombre=n;
	}
	
	@Override
	 public void descripcionTiempos() {
		System.out.println("Este deporte deberá Jugarse durante 4 periodos"
				+ " de 10 min cada uno, segun la FIBA ");
	}
	@Override
	public String toString() {
		return this.nombre+ " y requiere "
	            +this.numIntegrantes+" Integrantes";
		}
	
}