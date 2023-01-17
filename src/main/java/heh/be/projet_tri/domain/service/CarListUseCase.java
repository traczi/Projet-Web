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
    public void addCar(Car car) {

        List<Car> cars = carPortOut.getCarList();
        boolean bool = true;
        for(Car pr : cars){
            if(pr.getId().equals(car.getId())){
                bool=false;
            }
        }
        if(bool){
            carPortOut.addCar(car);
        }
    }

    @Override
    public void deleteCar(Long id){
        carPortOut.deleteCar(id);
    }

    @Override
    public Car selectedId(Long id) {
        return carPortOut.selectedId(id);
    }
}
