package NutriApoyo.dao;

import NutriApoyo.model.Beneficiario;
import NutriApoyo.model.EstadoBeneficiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long> {

    @Query("""
            select b from Beneficiario b
            where (:termino is null
                   or lower(b.nombres) like lower(concat('%', :termino, '%'))
                   or lower(b.apellidos) like lower(concat('%', :termino, '%'))
                   or b.numeroDocumento like concat('%', :termino, '%'))
              and (:estado is null or b.estado = :estado)
              and (:distrito is null or b.distrito = :distrito)
            order by b.apellidos, b.nombres
            """)
    List<Beneficiario> buscar(
            @Param("termino") String termino,
            @Param("estado") EstadoBeneficiario estado,
            @Param("distrito") String distrito);

    Optional<Beneficiario> findByNumeroDocumento(String numeroDocumento);

    boolean existsByNumeroDocumentoAndIdNot(String numeroDocumento, Long id);

    @Query("select distinct b.distrito from Beneficiario b order by b.distrito")
    List<String> encontrarDistritos();
}
