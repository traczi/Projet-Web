package heh.be.projet_tri.domain.port.out;

import heh.be.projet_tri.domain.model.Moto;

import java.util.List;

public interface MotoPortOut {
    public List<Moto> getMotoList();

    public List<Moto> getMotoListById(List<Integer> listMoto);

    public void addMoto(Moto moto);

    public void updateMoto(Moto moto);

    public void deleteMoto(Long idMoto);

    public Moto selectedIdMoto(Long idMoto);
}
