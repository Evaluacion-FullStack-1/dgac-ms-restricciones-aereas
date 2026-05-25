package cl.dgac.restriccionesaereas.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RestriccionAereaResponseDTO {

    private Long id;
    private String nombreZona;
    private String tipoRestriccion;
    private String descripcion;
    private Double latitud;
    private Double longitud;
    private Double radioKm;
    private String estado;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
}