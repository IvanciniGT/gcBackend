package es.atgti.datavinci.repository.mappers;

import es.atgti.datavinci.jpa.entity.CocheEntity;
import es.atgti.datavinci.entity.Coche;

public interface CocheMapper {
    Coche cocheEntity2Coche(CocheEntity cocheEntity);
    CocheEntity coche2CocheEntity(Coche coche);
}
