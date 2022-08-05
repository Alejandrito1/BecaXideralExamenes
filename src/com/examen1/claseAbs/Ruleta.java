package com.examen1.claseAbs;

import java.util.List;
import java.util.Random;

public class Ruleta {

	public static void main(String[] args) {
		DeporteE dep[]= {new Basquetbol(5, "Basquetbol"), new Futbol(11, "Futbol"),
				new Voleibol(6, "Voleibol")};
		
		
       int aleatorio=new Random().nextInt(dep.length);
       System.out.println("El deporte que jugaremos es:  ");
       System.out.println(dep[aleatorio].toString());
       dep[aleatorio].descripcionTiempos();
				
	}
	

}
