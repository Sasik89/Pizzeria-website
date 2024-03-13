package sebastian.sas.pizzeria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sebastian.sas.pizzeria.exceptions.UserAlreadyExistException;
import sebastian.sas.pizzeria.memory.IUserDAO;
import sebastian.sas.pizzeria.model.User;
import sebastian.sas.pizzeria.services.IAuthenticationService;
import sebastian.sas.pizzeria.sessiondata.SessionData;

@Controller
public class AuthenticationController {

    @Autowired
    SessionData sessionData;
    @Autowired
    IAuthenticationService authenticationService;
    @Autowired
    IUserDAO userDAO;

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("sessionDate", sessionData);
        return "login";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String login, @RequestParam String password, Model model) {
        if (authenticationService.logged(login, password)) {
            sessionData.setLogin(login);
            model.addAttribute("sessionData", sessionData);
            System.out.println(sessionData.getLogin());
            return "redirect:/";
        }
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
        try{
            userDAO.addUser(user);
            user.setRole(User.Role.USER);
            System.out.println(user.getName());
            System.out.println(user.getSurname());
            System.out.println(user.getLogin());
            System.out.println(user.getPassword());
            System.out.println(user.getAddress().getCity());
            System.out.println(user.getAddress().getStreet());
            System.out.println(user.getAddress().getZipCode());
            System.out.println(user.getAddress().getNumberOfHouse());
            System.out.println(user.getRole());
            return "redirect:/";
        } catch (UserAlreadyExistException e) {
            e.printStackTrace();
            return "redirect:/register";
        }
    }
}