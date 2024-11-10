package ppa_flight.ppa_flight.service.Impl;

import ppa_flight.ppa_flight.dto.VueloDTO;
import ppa_flight.ppa_flight.entity.VueloEntity;
import ppa_flight.ppa_flight.mapper.VueloMapper;
import ppa_flight.ppa_flight.repository.VueloRepository;
import ppa_flight.ppa_flight.service.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VueloServiceImpl implements VueloService {

    @Autowired
    private VueloRepository vueloRepository;

    @Autowired
    private VueloMapper vueloMapper; 

    @Override
    public VueloDTO crearVuelo(VueloDTO vueloDTO) {
        VueloEntity vueloEntity = vueloMapper.toEntity(vueloDTO);
        VueloEntity savedEntity = vueloRepository.save(vueloEntity);
        return vueloMapper.toDTO(savedEntity);
    }

    @Override
    public List<VueloDTO> obtenerTodosLosVuelos() {
        return vueloRepository.findAll()
                .stream()
                .map(vueloMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<VueloDTO> buscarVuelos(Long origenId, Long destinoId, LocalDateTime fechaViaje) {
        LocalDateTime inicioDelDia = fechaViaje.with(LocalTime.MIN);
        LocalDateTime finDelDia = fechaViaje.with(LocalTime.MAX);

        List<VueloEntity> vuelosDirectos = vueloRepository.buscarVuelosDirectos(origenId, destinoId);
        List<VueloDTO> resultados = vuelosDirectos.stream().map(vueloMapper::toDTO).collect(Collectors.toList());

        List<VueloEntity> vuelosConOrigen = vueloRepository.buscarVuelosConOrigen(origenId, inicioDelDia, finDelDia);
        for (VueloEntity vuelo : vuelosConOrigen) {
            List<VueloEntity> posiblesEscalas = vueloRepository.buscarVuelosConOrigen(vuelo.getAeropuertoDestino().getId(), vuelo.getFechaLlegada(), finDelDia);
            for (VueloEntity escala : posiblesEscalas) {
                if (escala.getAeropuertoDestino().getId().equals(destinoId)) {
                    VueloDTO vueloConEscala = vueloMapper.toDTO(vuelo);
                    VueloDTO escalaDTO = vueloMapper.toDTO(escala);
                    resultados.add(fusionarVuelos(vueloConEscala, escalaDTO));
                }
            }
        }

        return resultados;
    }

    private VueloDTO fusionarVuelos(VueloDTO vuelo, VueloDTO escala) {
        return VueloDTO.builder()
                .id(null) // Es un vuelo combinado, no un vuelo real único
                .aeropuertoOrigenId(vuelo.getAeropuertoOrigenId())
                .aeropuertoDestinoId(escala.getAeropuertoDestinoId())
                .fechaSalida(vuelo.getFechaSalida())
                .fechaLlegada(escala.getFechaLlegada())
                .duracion(vuelo.getDuracion() + escala.getDuracion())
                .numeroEscalas(1)
                .build();
    }
}
