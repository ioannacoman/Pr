package ro.sci.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ro.sci.meniu.*;
import ro.sci.services.*;
import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * Created by Skipy on 5/12/2017.
 */

@Controller
public class SmartMeniuControler {

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
    public ModelAndView listGama(HttpServletRequest request, @RequestParam int id) {
        ModelAndView result = new ModelAndView("/list");
        Collection<Produs> produse = produsService.listProduse(String.valueOf(id));
        Gama gama = gamaService.getGama(id);
        Suma suma = sumaService.getSuma(String.valueOf(request.getSession().getAttribute("lastOrderNr")));
        result.addObject("produs", produse);
        result.addObject("gama",gama);
        result.addObject("suma",suma);
        request.getSession().setAttribute("lastIndex", id);
        return result;
    }

    @RequestMapping(value = "/produse", method = RequestMethod.GET)
    public ModelAndView produ(HttpServletRequest request,@RequestParam int idProdus) {
        ModelAndView result = new ModelAndView("/produse");
        Collection<Produs> produse = produsService.getProduseById(idProdus);
        Gama gama = gamaService.getIdGama(idProdus);
        Suma suma = sumaService.getSuma(String.valueOf(request.getSession().getAttribute("lastOrderNr")));
        result.addObject("produs", produse);
        result.addObject("gama",gama);
        result.addObject("suma",suma);
        return result;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView refresh(HttpServletRequest request, @RequestParam int idProdus,@RequestParam int addStatus) {
        produsService.addProdusCom(String.valueOf(request.getSession().getAttribute("lastOrderNr")), idProdus);
        if (String.valueOf(addStatus).equals(String.valueOf(1)))
            {
                return new ModelAndView("/list?id=" + request.getSession().getAttribute("lastIndex"));
            } else {
            ModelAndView result = new ModelAndView("/comanda");
            Collection<ProdusComandat> produseComandate = produsComandatService.listAll(String.valueOf(request.getSession().getAttribute("lastOrderNr")));
            result.addObject("produseComandate",produseComandate);
            Suma suma = sumaService.getSuma(String.valueOf(request.getSession().getAttribute("lastOrderNr")));
            result.addObject("suma",suma);
            return result;
        }
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public ModelAndView remov(HttpServletRequest request, @RequestParam int idProdus,@RequestParam int aOrb) {
        produsService.remProdusCom(String.valueOf(request.getSession().getAttribute("lastOrderNr")),idProdus,aOrb );
        ModelAndView result = new ModelAndView("/comanda");
        Collection<ProdusComandat> produseComandate = produsComandatService.listAll(String.valueOf(request.getSession().getAttribute("lastOrderNr")));
        result.addObject("produseComandate",produseComandate);
        Suma suma = sumaService.getSuma(String.valueOf(request.getSession().getAttribute("lastOrderNr")));
        result.addObject("suma",suma);
        return result;
    }

    @RequestMapping("/meniu")
    public ModelAndView meniu(HttpServletRequest request) {
    ModelAndView result = new ModelAndView("/meniu");
        Comanda currentCount = comandaService.countComenziDeschise((Integer) request.getSession().getAttribute("currentTableNr"));
        if (String.valueOf(currentCount).equals(String.valueOf(0)))
            {
                request.getSession().setAttribute("lastOrderNr",comandaService.getIdComanda(1, (Integer) request.getSession().getAttribute("currentTableNr")));
                produsService.startComanda(String.valueOf(request.getSession().getAttribute("lastOrderNr")),(Integer) request.getSession().getAttribute("currentTableNr"));
            } else {
            request.getSession().setAttribute("lastOrderNr",comandaService.getIdComanda(6, (Integer) request.getSession().getAttribute("currentTableNr")));
                    }
        Suma suma = sumaService.getSuma(String.valueOf(String.valueOf(request.getSession().getAttribute("lastOrderNr"))));
        result.addObject("suma",suma);
        return result;
    }

    @RequestMapping("/comanda")
    public ModelAndView listComanda(HttpServletRequest request) {
        ModelAndView result = new ModelAndView("/comanda");
        Collection<ProdusComandat> produseComandate = produsComandatService.listAll(String.valueOf(request.getSession().getAttribute("lastOrderNr")));
        result.addObject("produseComandate",produseComandate);
        Suma suma = sumaService.getSuma(String.valueOf(String.valueOf(request.getSession().getAttribute("lastOrderNr"))));
        result.addObject("suma",suma);
        return result;
    }

    @RequestMapping("/abandon")
    public ModelAndView abandon(HttpServletRequest request) {
        comandaService.anulComanda(String.valueOf(String.valueOf(request.getSession().getAttribute("lastOrderNr"))), (Integer) request.getSession().getAttribute("currentTableNr"));
        return new ModelAndView("/?tableId=" + request.getSession().getAttribute("currentTableNr"));
    }

    @RequestMapping(value = "/finish")
    public ModelAndView finish(HttpServletRequest request) {
        comandaService.finishComanda(String.valueOf(String.valueOf(request.getSession().getAttribute("lastOrderNr"))), (Integer) request.getSession().getAttribute("currentTableNr"));
        return new ModelAndView("finish");
    }

    @RequestMapping(value = "/")
        public ModelAndView index(HttpServletRequest request,@RequestParam int tableId) {
        request.getSession().setAttribute("currentTableNr",tableId);
        return new ModelAndView("index");
    }

    @RequestMapping("/new")
    public ModelAndView newStart(HttpServletRequest request) {
        return new ModelAndView("/?tableId=" + request.getSession().getAttribute("currentTableNr"));
    }

    @RequestMapping(value = "/produs")
    public ModelAndView prdus() {
        return new ModelAndView("produs");
    }
}