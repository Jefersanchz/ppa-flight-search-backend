package ppa_flight.ppa_flight.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioLoginDTO {
    private String usuario;
    private String contrasena;

    @Builder
    public UsuarioLoginDTO(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }
}
