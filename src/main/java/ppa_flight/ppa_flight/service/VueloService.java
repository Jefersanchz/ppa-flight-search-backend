package ppa_flight.ppa_flight.service;

import ppa_flight.ppa_flight.dto.VueloDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface VueloService {
    VueloDTO crearVuelo(VueloDTO vueloDTO);
    List<VueloDTO> obtenerTodosLosVuelos();
    List<VueloDTO> buscarVuelos(Long origenId, Long destinoId, LocalDateTime fechaViaje);
}
