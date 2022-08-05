package com.examen1.claseAbs;

public class Futbol extends DeporteE{
	
	public Futbol(int i,String n) {
		// TODO Auto-generated constructor stub
		super(i, n);
	}
	
	@Override
	public void descripcionTiempos() {
		// TODO Auto-generated method stub
		System.out.println("Este deporte deberá Jugarse durante 2 periodos"
				+ " de 45 min cada uno, segun la FIFA ");
		
	}
	@Override
	public String toString() {
	       // TODO Auto-generated method stub
	          return super.toString();
		}
	
}