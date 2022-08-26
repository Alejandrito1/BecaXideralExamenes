package com.javatechie.spring.batch.entity;

import lombok.*;
//import lombok.Data;
//import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alumnos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alumno {

    @Id
    @Column(name = "ID")
    private int id;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "APELLIDO")
    private String apellido;
    @Column(name = "CORREO")
    private String correo;
    @Column(name = "GENERO")
    private String genero;
    @Column(name = "TELEFONO")
    private String telefono;
  
    
    
}
