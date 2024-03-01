package sebastian.sas.pizzeria.memory;

import sebastian.sas.pizzeria.model.Pizza;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IPizzaDAO {

    public Optional<Pizza> getPizza(String name);
    public Optional<Integer> getPriceViaNameAndSize(String name, String size);
    public Optional<List<String>> getAllToppings(String name);
    public Optional<String> showAllPrice(String name);
    public List<Pizza> getPizzaList();
    public Optional<Map<String, Integer>> getMapPrice(String name, String size);
}
