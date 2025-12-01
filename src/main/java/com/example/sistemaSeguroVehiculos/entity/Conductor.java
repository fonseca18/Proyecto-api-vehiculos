package com.example.sistemaSeguroVehiculos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Conductor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idConductor")
    private Long idConductor;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "licencia", nullable = false, length = 100)
    private String licencia;

    @Column(name = "telefono", nullable = false)
    private Long telefono;

    @Column(name = "direccion", nullable = false, length = 100)
    private String direccion;

    @Column(name = "activo", nullable = false)
    private Boolean activo;
}
