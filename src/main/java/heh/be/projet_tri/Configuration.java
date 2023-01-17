package heh.be.projet_tri;

import heh.be.projet_tri.adaptater.out.CarMapper;
import heh.be.projet_tri.adaptater.out.CarPersistenceAdaptater;
import heh.be.projet_tri.adaptater.out.CarRepository;
import heh.be.projet_tri.domain.port.in.CarPortIn;
import heh.be.projet_tri.domain.port.out.CarPortOut;
import heh.be.projet_tri.domain.service.CarListUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@org.springframework.context.annotation.Configuration
@EnableJpaRepositories
public class Configuration {
    @Autowired
    private CarRepository carRepository;

    private CarMapper carMapper = new CarMapper();
    private CarPersistenceAdaptater carPersistenceAdaptater;

    @Bean
    public CarPortOut getCarPortOut(){
        return new CarPersistenceAdaptater(carRepository,carMapper);
    }

    @Bean
    public CarPortIn getCarPortIn(){
        carPersistenceAdaptater = new CarPersistenceAdaptater(carRepository, carMapper);
        return new CarListUseCase(carPersistenceAdaptater);
    }
}
