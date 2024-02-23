package sebastian.sas.pizzeria.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Order {

    private int id;
    private User user;
    private Pizza pizza;

    public Order(int id, User user, Pizza pizza) {
        this.id = id;
        this.user = user;
        this.pizza = pizza;
    }
}
