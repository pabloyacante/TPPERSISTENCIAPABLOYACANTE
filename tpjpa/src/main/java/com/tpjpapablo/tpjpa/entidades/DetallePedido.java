package com.tpjpapablo.tpjpa.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetallePedido extends BaseEntidad {

    private int cantidad;
    private double subtotal;

    @ManyToOne()
    @JoinColumn(name = "producto-id")
    private Producto producto;

}
