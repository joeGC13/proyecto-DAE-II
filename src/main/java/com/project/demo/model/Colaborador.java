package pe.isil.isilweb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Colaborador {

    private String cola_id;
    private String tdoi_id;
    private String cola_num_doc;
    private String cola_nombres;
    private String cola_apellido_paterno;
    private String cola_apellido_materno;
    private String cola_fecha_nacimiento;
    private String cola_domicilio;
    private String cola_telefono;
    private String cola_email;
    private String cola_estado;
}
