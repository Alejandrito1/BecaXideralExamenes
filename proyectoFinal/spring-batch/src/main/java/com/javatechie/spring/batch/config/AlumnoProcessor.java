package com.javatechie.spring.batch.config;

import com.javatechie.spring.batch.entity.Alumno;
import org.springframework.batch.item.ItemProcessor;

public class AlumnoProcessor implements ItemProcessor<Alumno,Alumno> {

    @Override
    public Alumno process(Alumno alumno) throws Exception {
        
    	System.out.println(alumno);
            return alumno;
       
    }
}
