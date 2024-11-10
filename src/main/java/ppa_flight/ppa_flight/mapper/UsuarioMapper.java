package ppa_flight.ppa_flight.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ppa_flight.ppa_flight.dto.UsuarioDTO;
import ppa_flight.ppa_flight.dto.UsuarioRegistroDTO;
import ppa_flight.ppa_flight.entity.UsuarioEntity;

@Mapper
public interface UsuarioMapper {
    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    UsuarioDTO toDTO(UsuarioEntity usuarioEntity);
    UsuarioEntity toEntity(UsuarioRegistroDTO usuarioRegistroDTO);
}
