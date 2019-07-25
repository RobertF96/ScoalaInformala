package domain;

import lombok.Getter;

import java.util.Date;

@Getter
public class CheckInData {

    private Date checkInDate;
    private int peoplePhone;

    public CheckInData(Date checkInDate, int peoplePhone) {
        this.checkInDate = checkInDate;
        this.peoplePhone = peoplePhone;
    }
}