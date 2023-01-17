package heh.be.projet_tri.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Moto {
    @Getter
    private final Long idMoto;

    @Getter
    private final String marqueMoto;

    @Getter
    private final String modelMoto;

    @Getter
    private final Integer anneeMoto;

    @Getter
    private final Integer prixMoto;

    @Getter
    private final String imageMoto;
}