package com.javatechie.spring.batch.repository;

import com.javatechie.spring.batch.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository  extends JpaRepository<Alumno,Integer> {
}
