package com.examen1.claseAbs;

public class Voleibol extends DeporteE{
	
	public Voleibol(int i,String n) {
		// TODO Auto-generated constructor stub
		super(i, n);
	}
	
	@Override
	public void descripcionTiempos() {
		System.out.println("Gana el equipo que acumule 3 sets ganados, por lo tanto el "
				+ "numero de sets maximos solo pueden ser 5 y el tiempo es indefinido");
	}
	@Override
	public String toString() {
	       // TODO Auto-generated method stub
	          return super.toString();
		}
	
}
