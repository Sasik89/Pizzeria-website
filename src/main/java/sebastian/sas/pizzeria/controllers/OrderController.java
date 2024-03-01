package sebastian.sas.pizzeria.controllers;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sebastian.sas.pizzeria.dto.PizzaDTO;
import sebastian.sas.pizzeria.memory.IOrderDAO;
import sebastian.sas.pizzeria.memory.IPizzaDAO;
import sebastian.sas.pizzeria.model.Pizza;
import sebastian.sas.pizzeria.model.User;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
public class OrderController {

    @Resource
    IOrderDAO orderDAO;
    @Resource
    IPizzaDAO pizzaDAO;

    @GetMapping("/")
    public String showOrderForm(Model model) {
        model.addAttribute("pizza", new Pizza());
        model.addAttribute("pizzaList", pizzaDAO.getPizzaList());
        return "index";
    }

    @PostMapping("/")
    public String submitOrder(@ModelAttribute Pizza pizza, @RequestParam("name") String pizzaName,
                              @RequestParam("size") String pizzaSize,
                              @RequestParam("toppings") List<String> selectedToppings) {
        try {
            orderDAO.addOrder(new User("dupa"), new PizzaDTO(
                    pizzaName,
                    pizzaSize,
                    pizzaDAO.getAllToppings(pizzaName).get(),
                    selectedToppings,
                    pizzaDAO.getPriceViaNameAndSize(pizzaName,pizzaSize).get()));
            return "redirect:/";
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return "redirect:/";
        } finally {
            System.out.println("Zamówiona pizza: " + pizzaName + " Składniki: " + pizzaDAO.getAllToppings(pizzaName).get() + " Rozmiar: " + pizzaSize + " Dodatkowe składniki: " + selectedToppings + " Cena: " + pizzaDAO.getPriceViaNameAndSize(pizzaName,pizzaSize).get());
        }
    }

    @GetMapping("/order")
    public String showCart() {
        return "order";
    }

}
