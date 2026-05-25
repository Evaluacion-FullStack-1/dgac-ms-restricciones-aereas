package cl.dgac.restriccionesaereas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "restricciones_aereas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestriccionAerea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombreZona;

    @Column(nullable = false)
    private String tipoRestriccion;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private Double latitud;

    @Column(nullable = false)
    private Double longitud;

    @Column(nullable = false)
    private Double radioKm;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private LocalDate fechaInicio;

    @Column(nullable = false)
    private LocalDate fechaFin;
}