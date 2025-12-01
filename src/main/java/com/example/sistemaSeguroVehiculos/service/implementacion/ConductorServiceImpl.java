package com.example.sistemaSeguroVehiculos.service.implementacion;

import com.example.sistemaSeguroVehiculos.entity.Conductor;
import com.example.sistemaSeguroVehiculos.repository.ConductorRepository;
import com.example.sistemaSeguroVehiculos.service.ConductorService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ConductorServiceImpl implements ConductorService {

    @Autowired//Inyecta el repositorio de vehiculos
    private ConductorRepository conductorRepository;

    @Override
    public Conductor registerConductor(Conductor conductor) {
        return conductorRepository.save(conductor);
    }

    @Override
    public List<Conductor> listConductor() {
        return conductorRepository.findAll();
    }

    @SneakyThrows
    @Override
    public Conductor updateConductor(Long idConductor, Conductor conductor) {
        Conductor conductorExisting = conductorRepository.findById(idConductor)
                .orElseThrow(() -> new Exception("Product with ID:" + idConductor + " not Found"));

        conductorExisting.setNombre(conductor.getNombre());
        conductorExisting.setLicencia(conductor.getLicencia());
        conductorExisting.setTelefono(conductor.getTelefono());
        conductorExisting.setDireccion(conductor.getDireccion());
        conductorExisting.setActivo(conductor.getActivo());

        return conductorRepository.save(conductorExisting);
    }

    @SneakyThrows
    @Override
    public void deleteConductor(Long idConductor) {
        Conductor conductorExisting = conductorRepository.findByIdConductor(idConductor)
                .orElseThrow(() -> new Exception("Product With ID" + idConductor + ("Not Found")));

        conductorRepository.deleteById(idConductor);
    }
}
