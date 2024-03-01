package sebastian.sas.pizzeria.model;

import lombok.*;

@Getter
@Setter
public class User {

    private String name;
    private String surname;
    private String login;
    private String password;
    private String phoneNumber;
    private Role role;
    private Address address;


    public User(String username) {
        this.login = username;
    }

    public User(String name, String surname, String login, String password, String phoneNumber, Role role, Address address) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.role = Role.USER;
        this.address = address;
    }

    public User() {
    }
    public enum Role{
        ADMIN,
        USER
    }
}
