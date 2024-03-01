package sebastian.sas.pizzeria.memory.inner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sebastian.sas.pizzeria.dto.PizzaDTO;
import sebastian.sas.pizzeria.memory.IOrderDAO;
import sebastian.sas.pizzeria.memory.IdSequence;
import sebastian.sas.pizzeria.model.Order;
import sebastian.sas.pizzeria.model.Pizza;
import sebastian.sas.pizzeria.model.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Repository
public class OrderDAO implements IOrderDAO {

    @Autowired
    private IdSequence idSequence;

    private final List<Order> lista = new ArrayList<>();

    public void addOrder(User user, PizzaDTO pizza) {
        this.lista.add(new Order(idSequence.getId(), user, pizza, LocalDateTime.now()));
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
