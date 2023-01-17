package heh.be.projet_tri.domain.service;

import heh.be.projet_tri.domain.model.Moto;
import heh.be.projet_tri.domain.port.in.MotoPortIn;
import heh.be.projet_tri.domain.port.out.MotoPortOut;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class MotoListUseCase implements MotoPortIn {
    @Getter
    private final MotoPortOut motoPortOut;


    //Méthode pour récupérer la liste des voitures

    @Override
    public List<Moto> getMotoList(){
        return getMotoPortOut().getMotoList();
    }


    //Méthode pour ajouter une voiture

    @Override
    public void addMoto(Moto moto) {

        List<Moto> motos = motoPortOut.getMotoList();
        boolean bool = true;
        for(Moto pr : motos){
            if(pr.getIdMoto().equals(moto.getIdMoto())){
                bool=false;
            }
        }
        if(bool){
            motoPortOut.addMoto(moto);
        }
    }

    //Méthode pour modifier une voiture

    @Override
    public void updateMoto(Moto moto){
        motoPortOut.updateMoto(moto);
    }


    //Méthode pour supprimer une voiture

    @Override
    public void deleteMoto(Long idMoto){
        motoPortOut.deleteMoto(idMoto);
    }


    //SelectedId

    @Override
    public Moto selectedIdMoto(Long idMoto) {
        return motoPortOut.selectedIdMoto(idMoto);
    }
}
