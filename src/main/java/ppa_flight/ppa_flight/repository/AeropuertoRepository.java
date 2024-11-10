package ppa_flight.ppa_flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ppa_flight.ppa_flight.entity.AeropuertoEntity;

public interface AeropuertoRepository extends JpaRepository<AeropuertoEntity, Long> {
}
