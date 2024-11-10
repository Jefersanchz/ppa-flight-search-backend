package ppa_flight.ppa_flight.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ppa_flight.ppa_flight.dto.AeropuertoDTO;
import ppa_flight.ppa_flight.entity.AeropuertoEntity;

@Mapper
public interface AeropuertoMapper {
    AeropuertoMapper INSTANCE = Mappers.getMapper(AeropuertoMapper.class);

    AeropuertoDTO toDTO(AeropuertoEntity aeropuertoEntity);
    AeropuertoEntity toEntity(AeropuertoDTO aeropuertoDTO);
}
