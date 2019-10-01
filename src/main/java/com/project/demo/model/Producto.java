package com.project.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Producto {
    private int id;
    private String codigo;
    private String nombre;
    private String categoria;
    private double precio;
    private boolean estado;

}
