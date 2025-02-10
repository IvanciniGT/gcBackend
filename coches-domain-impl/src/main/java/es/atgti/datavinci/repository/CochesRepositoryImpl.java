package es.atgti.datavinci.repository;

import es.atgti.datavinci.entity.Coche;
import es.atgti.datavinci.jpa.entity.CocheEntity;
import es.atgti.datavinci.jpa.repository.CochesJPARepository;
import es.atgti.datavinci.repository.mappers.CocheMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class CochesRepositoryImpl implements CochesRepository {

    private final CochesJPARepository repoBBDD;
    private final CocheMapper miMapeador;

    @Override
    public List<Coche> findAll() {
        return repoBBDD.findAll().stream().map(miMapeador::cocheEntity2Coche).toList();
    }

    @Override
    public Optional<Coche> findByMatricula(@NonNull String matricula) {
        return repoBBDD.findCocheEntitiesByMatricula(matricula).map(miMapeador::cocheEntity2Coche);
    }

    @Override
    public List<Coche> findByMatriculaStartingWith(@NonNull String matriculaPrefijo) {
        return repoBBDD.findCocheEntitiesByMatriculaStartingWith(matriculaPrefijo).stream().map(miMapeador::cocheEntity2Coche).toList();
    }

    @Override
    public Coche save(@NonNull Coche coche) {
        CocheEntity devuelto =  repoBBDD.save( miMapeador.coche2CocheEntity(coche));
        return miMapeador.cocheEntity2Coche(devuelto);
    }

    @Override
    public Optional<Coche> deleteByMatricula(@NonNull String matricula) {
        return repoBBDD.findCocheEntitiesByMatricula(matricula)
                .map(miMapeador::cocheEntity2Coche).map(coche -> {
                    repoBBDD.deleteCocheEntityByMatricula(matricula);
                    return coche;
                });
    }

    @Override
    public Optional<Coche> delete(@NonNull Coche coche) {
        return repoBBDD.findCocheEntitiesByMatricula(coche.getMatricula())
                .map( cocheABorrar ->
                {
                    repoBBDD.delete(cocheABorrar);
                    return miMapeador.cocheEntity2Coche(cocheABorrar);
                }
                );
    }
}