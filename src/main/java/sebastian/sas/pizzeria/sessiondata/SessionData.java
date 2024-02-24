package sebastian.sas.pizzeria.sessiondata;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import sebastian.sas.pizzeria.model.Order;
import sebastian.sas.pizzeria.model.User;

@SessionScope
@Component
@Data
public class SessionData {


    private User user;
    private Order order;

    public void setUser(User user) {
        this.user = user;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
