package sebastian.sas.pizzeria.services;

public interface IAuthenticationService {

    public boolean logged(String username, String password);

    public void logout();

}
