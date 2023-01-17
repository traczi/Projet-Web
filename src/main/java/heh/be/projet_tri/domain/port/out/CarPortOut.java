package heh.be.projet_tri.domain.port.out;

import heh.be.projet_tri.domain.model.Car;

import java.util.List;

public interface CarPortOut {
    public List<Car> getCarList();
    public Car selectedId(Long id);
}
