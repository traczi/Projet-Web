package heh.be.projet_tri.adaptater.out;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "cars")
public class CarJpaEntity {
    public CarJpaEntity(){

    }

    public CarJpaEntity(Long id, String marque, String model, Integer annee, Integer prix, String image){
        this.idCar = id;
        this.marque = marque;
        this.model = model;
        this.annee = annee;
        this.prix = prix;
        this.image = image;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_car")
    private Long idCar;

    @Column(name = "marque")
    private String marque;

    @Column(name = "model")
    private String model;

    @Column(name = "annee")
    private Integer annee;

    @Column(name = "prix")
    private Integer prix;

    @Column(name = "image")
    private String image;

}