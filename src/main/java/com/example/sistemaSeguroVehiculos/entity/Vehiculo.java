package com.example.sistemaSeguroVehiculos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVehiculo")
    private Long idVehiculo;

    @Column(name = "placa", nullable = false, length = 100)
    private String vehiculoPlaca;

    @Column(name = "marca", nullable = false)
    private String vehiculoMarca;

    @Column(name = "modelo", nullable = false)
    private String vehiculoModelo;

    @Column(name = "año", nullable = false)
    private Integer vehiculoAño;

    @Column(name = "color", nullable = false)
    private String vehiculoColor;

    @OneToOne
    @JoinColumn(name = "idConductor", referencedColumnName = "idConductor")
    @JsonIgnore
    private Conductor conductor;

    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL)
    private List<Seguro> seguros;
}