package com.tpjpapablo.tpjpa.entidades;

import com.tpjpapablo.tpjpa.enumeraciones.TipoProducto;
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
public class Producto extends BaseEntidad{

    private int tiempoestimadococina;

    private String denominacion;

    private double precioVenta;

    private double precioCompra;

    private int stockActual;

    private int stockMinimo;

    private String unidadMedida;

    private String receta;

    private TipoProducto tipoProducto;
}
