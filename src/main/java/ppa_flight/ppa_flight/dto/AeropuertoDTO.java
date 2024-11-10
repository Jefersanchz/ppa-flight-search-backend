package ppa_flight.ppa_flight.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AeropuertoDTO {
    private Long id;
    private String codigo;
    private String nombre;
    private String ciudad;
    private String pais;

    @Builder
    public AeropuertoDTO(Long id, String codigo, String nombre, String ciudad, String pais) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
    }
}
