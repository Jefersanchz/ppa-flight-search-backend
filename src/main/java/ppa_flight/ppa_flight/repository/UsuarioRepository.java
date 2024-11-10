package ppa_flight.ppa_flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ppa_flight.ppa_flight.entity.UsuarioEntity;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    Optional<UsuarioEntity> findByUsuario(String usuario);
}
