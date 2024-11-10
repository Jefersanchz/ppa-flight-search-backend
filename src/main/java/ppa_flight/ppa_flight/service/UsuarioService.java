package ppa_flight.ppa_flight.service;

import ppa_flight.ppa_flight.dto.UsuarioDTO;
import ppa_flight.ppa_flight.dto.UsuarioRegistroDTO;

import java.util.Optional;

public interface UsuarioService {
    UsuarioDTO registrarUsuario(UsuarioRegistroDTO usuarioRegistroDTO);
    Optional<UsuarioDTO> iniciarSesion(String usuario, String contrasena);
}
