package sebastian.sas.pizzeria.memory;

import sebastian.sas.pizzeria.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserDAO {
    public void addUser(User user);
    public List<User> getUsers();
    public Optional<User> getLogin(String username);

}
