package com.tpjpapablo.tpjpa.entidades;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Domicilio extends BaseEntidad {

    private String calle;
    private String localidad;
    private int numero;

}
