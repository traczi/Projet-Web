package heh.be.projet_tri.adaptater.controller;

import heh.be.projet_tri.domain.model.Car;
import heh.be.projet_tri.domain.port.in.CarPortIn;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CarController {

    @Getter
    private final CarPortIn carPortIn;
    @Getter
    @Setter
    private List<Car> carsList;

    @GetMapping("/carList")
    public String getCarList(Model model){
        setCarsList(getCarPortIn().getCarList());
        List<Long>longs = new ArrayList<>();
        for(Car cr:getCarsList()){
            longs.add(cr.getId());
        }
        Collections.sort(longs);
        getCarsList().clear();
        for(Long id:longs){
            Car newCr = carPortIn.selectedId(id);
            getCarsList().add(newCr);
        }
        model.addAttribute("cars",getCarsList());
        return "carList";
    }

    @GetMapping("/addCar")
    public String addCar(){
        return "addCar";
    }

    @PostMapping("/addCarForm")
    @ResponseBody
    public RedirectView addView(@ModelAttribute("addCar") Car car) throws Exception{
        Car car1 = new Car(Long.parseLong(car.getId().toString()),car.getMarque(),car.getModel(),car.getAnnee(), car.getPrix(), car.getImage());
        carPortIn.addCar(car1);
        return new RedirectView("/carList");
    }
    @PostMapping("/deleteCarForm")
    public RedirectView deleteCar(@ModelAttribute("carList") Car car){
        carPortIn.deleteCar(car.getId());
        return new RedirectView("/carList");
    }
    //Affichage pour modifier les voitures

    @GetMapping("/updateCar")
    public String updateCar(@ModelAttribute("carList") Car car){
        return "updateCarView";
    }
    //Méthode pour modifier une voiture
    @PostMapping("/updateCarForm")
    @ResponseBody
    public RedirectView updateCarView(@ModelAttribute("updateCar") Car car){
        Car car1 = new Car(car.getId(),car.getMarque(),car.getModel(),car.getAnnee(), car.getPrix(), car.getImage());
        carPortIn.updateCar(car1);

        return new RedirectView("/carList");
    }
}