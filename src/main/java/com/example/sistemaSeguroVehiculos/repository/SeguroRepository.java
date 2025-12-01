package com.example.sistemaSeguroVehiculos.repository;

import com.example.sistemaSeguroVehiculos.entity.Seguro;
import com.example.sistemaSeguroVehiculos.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SeguroRepository extends JpaRepository<Seguro, Long> {

    Optional<Seguro> findByIdSeguro(Long idSeguro);

}
