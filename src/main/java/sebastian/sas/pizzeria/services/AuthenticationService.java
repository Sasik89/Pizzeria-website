package sebastian.sas.pizzeria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sebastian.sas.pizzeria.memory.IUserDAO;
import sebastian.sas.pizzeria.model.User;
import sebastian.sas.pizzeria.sessiondata.SessionData;

import java.util.Optional;
@Service
public class AuthenticationService implements IAuthenticationService{

    @Autowired
    SessionData sessionData;

    @Autowired
    IUserDAO userDAO;

    @Override
    public boolean logged(String login, String password) {
        Optional<User> userBox = this.userDAO.getLogin(login);
        for(User user : userDAO.getUsers()){
            if(login.equals(user.getLogin()) && password.equals(user.getPassword())){
                this.sessionData.setUser(userBox.get());
                return true;
            }
        }
        return false;
    }
    }
