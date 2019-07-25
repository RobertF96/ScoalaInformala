package domain.hotel;

import domain.CheckInData;
import domain.IdIs;
import domain.Order;
import domain.person.Person;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

@Getter
public class Hotel extends IdIs {

    private String name;
    private String address;
    private List<Room> rooms;
    private List<Person> employees;
    private String description;
    private Person owner;
    private Queue<CheckInData> checkIns= new LinkedList();;

    public Hotel(long id, String name, String address, Person owner, String description) {
        super(id);
        this.name = name;
        this.description = description;
        this.owner = owner;
        this.address = address;
        this.employees = new ArrayList<>();
        this.rooms = new ArrayList<>();
    }

    public Hotel(long id, String name, String address, List<Room> rooms, List<Person> employees, Person owner) {
        super(id);
        this.name = name;
        this.address = address;
        this.rooms = rooms;
        this.employees = employees;
        this.owner = owner;
    }

    public void addEmployee(Person employee) {

        employees.add(employee);
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void removeRoom(Room room) {

        rooms.remove(room);
    }

    public void sortRoomsByName(Order order) {
        if (Order.ASC.equals(order))
            rooms = rooms.stream().sorted(Comparator.comparing(Room::getName)).collect(Collectors.toList());
        else if (Order.DESC.equals(order)) {
            rooms = rooms.stream().sorted((o1, o2) -> o2.getName().compareTo(o1.getName())).collect(Collectors.toList());
        }
    }

    public List<Room> getAllRooms() {

        return rooms;
    }

    public List<Person> getAllEmployees() {

        return employees;
    }

    public void addCheckInData(CheckInData checkInData)
    {
        checkIns.add(checkInData);
    }

    public CheckInData pollCheckInData(){

        return checkIns.poll();
    }

    public boolean hasCheckInData(){

        return !checkIns.isEmpty();
    }

    @Override
    public String toString() {
        return "Hotel " + name + " " + address + " with description " + description + " has " + rooms.size() + " rooms and " + employees.size() + " employees";
    }
}