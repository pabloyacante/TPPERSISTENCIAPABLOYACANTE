package com.utn.tp1persistencia.entidades;

import com.utn.tp1persistencia.enumeraciones.FormaDePago;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Factura extends BaseEntidad{

    private int numero;
    private Date fecha;
    private double descuento;
    private int total;
    private FormaDePago formaDePago;
}
