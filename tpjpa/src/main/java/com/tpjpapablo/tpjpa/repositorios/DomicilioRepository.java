package com.tpjpapablo.tpjpa.repositorios;

import com.tpjpapablo.tpjpa.entidades.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends JpaRepository <Domicilio, Long> {
}
