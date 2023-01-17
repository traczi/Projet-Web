package heh.be.projet_tri.adaptater.out;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "motos")
public class MotoJpaEntity {
    public MotoJpaEntity(){

    }

    public MotoJpaEntity(Long idMoto, String marqueMoto, String modelMoto, Integer anneeMoto, Integer prixMoto, String imageMoto){
        this.idMoto = idMoto;
        this.marqueMoto = marqueMoto;
        this.modelMoto = modelMoto;
        this.anneeMoto = anneeMoto;
        this.prixMoto = prixMoto;
        this.imageMoto = imageMoto;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_moto")
    private Long idMoto;

    @Column(name = "marquemoto")
    private String marqueMoto;

    @Column(name = "modelmoto")
    private String modelMoto;

    @Column(name = "anneemoto")
    private Integer anneeMoto;

    @Column(name = "prixmoto")
    private Integer prixMoto;

    @Column(name = "imagemoto")
    private String imageMoto;

}