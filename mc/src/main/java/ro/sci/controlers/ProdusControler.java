package ro.sci.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ro.sci.meniu.Gama;
import ro.sci.meniu.Produs;
import ro.sci.meniu.ProdusComandat;
import ro.sci.services.GamaService;
import ro.sci.services.ProdusComandatService;
import ro.sci.services.ProdusService;

import java.util.Collection;

@Controller
public class ProdusControler {
    private static int lastIndex;
    private static int currentTableNr;
    @Autowired
    private ProdusService produsService;
    @Autowired
    private GamaService gamaService;
    @Autowired
    private ProdusComandatService produsComandatService;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView listGama(@RequestParam int id) {
        ModelAndView result = new ModelAndView("/list");
        Collection<Produs> produse = produsService.listProduse(String.valueOf(id));
        Gama gama = gamaService.getGama(id);
        result.addObject("produs", produse);
        result.addObject("gama",gama);
        lastIndex = id;
         return result;
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView refresh(@RequestParam int idProdus) {
        produsService.addProdusCom(idProdus);
        ModelAndView result = new ModelAndView("/list?id="+lastIndex);
       // Collection<Produs> produse = produsService.listProduse(String.valueOf(lastIndex));
     //   Gama gama = gamaService.getGama(lastIndex);
       // result.addObject("produs", produse);
       // result.addObject("gama",gama);
        return result;

    }
    @RequestMapping("/meniu")
    public void meniu() {
    ModelAndView result = new ModelAndView("/meniu");

}
    @RequestMapping("/comanda")
    public ModelAndView listComanda() {
        ModelAndView result = new ModelAndView("/comanda");
        Collection<ProdusComandat> produseComandate = produsComandatService.listAll();
        result.addObject("produseComandate",produseComandate);
        return result;

    }


    @RequestMapping(value = "/")
        public ModelAndView index(@RequestParam int tableId) {
        currentTableNr = tableId;
        return new ModelAndView("index");
        }
}