package com.tpjpapablo.tpjpa.repositorios;

import com.tpjpapablo.tpjpa.entidades.Rubro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubroRepository extends JpaRepository<Rubro, Long> {
}
