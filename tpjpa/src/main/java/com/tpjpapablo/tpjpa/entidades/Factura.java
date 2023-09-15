package com.tpjpapablo.tpjpa.entidades;

import com.tpjpapablo.tpjpa.enumeraciones.FormaDePago;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Factura extends BaseEntidad {

    private int numero;
    private Date fecha;
    private double descuento;
    private int total;
    private FormaDePago formaDePago;
}
