package cl.dgac.restriccionesaereas.controller;

import cl.dgac.restriccionesaereas.dto.RestriccionAereaRequestDTO;
import cl.dgac.restriccionesaereas.dto.RestriccionAereaResponseDTO;
import cl.dgac.restriccionesaereas.service.RestriccionAereaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restricciones-aereas")
public class RestriccionAereaController {

    private final RestriccionAereaService restriccionService;

    public RestriccionAereaController(RestriccionAereaService restriccionService) {
        this.restriccionService = restriccionService;
    }

    @GetMapping
    public ResponseEntity<List<RestriccionAereaResponseDTO>> listarRestricciones() {
        return ResponseEntity.ok(restriccionService.listarRestricciones());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestriccionAereaResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(restriccionService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<RestriccionAereaResponseDTO> crearRestriccion(
            @Valid @RequestBody RestriccionAereaRequestDTO dto) {

        RestriccionAereaResponseDTO restriccionCreada = restriccionService.crearRestriccion(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(restriccionCreada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestriccionAereaResponseDTO> actualizarRestriccion(
            @PathVariable Long id,
            @Valid @RequestBody RestriccionAereaRequestDTO dto) {

        return ResponseEntity.ok(restriccionService.actualizarRestriccion(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRestriccion(@PathVariable Long id) {
        restriccionService.eliminarRestriccion(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/tipo")
    public ResponseEntity<List<RestriccionAereaResponseDTO>> listarPorTipoRestriccion(
            @RequestParam String tipoRestriccion) {

        return ResponseEntity.ok(restriccionService.listarPorTipoRestriccion(tipoRestriccion));
    }

    @GetMapping("/estado")
    public ResponseEntity<List<RestriccionAereaResponseDTO>> listarPorEstado(
            @RequestParam String estado) {

        return ResponseEntity.ok(restriccionService.listarPorEstado(estado));
    }

    @GetMapping("/zona")
    public ResponseEntity<List<RestriccionAereaResponseDTO>> buscarPorNombreZona(
            @RequestParam String nombreZona) {

        return ResponseEntity.ok(restriccionService.buscarPorNombreZona(nombreZona));
    }

    @GetMapping("/empresas-mandantes")
    public ResponseEntity<String> consultarEmpresasMandantes() {
        return ResponseEntity.ok(restriccionService.consultarMicroservicioEmpresasMandantes());
    }
}