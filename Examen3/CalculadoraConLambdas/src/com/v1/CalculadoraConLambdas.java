package com.v1;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class CalculadoraConLambdas {

	public static void main(String[] args) {
		//Definimos los valores, para no pasarlo en el metodo de cada lambda
        int a=3;
        int b=2;
        //El polimorfismo lo vemos en el uso del mismo metodo de cada clase, pero que este tiene 
        //diferente comportamiento
        
        System.out.println("La suma de "+a+" y "+b);
		BinaryOperator<Integer> bo1= (x,y)->x+y;
		System.out.println(bo1.apply(a, b));
		
		System.out.println("La Resta de "+a+" y "+b);
		BinaryOperator<Integer> bo2= (x,y)->x-y;
		System.out.println(bo2.apply(a, b));
		
		System.out.println("La Multiplicacion de "+a+" y "+b);
		BinaryOperator<Integer> bo3= (x,y)->x*y;
		System.out.println(bo3.apply(a, b));
		
		System.out.println("La Division de "+a+" y "+b);
		BinaryOperator<Integer> bo4= (x,y)->x/y;
		System.out.println(bo4.apply(a, b));
		
		System.out.println("La base"+a+" elevada a la potencia"+b);
		BiFunction<Integer,Integer,Double> bo5= (x,y)->Math.pow(x,y);
		System.out.println(bo5.apply(a, b));
		
		

	}

}
