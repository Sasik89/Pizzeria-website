package sebastian.sas.pizzeria.memory;

import org.springframework.stereotype.Component;

@Component
public class IdSequence {
    private int id = 0;
    public int getId(){
        return ++id;
    }
}
