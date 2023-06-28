package com.IntegradorFinal.persistence.repository;

import com.IntegradorFinal.persistence.entities.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomicilioRepository extends JpaRepository<Domicilio, Integer> {
}
