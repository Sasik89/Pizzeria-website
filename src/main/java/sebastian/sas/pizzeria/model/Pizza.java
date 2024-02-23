package sebastian.sas.pizzeria.model;

import lombok.Data;

import java.util.List;

@Data
public class Pizza {

    private String name;
    private String size;
    private List<String> toppings;

    public Pizza(String name, String size, List<String> toppings) {
        this.name = name;
        this.size = size;
        this.toppings = toppings;
    }

    public Pizza() {
    }
}
