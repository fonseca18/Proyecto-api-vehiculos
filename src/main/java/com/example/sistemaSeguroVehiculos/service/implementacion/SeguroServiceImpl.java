package com.example.sistemaSeguroVehiculos.service.implementacion;

import com.example.sistemaSeguroVehiculos.entity.Seguro;
import com.example.sistemaSeguroVehiculos.entity.Vehiculo;
import com.example.sistemaSeguroVehiculos.repository.SeguroRepository;
import com.example.sistemaSeguroVehiculos.repository.VehiculoRepository;
import com.example.sistemaSeguroVehiculos.service.SeguroService;
import com.example.sistemaSeguroVehiculos.service.VehiculoService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeguroServiceImpl implements SeguroService {

    @Autowired
    private SeguroRepository seguroRepository;

    @Override
    public Seguro registerSeguro(Seguro seguro) {
        return seguroRepository.save(seguro);
    }

    @Override
    public List<Seguro> listSeguro() {
        return seguroRepository.findAll();
    }

    @SneakyThrows
    @Override
    public Seguro updateSeguro(Long idSeguro, Seguro seguro) {
        Seguro seguroExisting = seguroRepository.findById(idSeguro)
                .orElseThrow(() -> new Exception("Product with ID:" + idSeguro + " not Found"));

        seguroExisting.setVehiculo(seguro.getVehiculo());
        seguroExisting.setCompania(seguro.getCompania());
        seguroExisting.setNumeroPoliza(seguro.getNumeroPoliza());
        seguroExisting.setFechaInicio(seguro.getFechaInicio());
        seguroExisting.setFechaFinal(seguro.getFechaFinal());

        return seguroRepository.save(seguroExisting);
    }

    @SneakyThrows
    @Override
    public void deleteSeguro(Long idSeguro) {
        Seguro seguroExisting = seguroRepository.findByIdSeguro(idSeguro)
                .orElseThrow(() -> new Exception("Product With ID" + idSeguro + ("Not Found")));

        seguroRepository.deleteById(idSeguro);
    }

    @Override
    public List<Seguro> findByVehiculoIdVehiculo(Long idVehiculo) {
        return List.of();
    }
}