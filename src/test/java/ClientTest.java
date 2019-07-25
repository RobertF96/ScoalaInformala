import domain.person.Client;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ClientTest {

    @Test
    public void createClient() {

        long id = 1;
        String cnp = "352451422";
        String firstName = "Alex";
        String lastName = "Balint";
        int age = 32;
        String peoplePhone = "0145245785";
        Client client = new Client(id, cnp, firstName, lastName, age, peoplePhone);
        assertEquals(client.getId(), id);
        assertEquals(client.getFirstName(), firstName);
        assertEquals(client.getLastName(), lastName);
        assertEquals(client.getAge(), age);
        assertEquals(client.getPeoplePhone(), peoplePhone);
    }

}