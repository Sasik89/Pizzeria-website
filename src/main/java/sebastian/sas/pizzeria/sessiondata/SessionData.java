package sebastian.sas.pizzeria.sessiondata;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import sebastian.sas.pizzeria.model.Order;

import java.util.ArrayList;
import java.util.List;

@SessionScope
@Component
@Data
public class SessionData {

    String login;
    List<Order> order = new ArrayList<>();

    public SessionData(String login, List<Order> order) {
        this.login = login;
        this.order = order;
    }

    public SessionData(String login) {
        this.login = login;
    }
    public SessionData() {
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getLogin() {
        return login;
    }
    public void addOrder(Order order){
        this.order.add(order);
    }
}
