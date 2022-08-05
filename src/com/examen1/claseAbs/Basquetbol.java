package com.examen1.claseAbs;

public class Basquetbol extends DeporteE{
	
	public Basquetbol(int i,String n) {
		// TODO Auto-generated constructor stub
		super(i, n);
	}
	
	@Override
	 public void descripcionTiempos() {
		System.out.println("Este deporte deberá Jugarse durante 4 periodos"
				+ " de 10 min cada uno, segun la FIBA ");
	}
	@Override
	public String toString() {
	       // TODO Auto-generated method stub
	          return super.toString();
		}
	
}