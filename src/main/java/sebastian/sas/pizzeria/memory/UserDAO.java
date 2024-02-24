package sebastian.sas.pizzeria.memory;

import org.springframework.stereotype.Repository;
import sebastian.sas.pizzeria.exceptions.UserAlreadyExistException;
import sebastian.sas.pizzeria.model.Address;
import sebastian.sas.pizzeria.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDAO implements IUserDAO{

    private final List<User> users = new ArrayList<>();

    public UserDAO(){
        users.add(new User("Sebastian", "Sas", "sasik1", "sasik1", new Address("Brzezówka", "171", "33-230", "Szczucin"), User.Role.USER));
        users.add(new User("Sebastian", "Sas", "admin", "admin123", new Address("Brzezówka", "171", "33-230", "Szczucin"), User.Role.ADMIN));
    }

    public List<User> getUsers() {
        return users;
    }
    @Override
    public void addUser(User user) {
        for(User userFomDB : this.users){
            if(userFomDB.getLogin().equals(user.getLogin()) && userFomDB.getName().equals(user.getName()) && userFomDB.getSurname().equals(user.getSurname())){
                throw new UserAlreadyExistException();
            }
        }
        this.users.add(new User(user.getName(), user.getSurname(), user.getLogin(), user.getPassword(), user.getAddress(), user.getRole()));
    }
    public Optional<User> getLogin(String login){
        for(User user : users){
            if(user.getLogin().equals(login)){
                return Optional.of(user);
            }
        }
        return null;
    }
}
