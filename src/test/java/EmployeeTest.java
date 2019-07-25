import domain.person.Employee;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmployeeTest {

    @Test
    public void createClient() {

        long id = 1;
        String cnp = "352451422";
        String firstName = "Alex";
        String lastName = "Balint";
        int age = 32;
        String peoplePhone = "0145245785";
        long cash = 150;
        Employee employee = new Employee(id, cnp, firstName, lastName, age, cash);
        assertEquals(employee.getId(), id);
        assertEquals(employee.getFirstName(), firstName);
        assertEquals(employee.getLastName(), lastName);
        assertEquals(employee.getAge(), age);
        assertEquals(employee.getCash(), cash);
    }
}