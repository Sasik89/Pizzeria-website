package sebastian.sas.pizzeria.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sebastian.sas.pizzeria.dto.PizzaDTO;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Order {

    private int id;
    private User user;
    private PizzaDTO pizza;
    private LocalDateTime date;

    public Order(int id, User user, PizzaDTO pizza, LocalDateTime date) {
        this.id = id;
        this.user = user;
        this.pizza = pizza;
        this.date = LocalDateTime.now();
    }
}
