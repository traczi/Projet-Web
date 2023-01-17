package heh.be.projet_tri.adaptater.out;

import heh.be.projet_tri.domain.model.Moto;
import heh.be.projet_tri.domain.port.out.MotoPortOut;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class MotoPersistenceAdaptater implements MotoPortOut {


    private final MotoRepository motoRepository;
    private List<Moto> motos;
    private final MotoMapper motoMapper;


    //Méthode pour récupérer la liste des voitures

    @Override
    public List<Moto> getMotoList() {

        List<MotoJpaEntity> motoJpaEntityList = motoRepository.findAll();
        return motoMapper.MotoMapJpaToDomain(motoJpaEntityList);
    }


    //Méthode pour récupérer la liste des voitures pa rapport à l'id

    @Override
    public List<Moto> getMotoListById(List<Integer> listMoto) {
        return null;
    }


    //Méthode pour ajouter une voiture

    @Override
    public void addMoto(Moto moto) {
        motoRepository.save(motoMapper.MotoMapDomainToJpa(moto));
    }


    //Méthode pour modifier une voiture

    @Override
    public void updateMoto(Moto moto){
        MotoJpaEntity motoJpaEntity = motoRepository.findById(moto.getIdMoto()).get();
        if(motoJpaEntity.equals(null)){

        }else{
            motoJpaEntity.setIdMoto(moto.getIdMoto());
            motoJpaEntity.setMarqueMoto(moto.getMarqueMoto());
            motoJpaEntity.setModelMoto(moto.getModelMoto());
            motoJpaEntity.setAnneeMoto(moto.getAnneeMoto());
            motoJpaEntity.setPrixMoto(moto.getPrixMoto());
            motoJpaEntity.setImageMoto(moto.getImageMoto());

            motoRepository.save(motoJpaEntity);
        }
    }


    //Méthode pour supprimer une voiture

    @Override
    public void deleteMoto(Long idMoto){
        motoRepository.deleteById(idMoto);
    }


    //Selected id

    @Override
    public Moto selectedIdMoto(Long idMoto) {
        MotoJpaEntity motoJpaEntity= motoRepository.findById(idMoto).get();
        if(motoJpaEntity.equals(null)){
            return null;
        }else{
            return motoMapper.MotoMapJpaToDomain(motoJpaEntity);
        }
    }
}