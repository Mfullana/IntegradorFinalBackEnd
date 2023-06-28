package com.IntegradorFinal.persistence.repository;

import com.IntegradorFinal.persistence.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
}
