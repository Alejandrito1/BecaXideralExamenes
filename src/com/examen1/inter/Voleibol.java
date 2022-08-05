package com.examen1.inter;

public class Voleibol implements DeporteE{
	
	int numIntegrantes;
	String nombre;
	
	public Voleibol(int i,String n) {
		numIntegrantes=i;
		nombre=n;
	}
	
	@Override
	public void descripcionTiempos() {
		System.out.println("Gana el equipo que acumule 3 sets ganados, por lo tanto el "
				+ "numero de sets maximos solo pueden ser 5 y el tiempo es indefinido");
	}
	@Override
	public String toString() {
		return this.nombre+ " y requiere "
	            +this.numIntegrantes+" Integrantes";
		}
	
}
