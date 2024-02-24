package sebastian.sas.pizzeria.model;

import lombok.*;

@Getter
@Setter
public class User {

    private String name;
    private String surname;
    private String login;
    private String password;
    private Role role;
    private Address address;


    public User(String username) {
        this.login = username;
    }

    public User(String name, String surname, String login, String password, Address address, Role role) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.address = address;
        this.role = Role.USER;
    }
    public User() {
    }
    public enum Role{
        ADMIN,
        USER
    }
}
