package sebastian.sas.pizzeria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sebastian.sas.pizzeria.memory.IUserDAO;
import sebastian.sas.pizzeria.model.User;
import sebastian.sas.pizzeria.sessiondata.SessionData;

@Controller
public class AuthenticationController {

    @Autowired
    SessionData sessionData;

    @Autowired
    IUserDAO userDAO;

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login2() {
        return "redirect:/login";
    }


    @RequestMapping(path = "/logout", method = RequestMethod.GET)
    public String logout() {
        return "redirect:/";
    }

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("register", new User());
        return "register";
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String register2(@ModelAttribute User user) {
        userDAO.addUser(user);
        System.out.println(user.getName());
        System.out.println(user.getSurname());
        System.out.println(user.getLogin());
        System.out.println(user.getPassword());
        System.out.println(user.getAddress().getCity());
        System.out.println(user.getAddress().getStreet());
        System.out.println(user.getAddress().getZipCode());
        System.out.println(user.getAddress().getNumberOfHouse());
        return "redirect:/";
    }
}