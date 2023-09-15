package com.tpjpapablo.tpjpa.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Rubro extends BaseEntidad{


    private String denominacion;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "rubro_id")
    private List<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto prod){

        productos.add(prod);
    }

    public void mostrarProductos() {
        System.out.println("Los productos en el rubro son: ");
        for (Producto producto : productos) {
            System.out.println("Denominación: " + producto.getDenominacion());
        }
    }
}
