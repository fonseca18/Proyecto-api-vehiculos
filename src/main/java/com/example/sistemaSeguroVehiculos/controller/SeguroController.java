package com.example.sistemaSeguroVehiculos.controller;

import com.example.sistemaSeguroVehiculos.entity.Conductor;
import com.example.sistemaSeguroVehiculos.entity.Seguro;
import com.example.sistemaSeguroVehiculos.entity.Vehiculo;
import com.example.sistemaSeguroVehiculos.repository.ConductorRepository;
import com.example.sistemaSeguroVehiculos.repository.SeguroRepository;
import com.example.sistemaSeguroVehiculos.service.SeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seguros")
public class SeguroController {

    @Autowired
    private SeguroService seguroService;

    @GetMapping("/list")
    public ResponseEntity<List<Seguro>> listSeguro() {
        List<Seguro> seguros = seguroService.listSeguro();
        return ResponseEntity.ok(seguros);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerSeguro(@RequestBody Seguro seguro){
        Seguro newSeguro = seguroService.registerSeguro(seguro);
        return ResponseEntity.status(HttpStatus.CREATED).body(newSeguro);
    }

    @PutMapping("/update/{idSeguro}")
    public ResponseEntity<?> updateSeguro(@PathVariable Long idSeguro, @RequestBody Seguro seguro) {
        try {
            Seguro updateSeguro = new Seguro();
            updateSeguro.setIdSeguro(seguro.getIdSeguro());
            updateSeguro.setVehiculo(seguro.getVehiculo());
            updateSeguro.setCompania(seguro.getCompania());
            updateSeguro.setNumeroPoliza(seguro.getNumeroPoliza());
            updateSeguro.setFechaInicio(seguro.getFechaInicio());
            updateSeguro.setFechaFinal(seguro.getFechaFinal());

            Seguro seguroDB = seguroService.updateSeguro(idSeguro, updateSeguro);
            return ResponseEntity.ok(seguroDB);

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

    @DeleteMapping("/delete/{idSeguro}")
    public ResponseEntity<?> deleteSeguro(@PathVariable Long idSeguro) {
        try {
            seguroService.deleteSeguro(idSeguro);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

    @GetMapping("/vehiculo/{idVehiculo}")
    public List<Seguro> getByVehiculo(@PathVariable Long idVehiculo) {
        return seguroService.findByVehiculoIdVehiculo(idVehiculo);
    }
}