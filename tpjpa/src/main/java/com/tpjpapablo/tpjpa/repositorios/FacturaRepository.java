package com.tpjpapablo.tpjpa.repositorios;

import com.tpjpapablo.tpjpa.entidades.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository <Factura, Long> {
}
