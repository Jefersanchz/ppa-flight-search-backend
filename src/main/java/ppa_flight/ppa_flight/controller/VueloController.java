package ppa_flight.ppa_flight.controller;

import ppa_flight.ppa_flight.dto.VueloDTO;
import ppa_flight.ppa_flight.service.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/vuelos")
public class VueloController {

    @Autowired
    private VueloService vueloService;

    @PostMapping("/crear")
    public ResponseEntity<VueloDTO> crearVuelo(@RequestBody VueloDTO vueloDTO) {
        VueloDTO nuevoVuelo = vueloService.crearVuelo(vueloDTO);
        return ResponseEntity.ok(nuevoVuelo);
    }
@GetMapping("/buscar")
public ResponseEntity<List<VueloDTO>> buscarVuelos(
        @RequestParam Long origenId,
        @RequestParam Long destinoId,
        @RequestParam String fechaViaje) {
    try {
        // Intenta parsear la fecha de la solicitud
        LocalDate fecha = LocalDate.parse(fechaViaje);
        List<VueloDTO> vuelos = vueloService.buscarVuelos(origenId, destinoId, fecha.atStartOfDay());
        return ResponseEntity.ok(vuelos);
    } catch (DateTimeParseException e) {
        // Maneja el error de formato de fecha y devuelve una respuesta adecuada
        System.err.println("Error al parsear la fecha: " + e.getMessage());
        return ResponseEntity.badRequest().body(null);
    }
}



    @GetMapping("/todos")
    public ResponseEntity<List<VueloDTO>> obtenerTodosLosVuelos() {
        List<VueloDTO> vuelos = vueloService.obtenerTodosLosVuelos();
        return ResponseEntity.ok(vuelos);
    }
}
