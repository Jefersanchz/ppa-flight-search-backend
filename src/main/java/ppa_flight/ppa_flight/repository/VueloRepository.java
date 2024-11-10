package ppa_flight.ppa_flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ppa_flight.ppa_flight.entity.VueloEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface VueloRepository extends JpaRepository<VueloEntity, Long> {
    @Query("SELECT v FROM VueloEntity v WHERE v.aeropuertoOrigen.id = :origenId AND v.aeropuertoDestino.id = :destinoId")
List<VueloEntity> buscarVuelosDirectos(@Param("origenId") Long origenId, @Param("destinoId") Long destinoId);


    @Query("SELECT v FROM VueloEntity v WHERE v.aeropuertoOrigen.id = :origenId AND v.fechaSalida >= :inicioDelDia AND v.fechaSalida < :finDelDia")
    List<VueloEntity> buscarVuelosConOrigen(@Param("origenId") Long origenId, @Param("inicioDelDia") LocalDateTime inicioDelDia, @Param("finDelDia") LocalDateTime finDelDia);
}
