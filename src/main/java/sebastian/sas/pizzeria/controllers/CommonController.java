package sebastian.sas.pizzeria.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommonController {


    @RequestMapping(path={"/main"}, method = RequestMethod.GET)
    public String main(){
        return "redirect:/";
    }

    @RequestMapping(path="/contact", method = RequestMethod.GET)
    public String contact(){
        return "contact";
    }

    @RequestMapping(path="/sale", method = RequestMethod.GET)
    public String sale(){
        return "sale";
    }
    @RequestMapping(path="/delivery", method = RequestMethod.GET)
    public String delivery(){
        return "delivery";
    }

}
