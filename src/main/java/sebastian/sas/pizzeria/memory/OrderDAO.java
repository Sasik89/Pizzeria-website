package sebastian.sas.pizzeria.memory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sebastian.sas.pizzeria.model.Order;
import sebastian.sas.pizzeria.model.Pizza;
import sebastian.sas.pizzeria.model.User;

import java.util.*;
@Component
public class OrderDAO implements IOrderDAO {

    @Autowired
    private IdSequence idSequence;

    private final List<Order> lista = new ArrayList<>();

    public void addOrder(User user, Pizza pizza) {
        this.lista.add(new Order(idSequence.getId(), user, pizza));
    }

    public void deleteOrder(int id) {
        Iterator<Order> iterator = this.lista.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                iterator.remove();
                return;
            }
        }
    }
}
