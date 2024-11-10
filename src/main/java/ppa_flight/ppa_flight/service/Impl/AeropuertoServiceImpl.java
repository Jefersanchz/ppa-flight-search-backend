package ppa_flight.ppa_flight.service.Impl;

import ppa_flight.ppa_flight.dto.AeropuertoDTO;
import ppa_flight.ppa_flight.entity.AeropuertoEntity;
import ppa_flight.ppa_flight.mapper.AeropuertoMapper;
import ppa_flight.ppa_flight.repository.AeropuertoRepository;
import ppa_flight.ppa_flight.service.AeropuertoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AeropuertoServiceImpl implements AeropuertoService {

    @Autowired
    private AeropuertoRepository aeropuertoRepository;

    private AeropuertoMapper aeropuertoMapper = AeropuertoMapper.INSTANCE;

    @Override
    public AeropuertoDTO crearAeropuerto(AeropuertoDTO aeropuertoDTO) {
        AeropuertoEntity aeropuertoEntity = aeropuertoMapper.toEntity(aeropuertoDTO);
        AeropuertoEntity savedEntity = aeropuertoRepository.save(aeropuertoEntity);
        return aeropuertoMapper.toDTO(savedEntity);
    }

    @Override
    public List<AeropuertoDTO> obtenerTodosLosAeropuertos() {
        return aeropuertoRepository.findAll()
                .stream()
                .map(aeropuertoMapper::toDTO)
                .collect(Collectors.toList());
    }
}
