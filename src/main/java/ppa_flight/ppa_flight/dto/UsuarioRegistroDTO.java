package ppa_flight.ppa_flight.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioRegistroDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String usuario;
    private String contrasena;

    @Builder
    public UsuarioRegistroDTO(String nombre, String apellido, String usuario, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }
}
