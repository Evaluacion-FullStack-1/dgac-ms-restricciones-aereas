package cl.dgac.restriccionesaereas.mapper;

import cl.dgac.restriccionesaereas.dto.RestriccionAereaRequestDTO;
import cl.dgac.restriccionesaereas.dto.RestriccionAereaResponseDTO;
import cl.dgac.restriccionesaereas.model.RestriccionAerea;
import org.springframework.stereotype.Component;

@Component
public class RestriccionAereaMapper {

    public RestriccionAerea toEntity(RestriccionAereaRequestDTO dto) {
        RestriccionAerea restriccion = new RestriccionAerea();

        restriccion.setNombreZona(dto.getNombreZona());
        restriccion.setTipoRestriccion(dto.getTipoRestriccion());
        restriccion.setDescripcion(dto.getDescripcion());
        restriccion.setLatitud(dto.getLatitud());
        restriccion.setLongitud(dto.getLongitud());
        restriccion.setRadioKm(dto.getRadioKm());
        restriccion.setEstado(dto.getEstado());
        restriccion.setFechaInicio(dto.getFechaInicio());
        restriccion.setFechaFin(dto.getFechaFin());

        return restriccion;
    }

    public RestriccionAereaResponseDTO toDTO(RestriccionAerea restriccion) {
        RestriccionAereaResponseDTO dto = new RestriccionAereaResponseDTO();

        dto.setId(restriccion.getId());
        dto.setNombreZona(restriccion.getNombreZona());
        dto.setTipoRestriccion(restriccion.getTipoRestriccion());
        dto.setDescripcion(restriccion.getDescripcion());
        dto.setLatitud(restriccion.getLatitud());
        dto.setLongitud(restriccion.getLongitud());
        dto.setRadioKm(restriccion.getRadioKm());
        dto.setEstado(restriccion.getEstado());
        dto.setFechaInicio(restriccion.getFechaInicio());
        dto.setFechaFin(restriccion.getFechaFin());

        return dto;
    }

    public void updateEntity(RestriccionAerea restriccion, RestriccionAereaRequestDTO dto) {
        restriccion.setNombreZona(dto.getNombreZona());
        restriccion.setTipoRestriccion(dto.getTipoRestriccion());
        restriccion.setDescripcion(dto.getDescripcion());
        restriccion.setLatitud(dto.getLatitud());
        restriccion.setLongitud(dto.getLongitud());
        restriccion.setRadioKm(dto.getRadioKm());
        restriccion.setEstado(dto.getEstado());
        restriccion.setFechaInicio(dto.getFechaInicio());
        restriccion.setFechaFin(dto.getFechaFin());
    }
}