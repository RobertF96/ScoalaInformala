package domain.person;

import lombok.Getter;

@Getter
public class Employee extends Person {

    private long cash;


    public Employee(long id, String cnp, String firstName, String lasName, int age, long cash) {
        super(id,cnp, firstName, lasName, age);
        this.cash = cash;
    }

    @Override
    public String toString() {
        return super.toString() + ", cash:" + cash;
    }
}

