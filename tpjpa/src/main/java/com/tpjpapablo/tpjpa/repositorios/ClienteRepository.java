package com.tpjpapablo.tpjpa.repositorios;

import com.tpjpapablo.tpjpa.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Long> {
}
