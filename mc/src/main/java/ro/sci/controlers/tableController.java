package ro.sci.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class tableController {

	@RequestMapping("")
	public ModelAndView index() {
		return new ModelAndView("index");
	}
}
