package heh.be.projet_tri;

import heh.be.projet_tri.adaptater.out.*;
import heh.be.projet_tri.domain.port.in.CarPortIn;
import heh.be.projet_tri.domain.port.in.MotoPortIn;
import heh.be.projet_tri.domain.port.out.CarPortOut;
import heh.be.projet_tri.domain.port.out.MotoPortOut;
import heh.be.projet_tri.domain.service.CarListUseCase;
import heh.be.projet_tri.domain.service.MotoListUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@org.springframework.context.annotation.Configuration
@EnableJpaRepositories
public class Configuration {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private MotoRepository motoRepository;

    private CarMapper carMapper = new CarMapper();
    private CarPersistenceAdaptater carPersistenceAdaptater;
    private MotoMapper motoMapper = new MotoMapper();
    private MotoPersistenceAdaptater motoPersistenceAdaptater;

    @Bean
    public CarPortOut getCarPortOut() {
        return new CarPersistenceAdaptater(carRepository, carMapper);
    }

    @Bean
    public CarPortIn getCarPortIn() {
        carPersistenceAdaptater = new CarPersistenceAdaptater(carRepository, carMapper);
        return new CarListUseCase(carPersistenceAdaptater);
    }

    @Bean
    public MotoPortOut getMotoPortOut() {
        return new MotoPersistenceAdaptater(motoRepository, motoMapper);
    }

    @Bean
    public MotoPortIn getMotoPortIn() {
        motoPersistenceAdaptater = new MotoPersistenceAdaptater(motoRepository, motoMapper);
        return new MotoListUseCase(motoPersistenceAdaptater);

    }
}
