package ppa_flight.ppa_flight.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "aeropuertos")
@Getter
@Setter
@NoArgsConstructor
public class AeropuertoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo", nullable = false, unique = true, length = 3)
    private String codigo; // Código IATA de 3 letras (ej. BOG, MDE)

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "ciudad", nullable = false)
    private String ciudad;

    @Column(name = "pais", nullable = false)
    private String pais;

    @Builder
    public AeropuertoEntity(Long id, String codigo, String nombre, String ciudad, String pais) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
    }
}
