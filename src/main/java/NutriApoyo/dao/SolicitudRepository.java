package NutriApoyo.dao;

import NutriApoyo.model.EstadoSolicitud;
import NutriApoyo.model.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {

    Optional<Solicitud> findByCodigoSeguimiento(String codigoSeguimiento);

    boolean existsByCodigoSeguimiento(String codigoSeguimiento);

    boolean existsByBeneficiarioIdAndEstadoIn(Long beneficiarioId, Collection<EstadoSolicitud> estados);

    @Query("""
            select s from Solicitud s join fetch s.beneficiario
            where (:estado is null or s.estado = :estado)
            order by s.fechaSolicitud asc
            """)
    List<Solicitud> buscarParaEvaluacion(@Param("estado") EstadoSolicitud estado);

    @Query("""
            select s from Solicitud s join fetch s.beneficiario
            where s.id = :id
            """)
    Optional<Solicitud> buscarDetallePorId(@Param("id") Long id);
}
