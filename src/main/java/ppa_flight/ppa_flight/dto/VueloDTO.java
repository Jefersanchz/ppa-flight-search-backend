package ppa_flight.ppa_flight.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class VueloDTO {
    private Long id;
    private Long aeropuertoOrigenId;
    private Long aeropuertoDestinoId;
    private LocalDateTime fechaSalida;
    private LocalDateTime fechaLlegada;
    private Long duracion;
    private Integer numeroEscalas;

    @Builder
    public VueloDTO(Long id, Long aeropuertoOrigenId, Long aeropuertoDestinoId, LocalDateTime fechaSalida,
                    LocalDateTime fechaLlegada, Long duracion, Integer numeroEscalas) {
        this.id = id;
        this.aeropuertoOrigenId = aeropuertoOrigenId;
        this.aeropuertoDestinoId = aeropuertoDestinoId;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        this.duracion = duracion;
        this.numeroEscalas = numeroEscalas;
    }
}
