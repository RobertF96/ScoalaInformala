import domain.CheckInData;
import domain.CheckInData;
import domain.hotel.Hotel;

public class ClientThread implements Runnable {
    private Hotel hotel;
    private CheckInData checkInData;

    public ClientThread(Hotel hotel, CheckInData checkInData) {
        this.hotel = hotel;
        this.checkInData = checkInData;
    }

    public void run() {
        System.out.println("Client begin");
        if (checkInData.getCheckInDate() == null) {
            System.out.println("The check-in must be null");
        } else if (checkInData.getPeoplePhone() == 0) {
            System.out.println("The people number needs to be > 0");
        } else {
            System.out.println("All good");
            synchronized (hotel) {
                hotel.addCheckInData(checkInData);
                    System.out.println("Type a check-in date!");
            }
        }
        System.out.println("Client stop");
    }
}