package com.example.sistemaSeguroVehiculos.controller;

import com.example.sistemaSeguroVehiculos.entity.Conductor;
import com.example.sistemaSeguroVehiculos.entity.Seguro;
import com.example.sistemaSeguroVehiculos.service.ConductorService;
import com.example.sistemaSeguroVehiculos.service.SeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conductores")
public class ConductorController {

    @Autowired
    private ConductorService conductorService;

    @GetMapping("/list")
    public ResponseEntity<List<Conductor>> listConductor() {
        List<Conductor> conductores = conductorService.listConductor();
        return ResponseEntity.ok(conductores);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerConductor(@RequestBody Conductor conductor){
        Conductor newConductor = conductorService.registerConductor(conductor);
        return ResponseEntity.status(HttpStatus.CREATED).body(newConductor);
    }

    @PutMapping("/update/{idConductor}")
    public ResponseEntity<?> updateConductor(@PathVariable Long idConductor, @RequestBody Conductor conductor) {
        try {
            Conductor updateConductor = new Conductor();
            updateConductor.setIdConductor(conductor.getIdConductor());
            updateConductor.setNombre(conductor.getNombre());
            updateConductor.setLicencia(conductor.getLicencia());
            updateConductor.setTelefono(conductor.getTelefono());
            updateConductor.setDireccion(conductor.getDireccion());
            updateConductor.setActivo(conductor.getActivo());

            Conductor conductorDB = conductorService.updateConductor(idConductor, updateConductor);
            return ResponseEntity.ok(conductorDB);

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

    @DeleteMapping("/delete/{idConductor}")
    public ResponseEntity<?> deleteConductor(@PathVariable Long idConductor) {
        try {
            conductorService.deleteConductor(idConductor);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }
}
