package domain.person;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;

@EqualsAndHashCode
@Getter
public class Client extends Person implements Serializable {


    private String peoplePhone;

    public Client(long id, String cnp, String firstName, String lastName, Integer age, String peoplePhone) {
        super(id, cnp, firstName, lastName, age);
        this.peoplePhone = peoplePhone;
    }

}
