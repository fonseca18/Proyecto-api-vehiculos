package com.example.sistemaSeguroVehiculos.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seguro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSeguro;

    @ManyToOne
    @JoinColumn(name = "idVehiculo", referencedColumnName = "idVehiculo")
    @JsonIgnoreProperties({"conductor"})
    private Vehiculo vehiculo;

    @Column(name = "compania", nullable = false, length = 100)
    private String compania;

    @Column(name = "numeroPoliza", nullable = false, length = 100)
    private String  numeroPoliza;

    @Column(name = "fechaInicio", nullable = false, length = 100)
    private String fechaInicio;

    @Column(name = "fechaFinal", nullable = false, length = 100)
    private String fechaFinal;
}
