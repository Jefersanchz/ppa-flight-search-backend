package ppa_flight.ppa_flight.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "vuelos")
@Getter
@Setter
@NoArgsConstructor
public class VueloEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aeropuerto_origen_id", nullable = false)
    private AeropuertoEntity aeropuertoOrigen;

    @ManyToOne
    @JoinColumn(name = "aeropuerto_destino_id", nullable = false)
    private AeropuertoEntity aeropuertoDestino;

    @Column(name = "fecha_salida", nullable = false)
    private LocalDateTime fechaSalida;

    @Column(name = "fecha_llegada", nullable = false)
    private LocalDateTime fechaLlegada;

    @Column(name = "duracion", nullable = false)
    private Long duracion; // en minutos

    @Column(name = "numero_escalas", nullable = false)
    private Integer numeroEscalas;

    @Builder
    public VueloEntity(Long id, AeropuertoEntity aeropuertoOrigen, AeropuertoEntity aeropuertoDestino,
                       LocalDateTime fechaSalida, LocalDateTime fechaLlegada, Long duracion, Integer numeroEscalas) {
        this.id = id;
        this.aeropuertoOrigen = aeropuertoOrigen;
        this.aeropuertoDestino = aeropuertoDestino;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        this.duracion = duracion;
        this.numeroEscalas = numeroEscalas;
    }
}
