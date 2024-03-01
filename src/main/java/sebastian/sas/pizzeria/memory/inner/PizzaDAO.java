package sebastian.sas.pizzeria.memory.inner;

import org.springframework.stereotype.Repository;
import sebastian.sas.pizzeria.memory.IPizzaDAO;
import sebastian.sas.pizzeria.model.Pizza;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class PizzaDAO implements IPizzaDAO {

    private final List<Pizza> pizzaList = new ArrayList<>();

    public PizzaDAO() {
        pizzaList.add(new Pizza("Margeritta", List.of("ser", "sos pomidorowy"), Map.of("SMALL", 17,"MEDIUM",23,"LARGE",32)));
        pizzaList.add(new Pizza("Tuńczyk", List.of("tuńczyk", "sos", "ser"), Map.of("SMALL", 21,"MEDIUM",30,"LARGE",41)));
        pizzaList.add(new Pizza("Salami", List.of("salami", "sos", "ser"), Map.of("SMALL", 21,"MEDIUM",30,"LARGE",40)));
        pizzaList.add(new Pizza("Wegetariańska", List.of("pierczarki", "papryka", "sos", "ser", "kukurydza"), Map.of("SMALL", 21,"MEDIUM",28,"LARGE",38)));
        pizzaList.add(new Pizza("Peperoni", List.of("salami", "peperoni", "sos", "ser"), Map.of("SMALL", 22,"MEDIUM",31,"LARGE",42)));
        pizzaList.add(new Pizza("Sałatkowa", List.of("oliwki", "pomidor", "cebula", "tuńczyk", "ogórek", "sos", "ser"), Map.of("SMALL", 24,"MEDIUM",35,"LARGE",45)));
        pizzaList.add(new Pizza("Farmerska", List.of("szynka", "boczek", "filet z kurczaka", "cebula", "czosnek", "pierczarki", "sos", "ser"), Map.of("SMALL", 25,"MEDIUM",34,"LARGE",45)));
        pizzaList.add(new Pizza("Mix", List.of("sos", "szynka", "boczek", "salami", "kukurydza", "pierczarki", "ser"), Map.of("SMALL", 22,"MEDIUM",30,"LARGE",40)));
        pizzaList.add(new Pizza("Diabelska", List.of("sos", "ser", "szynka", "salami", "cebula", "pierczarki", "oliwki", "papryka chili"), Map.of("SMALL", 23,"MEDIUM",34,"LARGE",44)));
        pizzaList.add(new Pizza("Chłopska", List.of("sos", "szynka", "pieczarki", "boczek", "cebula", "czosnek", "kiebłasa wiejska", "ser"), Map.of("SMALL", 24,"MEDIUM",34,"LARGE",45)));
        pizzaList.add(new Pizza("Meksykańska", List.of("sos", "ser", "karkówka", "cebula", "pieczarki", "czosnek", "oliwki", "papryka", "ser"), Map.of("SMALL", 24,"MEDIUM",33,"LARGE",43)));
        pizzaList.add(new Pizza("Hawajska", List.of("sos", "szynka", "ananas", "ser"), Map.of("SMALL", 20,"MEDIUM",29,"LARGE",38)));
        pizzaList.add(new Pizza("Serowa", List.of("sos", "ser mozzarella", "parmezan"), Map.of("SMALL", 22,"MEDIUM",31,"LARGE",42)));
        pizzaList.add(new Pizza("Parmeńska", List.of("sos", "szynka szwarcwaldzka", "pieczarki", "czosnek", "ser"), Map.of("SMALL", 25,"MEDIUM",35,"LARGE",45)));
        pizzaList.add(new Pizza("Super Kurczak", List.of("sos", "filet z kurczaka", "kukurydza", "pieczarki", "papryka", "cebula", "serser"), Map.of("SMALL", 24,"MEDIUM",34,"LARGE",43)));
        pizzaList.add(new Pizza("Chrupiący bekon", List.of("sos pieczarki","czosnek", "oregano", "boczek", "prażona cebulka", "ser"), Map.of("SMALL", 22,"MEDIUM",32,"LARGE",44)));
    }

    public List<Pizza> getPizzaList() {
        return pizzaList;
    }

    @Override
    public Optional<Map<String, Integer>> getMapPrice(String name, String size) {
        for(Pizza pizza: this.pizzaList){
            if(pizza.getName().equals(name) && pizza.getSize().equals(size)){
                return Optional.ofNullable(pizza.getPrice());
            }
        }
        return Optional.empty();
    }


    @Override
    public Optional<Pizza> getPizza(String name) {
        for(Pizza pizza : this.pizzaList){
            if(pizza.getName().equals(name)){
                return Optional.of(pizza);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Integer> getPriceViaNameAndSize(String name, String key) {
        for(Pizza pizza : this.pizzaList){
            if(pizza.getName().equals(name)){
                Integer price = pizza.getPrice().getOrDefault(key.replace(",",""),0);
                return Optional.ofNullable(price);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<List<String>> getAllToppings(String name) {
        for(Pizza pizza : this.pizzaList){
            if(pizza.getName().equals(name)){
                return Optional.ofNullable(pizza.getToppings());
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<String> showAllPrice(String name) {
        for(Pizza pizza: this.pizzaList){
            if(pizza.getName().equals(name)){
                return ("Mała: " + pizza.getPrice().get("SMALL") + ", Średnia: " + pizza.getPrice().get("MEDIUM") + ", Duża: " + pizza.getPrice().get("LARGE")).describeConstable();
            }
        }
        return Optional.empty();
    }
}
