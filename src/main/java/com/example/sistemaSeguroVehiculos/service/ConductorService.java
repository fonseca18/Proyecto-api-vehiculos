package com.example.sistemaSeguroVehiculos.service;

import com.example.sistemaSeguroVehiculos.entity.Conductor;
import com.example.sistemaSeguroVehiculos.entity.Seguro;

import java.util.List;

public interface ConductorService {

    Conductor registerConductor(Conductor conductor);

    List<Conductor> listConductor();

    Conductor updateConductor(Long idConductor, Conductor conductor);

    void deleteConductor(Long idConductor);

}
