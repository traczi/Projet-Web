package heh.be.projet_tri.domain.port.in;

import heh.be.projet_tri.domain.model.Moto;

import java.util.List;

public interface MotoPortIn {
    public List<Moto> getMotoList();

    public void addMoto(Moto moto);

    public void deleteMoto(Long idMoto);

    public void updateMoto(Moto moto);

    Moto selectedIdMoto(Long idMoto);
}
