package com.example.sistemaSeguroVehiculos.service;

import com.example.sistemaSeguroVehiculos.entity.Seguro;
import java.util.List;

public interface SeguroService {

    Seguro registerSeguro(Seguro seguro);

    List<Seguro> listSeguro();

    Seguro updateSeguro(Long idSeguro, Seguro seguro);

    void deleteSeguro(Long idSeguro);

    List<Seguro> findByVehiculoIdVehiculo(Long idVehiculo);
}
