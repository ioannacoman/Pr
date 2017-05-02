package ro.sci.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ro.sci.meniu.Produs;
import ro.sci.services.ProdusService;

import java.util.Collection;

@Controller

public class ProdusControler {

    @Autowired
    private ProdusService produsService;


    @RequestMapping("/list")
    public ModelAndView list() {
        ModelAndView result = new ModelAndView("/list");


        Collection<Produs> produse = produsService.listAll();
        result.addObject("produs", produse);

        return result;
    }
}