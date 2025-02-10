package es.atgti.datavinci.jpa.repository;

import es.atgti.datavinci.jpa.entity.CocheEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CochesJPARepository extends JpaRepository<CocheEntity, Integer> {

    Optional<CocheEntity> findCocheEntitiesByMatricula(String matricula);
    List<CocheEntity> findCocheEntitiesByMatriculaStartingWith(String matriculaPrefijo);
    void deleteCocheEntityByMatricula(String matricula);

    // Spring en automático (hibernate mediante) implementa el código de esas funciones,. en base a su nombre.

}
