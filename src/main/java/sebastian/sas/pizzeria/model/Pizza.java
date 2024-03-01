package sebastian.sas.pizzeria.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Pizza {

    private String name;
    private String size;
    private List<String> toppings;
    private List<String> additionalToppings;
    private Map<String, Integer> price;

    public Pizza(String name, List<String> toppings, Map<String, Integer> price) {
        this.name = name;
        this.toppings = toppings;
        this.price = price;
    }

    public Pizza(String name, String size, List<String> toppings, List<String> additionalToppings, Map<String, Integer> price) {
        this.name = name;
        this.size = size;
        this.toppings = toppings;
        this.additionalToppings = additionalToppings;
        this.price = price;
    }

    public Pizza() {
    }

    public Map<String, Integer> getPrice() {
        return price;
    }
}
