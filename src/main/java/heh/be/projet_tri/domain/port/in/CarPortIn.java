package heh.be.projet_tri.domain.port.in;

import heh.be.projet_tri.domain.model.Car;

import java.util.List;

public interface CarPortIn {

    public List<Car> getCarList();
    Car selectedId(Long id);
    public void addCar(Car car);
}
