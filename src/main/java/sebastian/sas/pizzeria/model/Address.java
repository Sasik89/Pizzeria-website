package sebastian.sas.pizzeria.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String street;
    private String numberOfHouse;
    private String zipCode;
    private String city;
}
