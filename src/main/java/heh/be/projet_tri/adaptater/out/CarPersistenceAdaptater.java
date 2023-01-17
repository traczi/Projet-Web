package heh.be.projet_tri.adaptater.out;

import heh.be.projet_tri.domain.model.Car;
import heh.be.projet_tri.domain.port.out.CarPortOut;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CarPersistenceAdaptater implements CarPortOut {

    private final CarRepository carRepository;
    private List<Car> cars;
    private final CarMapper carMapper;
    @Override
    public List<Car> getCarList() {

        List<CarJpaEntity> carJpaEntityList = carRepository.findAll();
        return carMapper.CarMapJpaToDomain(carJpaEntityList);
    }

    @Override
    public void addCar(Car car) {
        carRepository.save(carMapper.CarMapDomainToJpa(car));
    }

    @Override
    public Car selectedId(Long id) {
        CarJpaEntity carJpaEntity= carRepository.findById(id).get();
        if(carJpaEntity.equals(null)){
            return null;
        }else{
            return carMapper.CarMapJpaToDomain(carJpaEntity);
        }
    }
    @Override
    public void deleteCar(Long id){
        carRepository.deleteById(id);
    }
}