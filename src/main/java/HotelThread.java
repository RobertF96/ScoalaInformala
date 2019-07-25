import domain.CheckInData;
import domain.hotel.Hotel;

public class HotelThread implements Runnable {
    private Hotel hotel;

    public HotelThread(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(3000);
                while (hotel.hasCheckInData()) {
                    synchronized (hotel) {
                        System.out.println("Hotel informations");
                        int peopleCheckedInToday = 3;
                        int peopleCheckedInAfter10 = 2;
                        Thread.sleep(2000);
                        CheckInData checkInData = hotel.pollCheckInData();

                        if (UtilDate.isToday(checkInData.getCheckInDate())) {
                            peopleCheckedInToday += checkInData.getPeoplePhone();

                            if (UtilDate.isBeforeLunch(checkInData.getCheckInDate())) {
                                peopleCheckedInAfter10 += checkInData.getPeoplePhone();
                            }
                        }

                        System.out.println("Hotel informations: Done");
                        System.out.println("People checked in today : " + peopleCheckedInToday);
                        System.out.println("People checked in after 10 : " + peopleCheckedInAfter10);
                    }
                }
            } catch (InterruptedException intEx) {

            }
        }
    }
}