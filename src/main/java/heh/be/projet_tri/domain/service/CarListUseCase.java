package heh.be.projet_tri.domain.service;

import heh.be.projet_tri.domain.model.Car;
import heh.be.projet_tri.domain.port.in.*;
import heh.be.projet_tri.domain.port.out.CarPortOut;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
public class CarListUseCase implements CarPortIn {

    @Getter
    private final CarPortOut carPortOut;
    @Override
    public List<Car> getCarList(){
        return getCarPortOut().getCarList();
    }

    @Override
    public Car selectedId(Long id) {
        return carPortOut.selectedId(id);
    }
}
