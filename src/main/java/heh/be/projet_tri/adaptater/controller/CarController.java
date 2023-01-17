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
}