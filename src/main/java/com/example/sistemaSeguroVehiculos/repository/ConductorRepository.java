package com.example.sistemaSeguroVehiculos.repository;

import com.example.sistemaSeguroVehiculos.entity.Conductor;
import com.example.sistemaSeguroVehiculos.entity.Seguro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConductorRepository extends JpaRepository<Conductor, Long> {
    Optional<Conductor> findByIdConductor(Long idConductor);
}
