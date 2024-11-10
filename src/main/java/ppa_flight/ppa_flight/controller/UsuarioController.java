package ppa_flight.ppa_flight.controller;

import ppa_flight.ppa_flight.dto.UsuarioDTO;
import ppa_flight.ppa_flight.dto.UsuarioLoginDTO;
import ppa_flight.ppa_flight.dto.UsuarioRegistroDTO;
import ppa_flight.ppa_flight.service.UsuarioService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarUsuario(@RequestBody UsuarioRegistroDTO usuarioRegistroDTO) {
        try {
            UsuarioDTO nuevoUsuario = usuarioService.registrarUsuario(usuarioRegistroDTO);
            return ResponseEntity.ok(nuevoUsuario);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(409).body("El nombre de usuario ya está en uso.");
        }
    }

@PostMapping("/iniciar-sesion")
public ResponseEntity<Map<String, String>> iniciarSesion(@RequestBody UsuarioLoginDTO loginDTO) {
    return usuarioService.iniciarSesion(loginDTO.getUsuario(), loginDTO.getContrasena())
            .map(u -> {
                Map<String, String> response = new HashMap<>();
                response.put("message", "Inicio de sesión exitoso");
                return ResponseEntity.ok(response);
            })
            .orElse(ResponseEntity.status(401).body(Map.of("error", "Usuario o contraseña incorrectos")));
}
}
