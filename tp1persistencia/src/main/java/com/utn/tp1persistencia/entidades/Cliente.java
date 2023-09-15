package com.utn.tp1persistencia.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente extends BaseEntidad{

    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente-id")
    @Builder.Default
    private List<Domicilio> domicilios = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente-id")
    @Builder.Default
    private List<Pedido> pedidos = new ArrayList<>();

    public void agregarDomicilio(Domicilio domi){

        domicilios.add(domi);
    }

    public void agregarPedido(Pedido ped){

        pedidos.add(ped);
    }


    public void mostrarDomicilios() {
        System.out.println("Domicilios de " + nombre + " " + apellido + ":");
        for (Domicilio domicilio : domicilios) {
            System.out.println("Calle: " + domicilio.getCalle() + ", Número: " + domicilio.getNumero());
            System.out.println("------------------------------------------");
        }
    }

    public void mostrarPedidos() {
        System.out.println("Pedidos de" + nombre + " " + apellido +":");
        for (Pedido pedido : pedidos) {
            System.out.println("Fecha: " + pedido.getFecha() + ", Total: " + pedido.getTotal());
            System.out.println("------------------------------------------");
        }
    }
}

