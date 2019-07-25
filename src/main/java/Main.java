import domain.CheckInData;
import domain.Order;
import domain.Reservation;
import domain.hotel.Availability;
import domain.hotel.Hotel;
import domain.hotel.Room;
import domain.person.Client;
import domain.person.Employee;
import domain.person.Owner;
import domain.person.Person;
import repository.ClientRepo;
import repository.ClientRepoInterface;
import repository.HotelRepo;
import repository.HotelRepoInterface;
import service.ClientService;
import service.HotelService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static javax.script.ScriptEngine.FILENAME;

public class Main {

    public static void main(String[] args) throws ParseException, InterruptedException {
        partIIIandIV();
        partVAndVI();
        useMap();
        addRoomsAndSortRooms();
        partVII();
        partVIII(2000);
    }

    private static void partVIII(int numberOfClients) throws ParseException, InterruptedException {
        Person owner = new Owner(1, "2554477885", "Claudiu", "Verde", 40, 14000);
        Hotel hotel = new Hotel(1, "Montana", "Swiss", owner, "5stars");

        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date date1 = format.parse("14-12-2018");
        Date date2 = format.parse("11-10-2019");
        Random random = new Random();
        int low = 1;
        int high = 10;

        HotelThread hotelThread = new HotelThread(hotel);
        Thread t1 = new Thread(hotelThread);
        t1.start();

        while (numberOfClients > 0) {
            Date randomDate = new Date(ThreadLocalRandom.current().nextLong(date1.getTime(), date2.getTime()));
            int randomPeoplePhone = random.nextInt(high - low) + low;
            ClientThread clientThread = new ClientThread(hotel, new CheckInData(randomDate, randomPeoplePhone));
            Thread t2 = new Thread(clientThread);
            t2.start();
            numberOfClients--;
        }
    }

    private static void partVII() throws ParseException {
        Person owner = new Owner(1, "2554477885", "Claudiu", "Verde", 40, 14000);

        Hotel hotel = new Hotel(1, "Montana", "Swiss", owner, "5stars");

        Person employeeA = new Employee(1, "123456789", "Floarea", "Lalea", 18, 2950);
        Person employeeB = new Employee(2, "554788854", "Gelu", "Bocanc", 25, 3000);
        Person employeeC = new Employee(30, "332225445", "Vasile", "Alboi", 22, 5000);
        hotel.addEmployee(employeeA);
        hotel.addEmployee(employeeB);
        hotel.addEmployee(employeeC);

        List<Person> allEmployees = hotel.getAllEmployees();
        Integer sum = allEmployees.stream().map(Person::getAge).reduce(0, (subtotal, element) -> subtotal + element);
        int average = sum / allEmployees.size();

        Stream.generate(Math::random)
                .limit(10)
                .max(Double::compareTo).ifPresent(n -> System.out.println("Number max" + n));

        Client client = new Client(1, "352451422", "Alex", "Balint", 32, "0145245785");
        DateFormat format = new SimpleDateFormat("dd-mm-yyyy", Locale.ENGLISH);
        Date startDate = format.parse("21-06-2019");
        Date endDate = format.parse("22-09-2019");
        Reservation account = new Reservation.Builder(1)
                .ofClient(client)
                .atStartDate(startDate)
                .atEndDate(endDate)
                .build();
    }

    private static void useMap() {
        Person owner = new Owner(1, "2554477885", "Claudiu", "Verde", 40, 14000);
        Hotel hotelA = new Hotel(1, "Montana", "Swiss", owner, "5stars");

        Room roomA = new Room(1, 12, "Ocean", 1000L, 2, 1, "ocean view", Availability.AVAILABLE);
        Room roomB= new Room(2, 32, "Mountain", 20L, 1, 2, "mountain view", Availability.AVAILABLE);
        Room roomC = new Room(3, 22, "Pool", 100L, 2, 1, "pool view", Availability.NOT_AVAILABLE);
        hotelA.addRoom(roomA);
        hotelA.addRoom(roomB);
        hotelA.addRoom(roomC);

        Hotel hotelB = new Hotel(2, "Bosphor", "Turkey", owner, "The best hotel");
        Room roomAB = new Room(1, 1, "", 120L, 2, 3, "descriere", Availability.NOT_AVAILABLE);
        Room roomBB = new Room(2, 2, "", 2220L, 4, 3, "descriere", Availability.AVAILABLE);
        Room roomCB = new Room(3, 3, "", 500L, 1, 3, "descriere", Availability.NOT_AVAILABLE);
        hotelB.addRoom(roomAB);
        hotelB.addRoom(roomBB);
        hotelB.addRoom(roomCB);

        HotelRepoInterface hotelRepo = new HotelRepo();
        HotelService hotelService = new HotelService(hotelRepo);

        //add
        hotelService.validateAndAddHotel(hotelA);
        hotelService.validateAndAddHotel(hotelB);

        //list
        Collection<Hotel> hotels = hotelService.getHotels();

        // create Map
        Map<Long, List<Room>> hotelsWithRooms = hotels.stream().collect(Collectors.toMap(Hotel::getId, Hotel::getRooms));
    }

    /**
     * add 10 rooms and sort them
     */
    private static void addRoomsAndSortRooms() {
        Person owner = new Owner(1, "2554477885", "Claudiu", "Verde", 40, 14000);
        System.out.println(owner);

        Hotel hotel = new Hotel(1, "Montana", "Swiss", owner, "5stars");

        Room roomA = new Room(1, 1, "roomA", 120, 2, 1, "", Availability.AVAILABLE);
        Room roomB = new Room(2, 2, "roomB", 135, 2, 2, "", Availability.AVAILABLE);
        Room roomC = new Room(3, 3, "roomC", 85, 2, 1, "", Availability.NOT_AVAILABLE);
        Room roomD = new Room(4, 4, "roomD", 210, 2, 2, "", Availability.NOT_AVAILABLE);
        Room roomE = new Room(5, 5, "roomE", 250, 2, 1, "", Availability.NOT_AVAILABLE);
        Room roomF = new Room(6, 6, "roomF", 100, 2, 3, "", Availability.NOT_AVAILABLE);
        Room roomG = new Room(7, 7, "roomG", 50, 1, 2, "", Availability.NOT_AVAILABLE);
        Room roomH = new Room(8, 8, "roomH", 120, 2, 2, "", Availability.NOT_AVAILABLE);
        Room roomI = new Room(9, 9, "roomI", 160, 2, 3, "", Availability.NOT_AVAILABLE);
        Room roomJ = new Room(10, 10, "roomJ", 1200, 2, 3, "", Availability.NOT_AVAILABLE);
        hotel.addRoom(roomA);
        hotel.addRoom(roomB);
        hotel.addRoom(roomC);
        hotel.addRoom(roomD);
        hotel.addRoom(roomE);
        hotel.addRoom(roomF);
        hotel.addRoom(roomG);
        hotel.addRoom(roomH);
        hotel.addRoom(roomI);
        hotel.addRoom(roomJ);

        hotel.sortRoomsByName(Order.DESC);
    }


    private static void partVAndVI() {
        ClientRepoInterface clientRepo = new ClientRepo();
        ClientService clientService = new ClientService(clientRepo);
        clientService.readFromFile("in.txt");
        clientService.writeToFile("out.txt");
    }

    /**
     * adds, removes and search hotels
     */
    public static void partIIIandIV() {
        Person owner = new Owner(1, "2554477885", "Claudiu", "Verde", 40, 14000);
        System.out.println(owner);

        Hotel hotelA = new Hotel(1, "Montana", "Swiss", owner, "5stars");

        Person employeeA = new Employee(1, "3456872321", "Alin", "Pago", 30, 2500);
        Person employeeB = new Employee(2, "2547877554", "Daniel", "Marcu", 25, 2560);
        hotelA.addEmployee(employeeA);
        hotelA.addEmployee(employeeB);

        Room roomA = new Room(1, 12, "", 1000L, 2, 1, "descriere", Availability.AVAILABLE);
        Room roomB = new Room(2, 32, "", 20L, 1, 2, "descriere", Availability.AVAILABLE);
        Room roomC = new Room(3, 22, "", 100L, 2, 1, "descriere", Availability.NOT_AVAILABLE);
        hotelA.addRoom(roomA);
        hotelA.addRoom(roomB);
        hotelA.addRoom(roomC);

        Hotel hotelB = new Hotel(2, "Bosphor", "Turkey", owner, "The best hotel");

        Person employeeAB = new Employee(3, "21235465", "Ioan", "Cristea", 45, 3524);
        Person employeeBB = new Employee(4, "12121212", "Bogdan", "Malini", 55, 210000);
        hotelB.addEmployee(employeeAB);
        hotelB.addEmployee(employeeBB);

        Room roomAB = new Room(4, 10, "Parang", 100, 2, 2, "Nice view", Availability.NOT_AVAILABLE);
        Room roomBB = new Room(5, 20, "Oituz", 200, 2, 2, "Jacuzzi", Availability.AVAILABLE);
        Room roomCB = new Room(6, 30, "Bucegi", 300, 2, 1, "Altitude", Availability.NOT_AVAILABLE);
        hotelB.addRoom(roomAB);
        hotelB.addRoom(roomBB);
        hotelB.addRoom(roomCB);

        System.out.println(hotelA);
        System.out.println(hotelB);

        HotelRepoInterface hotelRepo = new HotelRepo();
        HotelService hotelService = new HotelService(hotelRepo);

        //add
        hotelService.validateAndAddHotel(hotelA);
        hotelService.validateAndAddHotel(hotelB);

        //list
        Collection<Hotel> hotels = hotelService.getHotels();

        // give me the information about Hotel with the name X
        Hotel hotelByName = hotelService.findByName("Bosphor");
        System.out.println(hotelByName.toString());

        //give me information about Employee Z
        for (Person employee : hotelByName.getAllEmployees()) {
            System.out.println(employee.toString() + " works for hotel " + hotelByName.getName());
        }

        //remove
        hotelService.validateAndRemoveHotel(hotelA);
    }

}