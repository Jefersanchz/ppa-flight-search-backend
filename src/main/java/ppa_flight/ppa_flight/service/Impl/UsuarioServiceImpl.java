package ppa_flight.ppa_flight.service.Impl;

import org.springframework.dao.DataIntegrityViolationException;
import ppa_flight.ppa_flight.dto.UsuarioDTO;
import ppa_flight.ppa_flight.dto.UsuarioRegistroDTO;
import ppa_flight.ppa_flight.entity.UsuarioEntity;
import ppa_flight.ppa_flight.mapper.UsuarioMapper;
import ppa_flight.ppa_flight.repository.UsuarioRepository;
import ppa_flight.ppa_flight.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private static final Logger logger = LoggerFactory.getLogger(UsuarioServiceImpl.class);

    @Autowired
    private UsuarioRepository usuarioRepository;

    private UsuarioMapper usuarioMapper = UsuarioMapper.INSTANCE;

    @Override
    public UsuarioDTO registrarUsuario(UsuarioRegistroDTO usuarioRegistroDTO) {
        try {
            UsuarioEntity usuarioEntity = usuarioMapper.toEntity(usuarioRegistroDTO);
            UsuarioEntity savedUsuario = usuarioRepository.save(usuarioEntity);
            return usuarioMapper.toDTO(savedUsuario);
        } catch (DataIntegrityViolationException e) {
            logger.error("Error al registrar usuario: nombre de usuario ya existe.", e);
            throw new IllegalArgumentException("El nombre de usuario ya está en uso.");
        }
    }

    @Override
    public Optional<UsuarioDTO> iniciarSesion(String usuario, String contrasena) {
        logger.info("Iniciando sesión para el usuario: {}", usuario);
        Optional<UsuarioEntity> usuarioOpt = usuarioRepository.findByUsuario(usuario);
        if (usuarioOpt.isPresent() && usuarioOpt.get().getContrasena().equals(contrasena)) {
            logger.info("Inicio de sesión exitoso.");
            return Optional.of(usuarioMapper.toDTO(usuarioOpt.get()));
        }
        logger.warn("Usuario o contraseña incorrectos.");
        return Optional.empty();
    }
}
