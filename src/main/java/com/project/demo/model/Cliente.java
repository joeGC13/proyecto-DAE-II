package com.project.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cliente {
    private int id;
    private String docIdent;
    private String nombres;
    private String apePat;
    private String apeMat;
    private boolean estado;
}
