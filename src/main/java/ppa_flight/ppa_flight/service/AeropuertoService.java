package ppa_flight.ppa_flight.service;

import ppa_flight.ppa_flight.dto.AeropuertoDTO;

import java.util.List;

public interface AeropuertoService {
    AeropuertoDTO crearAeropuerto(AeropuertoDTO aeropuertoDTO);
    List<AeropuertoDTO> obtenerTodosLosAeropuertos();
}
