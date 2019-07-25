package domain.person;


import domain.IdIs;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Person extends IdIs {
    @EqualsAndHashCode.Include
    private String cnp;
    @EqualsAndHashCode.Exclude
    private String firstName;
    @EqualsAndHashCode.Exclude
    private String lastName;
    @EqualsAndHashCode.Exclude
    private int age;


    public Person(long id,String cnp, String firstName, String lastName, int age) {
        super(id);
        this.cnp = cnp;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ",age:" + age;
    }
}
