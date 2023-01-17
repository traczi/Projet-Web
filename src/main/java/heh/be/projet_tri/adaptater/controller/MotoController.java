package heh.be.projet_tri.adaptater.controller;

import heh.be.projet_tri.domain.model.Moto;
import heh.be.projet_tri.domain.port.in.MotoPortIn;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MotoController {

    @Getter
    private final MotoPortIn motoPortIn;
    @Getter
    @Setter
    private List<Moto> motosList;
    @GetMapping("/motoList")
    public String getMotoList(Model model, @AuthenticationPrincipal OidcUser principal){
        setMotosList(getMotoPortIn().getMotoList());
        List<Long>longs = new ArrayList<>();
        for(Moto cr:getMotosList()){
            longs.add(cr.getIdMoto());
        }
        Collections.sort(longs);
        getMotosList().clear();
        for(Long idMoto:longs){
            Moto newCr = motoPortIn.selectedIdMoto(idMoto);
            getMotosList().add(newCr);
        }
        if (principal!=null){
            model.addAttribute("isAdmin",getAdmins().contains(principal.getClaims().get("email")));
        }
        model.addAttribute("motos",getMotosList());
        return "motoList";
    }

    @GetMapping("/addMoto")
    public String addMoto(Model model, @AuthenticationPrincipal OidcUser principal){
        if (principal!=null){
            model.addAttribute("isAdmin",getAdmins().contains(principal.getClaims().get("email")));
        }
        return "addMoto";
    }


    //Affichage pour modifier les voitures

    @GetMapping("/updateMoto")
    public String updateCar(@ModelAttribute("motoList") Moto moto, Model model, @AuthenticationPrincipal OidcUser principal){
        if (principal!=null){
            System.out.println(getAdmins().contains(principal.getClaims().get("email")));
            model.addAttribute("isAdmin",getAdmins().contains(principal.getClaims().get("email")));
        }
        return "updateMotoView";
    }

    @GetMapping("/viewByIdMoto")
    public String viewById(@ModelAttribute("motoList") Moto moto, Model model, @AuthenticationPrincipal OidcUser principal){
        if (principal!=null){
            System.out.println(getAdmins().contains(principal.getClaims().get("email")));
            model.addAttribute("isAdmin",getAdmins().contains(principal.getClaims().get("email")));
        }
        return "viewByIdMoto";
    }

    //Méthode pour ajouter une voiture

    @PostMapping("/addMotoForm")
    @ResponseBody
    public RedirectView addView(@ModelAttribute("addMoto") Moto moto, Model model, @AuthenticationPrincipal OidcUser principal) throws Exception{
        Moto moto1 = new Moto(Long.parseLong(moto.getIdMoto().toString()),moto.getMarqueMoto(),moto.getModelMoto(),moto.getAnneeMoto(), moto.getPrixMoto(), moto.getImageMoto());
        motoPortIn.addMoto(moto1);
        if (principal!=null){
            model.addAttribute("isAdmin",getAdmins().contains(principal.getClaims().get("email")));
        }
        return new RedirectView("/motoList");
    }


    //Méthode pour supprimer une voiture

    @PostMapping("/deleteMotoForm")
    public RedirectView deleteMoto(@ModelAttribute("motoList") Moto moto){
        motoPortIn.deleteMoto(moto.getIdMoto());
        return new RedirectView("/motoList");
    }



    //Méthode pour modifier une voiture
    @PostMapping("/updateMotoForm")
    @ResponseBody
    public RedirectView updateMotoView(@ModelAttribute("updateMoto") Moto moto, Model model, @AuthenticationPrincipal OidcUser principal){
        Moto moto1 = new Moto(moto.getIdMoto(),moto.getMarqueMoto(),moto.getModelMoto(),moto.getAnneeMoto(), moto.getPrixMoto(), moto.getImageMoto());
        motoPortIn.updateMoto(moto1);
        if (principal!=null){
            model.addAttribute("isAdmin",getAdmins().contains(principal.getClaims().get("email")));
        }
        return new RedirectView("/motoList");
    }
    private List<String> getAdmins(){
        List<String> admins = Arrays.asList("benjamin.0218@hotmail.com", "matteo.alcantarini@hotmail.com");
        return admins;
    }
}
