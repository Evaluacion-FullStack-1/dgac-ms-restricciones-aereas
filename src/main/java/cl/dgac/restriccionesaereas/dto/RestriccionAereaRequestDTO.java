package cl.dgac.restriccionesaereas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RestriccionAereaRequestDTO {

    @NotBlank(message = "El nombre de la zona es obligatorio")
    private String nombreZona;

    @NotBlank(message = "El tipo de restricción es obligatorio")
    private String tipoRestriccion;

    @NotBlank(message = "La descripción es obligatoria")
    private String descripcion;

    @NotNull(message = "La latitud es obligatoria")
    private Double latitud;

    @NotNull(message = "La longitud es obligatoria")
    private Double longitud;

    @NotNull(message = "El radio es obligatorio")
    @Positive(message = "El radio debe ser mayor a 0")
    private Double radioKm;

    @NotBlank(message = "El estado es obligatorio")
    private String estado;

    @NotNull(message = "La fecha de inicio es obligatoria")
    private LocalDate fechaInicio;

    @NotNull(message = "La fecha de fin es obligatoria")
    private LocalDate fechaFin;
}