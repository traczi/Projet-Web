package heh.be.projet_tri.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Car {
    @Getter
    private final Long id;

    @Getter
    private final String marque;

    @Getter
    private final String model;

    @Getter
    private final Integer annee;

    @Getter
    private final Integer prix;

    @Getter
    private final String image;
}