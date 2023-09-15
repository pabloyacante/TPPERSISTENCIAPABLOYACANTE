package com.tpjpapablo.tpjpa.entidades;

import com.tpjpapablo.tpjpa.enumeraciones.EstadoPedido;
import com.tpjpapablo.tpjpa.enumeraciones.TipoEnvio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder


public class Pedido extends BaseEntidad {

    @Temporal(TemporalType.DATE)
    private EstadoPedido estado;
    private Date fecha;
    private int total;
    private TipoEnvio tipoEnvio;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "factura-id")
    private Factura factura;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "pedido_id")
    @Builder.Default
    private List<DetallePedido> detallepedidos = new ArrayList<>();
    
    public void agregarDetallePedido(DetallePedido detallePedi) {

        detallepedidos.add(detallePedi);
    }

}





