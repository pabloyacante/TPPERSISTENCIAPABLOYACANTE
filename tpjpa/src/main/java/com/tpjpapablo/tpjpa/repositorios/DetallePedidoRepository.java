package com.tpjpapablo.tpjpa.repositorios;

import com.tpjpapablo.tpjpa.entidades.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePedidoRepository extends JpaRepository  <DetallePedido, Long> {
}
