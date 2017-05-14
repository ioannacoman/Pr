package ro.sci.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ro.sci.meniu.*;
import ro.sci.services.*;

import java.util.Collection;

/**
 * Created by Skipy on 5/12/2017.
 */
@Controller
public class SmartMeniuControler {

    private static int lastIndex;
    private static int currentTableNr;
    private static Comanda lastOrderNr;
    private static Comanda currentCount;

    @Autowired
    private ProdusService produsService;
    @Autowired
    private GamaService gamaService;
    @Autowired
    private ProdusComandatService produsComandatService;
    @Autowired
    private ComandaService comandaService;
    @Autowired
    private SumaService sumaService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView listGama(@RequestParam int id) {
        ModelAndView result = new ModelAndView("/list");
        Collection<Produs> produse = produsService.listProduse(String.valueOf(id));
        Gama gama = gamaService.getGama(id);
        Suma suma = sumaService.getSuma(String.valueOf(lastOrderNr));
        result.addObject("produs", produse);
        result.addObject("gama",gama);
        result.addObject("suma",suma);
        lastIndex = id;
        return result;
    }
    @RequestMapping(value = "/produse", method = RequestMethod.GET)


    public ModelAndView produ(@RequestParam int idProdus) {
        ModelAndView result = new ModelAndView("/produse");
        Collection<Produs> produse = produsService.getProduseById(idProdus);
        Gama gama = gamaService.getIdGama(idProdus);
        Suma suma = sumaService.getSuma(String.valueOf(lastOrderNr));
        result.addObject("produs", produse);
        result.addObject("gama",gama);
        result.addObject("suma",suma);

        return result;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView refresh(@RequestParam int idProdus,@RequestParam int addStatus) {
        produsService.addProdusCom(String.valueOf(lastOrderNr), idProdus);
        if (String.valueOf(addStatus).equals(String.valueOf(1)))
            {
                ModelAndView result = new ModelAndView("/list?id="+lastIndex);
                return result;
            } else {
            ModelAndView result = new ModelAndView("/comanda");
            Collection<ProdusComandat> produseComandate = produsComandatService.listAll(String.valueOf(lastOrderNr));
            result.addObject("produseComandate",produseComandate);
            Suma suma = sumaService.getSuma(String.valueOf(lastOrderNr));
            result.addObject("suma",suma);
            return result;
        }
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public ModelAndView remov(@RequestParam int idProdus,@RequestParam int aOrb) {
        produsService.remProdusCom(String.valueOf(lastOrderNr),idProdus,aOrb );
        ModelAndView result = new ModelAndView("/comanda");
        Collection<ProdusComandat> produseComandate = produsComandatService.listAll(String.valueOf(lastOrderNr));
        result.addObject("produseComandate",produseComandate);
        Suma suma = sumaService.getSuma(String.valueOf(lastOrderNr));
        result.addObject("suma",suma);
        return result;
    }

    @RequestMapping("/meniu")
    public ModelAndView meniu() {
    ModelAndView result = new ModelAndView("/meniu");
        currentCount = comandaService.countComenziDeschise(currentTableNr);
        if (String.valueOf(currentCount).equals(String.valueOf(0)))
            {
                lastOrderNr = comandaService.getIdComanda(1, currentTableNr);
                produsService.startComanda(String.valueOf(lastOrderNr),currentTableNr);
            } else {
                lastOrderNr = comandaService.getIdComanda(6, currentTableNr);
                    }
        Suma suma = sumaService.getSuma(String.valueOf(lastOrderNr));
        result.addObject("suma",suma);
        return result;
    }

    @RequestMapping("/comanda")
    public ModelAndView listComanda() {
        ModelAndView result = new ModelAndView("/comanda");
        Collection<ProdusComandat> produseComandate = produsComandatService.listAll(String.valueOf(lastOrderNr));
        result.addObject("produseComandate",produseComandate);
        Suma suma = sumaService.getSuma(String.valueOf(lastOrderNr));
        result.addObject("suma",suma);
        return result;
    }
    @RequestMapping("/abandon")
    public ModelAndView abandon() {

        comandaService.anulComanda(String.valueOf(lastOrderNr),currentTableNr);


        ModelAndView result = new ModelAndView("/?tableId="+currentTableNr);



        return result;
    }
    @RequestMapping(value = "/finish")
    public ModelAndView finish() {
        comandaService.finishComanda(String.valueOf(lastOrderNr),currentTableNr);
        return new ModelAndView("finish");
    }


    @RequestMapping(value = "/")
        public ModelAndView index(@RequestParam int tableId) {
        currentTableNr = tableId;
         return new ModelAndView("index");
    }

    @RequestMapping("/new")
    public ModelAndView newStart() {
        ModelAndView result = new ModelAndView("/?tableId="+currentTableNr);
        return result;
    }

    @RequestMapping(value = "/produs")
    public ModelAndView prdus() {

        return new ModelAndView("produs");
    }

}