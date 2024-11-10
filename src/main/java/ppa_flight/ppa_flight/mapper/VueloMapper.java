package ppa_flight.ppa_flight.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ppa_flight.ppa_flight.dto.VueloDTO;
import ppa_flight.ppa_flight.entity.VueloEntity;

@Mapper(componentModel = "spring")
public interface VueloMapper {
    @Mapping(source = "aeropuertoOrigen.id", target = "aeropuertoOrigenId")
    @Mapping(source = "aeropuertoDestino.id", target = "aeropuertoDestinoId")
    VueloDTO toDTO(VueloEntity vueloEntity);

    // Modificación para usar el Builder de Lombok
    @Mapping(target = "aeropuertoOrigen", expression = "java(AeropuertoEntity.builder().id(vueloDTO.getAeropuertoOrigenId()).build())")
    @Mapping(target = "aeropuertoDestino", expression = "java(AeropuertoEntity.builder().id(vueloDTO.getAeropuertoDestinoId()).build())")
    VueloEntity toEntity(VueloDTO vueloDTO);
}
