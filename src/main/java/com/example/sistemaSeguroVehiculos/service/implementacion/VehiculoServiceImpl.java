package com.example.sistemaSeguroVehiculos.service.implementacion;

import com.example.sistemaSeguroVehiculos.entity.Vehiculo;
import com.example.sistemaSeguroVehiculos.repository.VehiculoRepository;
import com.example.sistemaSeguroVehiculos.service.VehiculoService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service//Indica que esta clase es un servicio de Spring
public class VehiculoServiceImpl implements VehiculoService {

    @Autowired//Inyecta el repositorio de vehiculos
    private VehiculoRepository vehiculoRepository;

    @Override
    public Vehiculo registerVehiculo(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    @Override
    public List<Vehiculo> listVehiculo() {
        return vehiculoRepository.findAll();
    }

    @Override
    public Optional<Vehiculo> searchVehiculoByModelo(String modelo) {
        return vehiculoRepository.findByVehiculoModelo(modelo);
    }

    @Override
    public Optional<Vehiculo> searchVehiculoById(Long idVehiculo) {
        return vehiculoRepository.findByIdVehiculo(idVehiculo);
    }

    @SneakyThrows
    @Override
    public Vehiculo updateVehiculo(Long idVehiculo, Vehiculo vehiculo) {
        Vehiculo vehiculoExisting = vehiculoRepository.findById(idVehiculo)
                .orElseThrow(() -> new Exception("Product with ID:" + idVehiculo + " not Found"));

        vehiculoExisting.setVehiculoPlaca(vehiculo.getVehiculoPlaca());
        vehiculoExisting.setVehiculoMarca(vehiculo.getVehiculoMarca());
        vehiculoExisting.setVehiculoModelo(vehiculo.getVehiculoModelo());
        vehiculoExisting.setVehiculoAño(vehiculo.getVehiculoAño());
        vehiculoExisting.setVehiculoColor(vehiculo.getVehiculoColor());

        return vehiculoRepository.save(vehiculoExisting);
    }

    @SneakyThrows
    @Override
    public void deleteVehiculo(Long idVehiculo) {
        Vehiculo vehiculoExisting = vehiculoRepository.findByIdVehiculo(idVehiculo)
                .orElseThrow(() -> new Exception("Product With ID" + idVehiculo + ("Not Found")));

        vehiculoRepository.deleteById(idVehiculo);
    }

}