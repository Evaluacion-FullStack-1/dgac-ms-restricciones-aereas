package cl.dgac.restriccionesaereas.repository;

import cl.dgac.restriccionesaereas.model.RestriccionAerea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RestriccionAereaRepository extends JpaRepository<RestriccionAerea, Long> {

    List<RestriccionAerea> findByTipoRestriccion(String tipoRestriccion);

    List<RestriccionAerea> findByEstado(String estado);

    @Query("SELECT r FROM RestriccionAerea r WHERE LOWER(r.nombreZona) LIKE LOWER(CONCAT('%', :nombreZona, '%'))")
    List<RestriccionAerea> buscarPorNombreZona(String nombreZona);
}