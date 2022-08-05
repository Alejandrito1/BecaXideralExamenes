package com.examen1.claseAbs;

public abstract class DeporteE {
	int numIntegrantes;
	String nombre;
	
	
	public DeporteE(int nI, String nom) {
		numIntegrantes=nI;
		nombre=nom;
	}
	public abstract void descripcionTiempos();
	
	public String toString() {
		return this.nombre+ " y requiere "
	            +this.numIntegrantes+" Integrantes";
		
	}

}
