package es.atgti.datavinci.repository;

import es.atgti.datavinci.entity.Coche;
import lombok.NonNull;

import java.util.List;
import java.util.Optional;

public interface CochesRepository {

    List<Coche> findAll();

    Optional<Coche> findByMatricula(@NonNull String matricula);

    List<Coche> findByMatriculaStartingWith(@NonNull String matriculaPrefijo);

    Coche save(@NonNull Coche coche);

    Optional<Coche> deleteByMatricula(@NonNull String matricula);

    Optional<Coche> delete(@NonNull Coche coche);
}
