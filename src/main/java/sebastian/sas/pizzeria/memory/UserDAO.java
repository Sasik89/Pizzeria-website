package sebastian.sas.pizzeria.memory;

import org.springframework.stereotype.Repository;
import sebastian.sas.pizzeria.model.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAO implements IUserDAO{

    private final List<User> users = new ArrayList<>();
    @Override
    public void addUser(User user) {
        this.users.add(new User(user.getName(), user.getSurname(), user.getLogin(), user.getPassword(), user.getAddress()));
    }
}
