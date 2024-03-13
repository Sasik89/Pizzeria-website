package sebastian.sas.pizzeria.controllers;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sebastian.sas.pizzeria.dto.PizzaDTO;
import sebastian.sas.pizzeria.memory.IOrderDAO;
import sebastian.sas.pizzeria.memory.IPizzaDAO;
import sebastian.sas.pizzeria.memory.IdSequence;
import sebastian.sas.pizzeria.model.Order;
import sebastian.sas.pizzeria.model.Pizza;
import sebastian.sas.pizzeria.model.User;
import sebastian.sas.pizzeria.sessiondata.SessionData;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
public class OrderController {

    @Resource
    IOrderDAO orderDAO;
    @Resource
    IPizzaDAO pizzaDAO;
    @Autowired
    IdSequence idSequence;

    @Autowired
    SessionData sessionData;

    @GetMapping("/")
    public String showOrderForm(Model model) {
        model.addAttribute("sessionData", sessionData);
        model.addAttribute("pizza", new Pizza());
        model.addAttribute("pizzaList", pizzaDAO.getPizzaList());
        return "index";
    }

    @PostMapping("/")
    public String submitOrder(@ModelAttribute Pizza pizza, @RequestParam("name") String pizzaName,
                              @RequestParam("size") String pizzaSize,
                              @RequestParam("toppings") List<String> selectedToppings) {
        try {
            User user = new User(sessionData.getLogin());
            PizzaDTO pizzaDTO = new PizzaDTO(pizzaName,
                    pizzaSize,
                    pizzaDAO.getAllToppings(pizzaName).get(),
                    selectedToppings,
                    pizzaDAO.getPriceViaNameAndSize(pizzaName, pizzaSize).get());
            orderDAO.addOrder(user, pizzaDTO);
            LocalDateTime date = LocalDateTime.now();
            sessionData.addOrder(new Order(idSequence.getId(), user, pizzaDTO, date));
            return "redirect:/";
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return "redirect:/";
        } finally {
            System.out.println("Zamówiona pizza: " + pizzaName + " Składniki: " + pizzaDAO.getAllToppings(pizzaName).get() + " Rozmiar: " + pizzaSize + " Dodatkowe składniki: " + selectedToppings + " Cena: " + pizzaDAO.getPriceViaNameAndSize(pizzaName, pizzaSize).get());
        }
    }

    @GetMapping("/order")
    public String showCart(Model model) {
        model.addAttribute("sessionData", sessionData);
        System.out.println(sessionData.getLogin());
        return "order";
    }
}
