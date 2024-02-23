package sebastian.sas.pizzeria.memory;

import sebastian.sas.pizzeria.model.Order;
import sebastian.sas.pizzeria.model.Pizza;
import sebastian.sas.pizzeria.model.User;

import java.util.Iterator;

public interface IOrderDAO {

    public void addOrder(User user, Pizza pizza);
    public void deleteOrder(int id);

}
