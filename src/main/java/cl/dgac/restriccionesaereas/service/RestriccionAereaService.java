package cl.dgac.restriccionesaereas.service;

import cl.dgac.restriccionesaereas.dto.RestriccionAereaRequestDTO;
import cl.dgac.restriccionesaereas.dto.RestriccionAereaResponseDTO;
import cl.dgac.restriccionesaereas.exception.ResourceNotFoundException;
import cl.dgac.restriccionesaereas.mapper.RestriccionAereaMapper;
import cl.dgac.restriccionesaereas.model.RestriccionAerea;
import cl.dgac.restriccionesaereas.repository.RestriccionAereaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestriccionAereaService {

    private final RestriccionAereaRepository restriccionRepository;
    private final RestriccionAereaMapper restriccionMapper;
    private final WebClient.Builder webClientBuilder;

    public RestriccionAereaService(RestriccionAereaRepository restriccionRepository,
                                   RestriccionAereaMapper restriccionMapper,
                                   WebClient.Builder webClientBuilder) {
        this.restriccionRepository = restriccionRepository;
        this.restriccionMapper = restriccionMapper;
        this.webClientBuilder = webClientBuilder;
    }

    public List<RestriccionAereaResponseDTO> listarRestricciones() {
        return restriccionRepository.findAll()
                .stream()
                .map(restriccionMapper::toDTO)
                .collect(Collectors.toList());
    }

    public RestriccionAereaResponseDTO buscarPorId(Long id) {
        RestriccionAerea restriccion = restriccionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restricción aérea no encontrada con ID: " + id));

        return restriccionMapper.toDTO(restriccion);
    }

    public RestriccionAereaResponseDTO crearRestriccion(RestriccionAereaRequestDTO dto) {
        RestriccionAerea restriccion = restriccionMapper.toEntity(dto);
        RestriccionAerea restriccionGuardada = restriccionRepository.save(restriccion);

        return restriccionMapper.toDTO(restriccionGuardada);
    }

    public RestriccionAereaResponseDTO actualizarRestriccion(Long id, RestriccionAereaRequestDTO dto) {
        RestriccionAerea restriccion = restriccionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restricción aérea no encontrada con ID: " + id));

        restriccionMapper.updateEntity(restriccion, dto);
        RestriccionAerea restriccionActualizada = restriccionRepository.save(restriccion);

        return restriccionMapper.toDTO(restriccionActualizada);
    }

    public void eliminarRestriccion(Long id) {
        RestriccionAerea restriccion = restriccionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restricción aérea no encontrada con ID: " + id));

        restriccionRepository.delete(restriccion);
    }

    public List<RestriccionAereaResponseDTO> listarPorTipoRestriccion(String tipoRestriccion) {
        return restriccionRepository.findByTipoRestriccion(tipoRestriccion)
                .stream()
                .map(restriccionMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<RestriccionAereaResponseDTO> listarPorEstado(String estado) {
        return restriccionRepository.findByEstado(estado)
                .stream()
                .map(restriccionMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<RestriccionAereaResponseDTO> buscarPorNombreZona(String nombreZona) {
        return restriccionRepository.buscarPorNombreZona(nombreZona)
                .stream()
                .map(restriccionMapper::toDTO)
                .collect(Collectors.toList());
    }

    public String consultarMicroservicioEmpresasMandantes() {
        return webClientBuilder.build()
                .get()
                .uri("http://localhost:8086/api/empresas-mandantes")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}