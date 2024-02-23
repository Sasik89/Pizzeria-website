package sebastian.sas.pizzeria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import sebastian.sas.pizzeria.memory.IOrderDAO;
import sebastian.sas.pizzeria.model.Pizza;
import sebastian.sas.pizzeria.model.User;

@Controller
public class OrderController {

    @Autowired
    IOrderDAO orderDAO;

    @GetMapping("/")
    public String showOrderForm(Model model) {
        model.addAttribute("pizza", new Pizza());
        return "index";
    }

    @PostMapping("/")
    public String submitOrder(@ModelAttribute Pizza pizza) {
        orderDAO.addOrder(new User("dupa"), new Pizza(pizza.getName(), pizza.getSize(), pizza.getToppings()));
        System.out.println("Ordered pizza: " + pizza.getName() + pizza.getSize() + ", Toppings: " + pizza.getToppings());
        return "redirect:/";
    }

    @GetMapping("/order")
    public String showCart() {
        return "order";
    }

}
