package ppa_flight.ppa_flight.controller;

import ppa_flight.ppa_flight.dto.AeropuertoDTO;
import ppa_flight.ppa_flight.service.AeropuertoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/aeropuertos")
public class AeropuertoController {

    @Autowired
    private AeropuertoService aeropuertoService;

    @PostMapping("/crear")
    public ResponseEntity<AeropuertoDTO> crearAeropuerto(@RequestBody AeropuertoDTO aeropuertoDTO) {
        AeropuertoDTO nuevoAeropuerto = aeropuertoService.crearAeropuerto(aeropuertoDTO);
        return ResponseEntity.ok(nuevoAeropuerto);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<AeropuertoDTO>> obtenerTodosLosAeropuertos() {
        List<AeropuertoDTO> aeropuertos = aeropuertoService.obtenerTodosLosAeropuertos();
        return ResponseEntity.ok(aeropuertos);
    }
}
