package sebastian.sas.pizzeria.model;

import lombok.Data;
import lombok.Getter;

@Data
public class User {

    private String username;
    private String password;
    public User(String username) {
        this.username = username;
    }

}
