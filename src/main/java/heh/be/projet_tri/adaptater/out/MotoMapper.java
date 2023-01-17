package heh.be.projet_tri.adaptater.out;

import heh.be.projet_tri.domain.model.Moto;

import java.util.ArrayList;
import java.util.List;


public class MotoMapper {

    List<Moto> MotoMapJpaToDomain(List<MotoJpaEntity> motos){
        List<Moto> motosList = new ArrayList<>();

        for (MotoJpaEntity motoJpaEntity: motos) {
            motosList.add(new Moto(motoJpaEntity.getIdMoto(), motoJpaEntity.getMarqueMoto(), motoJpaEntity.getModelMoto(), motoJpaEntity.getAnneeMoto(), motoJpaEntity.getPrixMoto(), motoJpaEntity.getImageMoto()));
        }
        return motosList;
    }

    public MotoJpaEntity MotoMapDomainToJpa(Moto moto){
        return new MotoJpaEntity(moto.getIdMoto(), moto.getMarqueMoto(), moto.getModelMoto(), moto.getAnneeMoto(), moto.getPrixMoto(), moto.getImageMoto());
    }
    public Moto MotoMapJpaToDomain(MotoJpaEntity motoJpaEntity){
        return new Moto(motoJpaEntity.getIdMoto(), motoJpaEntity.getMarqueMoto(), motoJpaEntity.getModelMoto(), motoJpaEntity.getAnneeMoto(), motoJpaEntity.getPrixMoto(), motoJpaEntity.getImageMoto());
    }
}
