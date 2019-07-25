package domain.hotel;

public enum Availability {

    AVAILABLE("free", true),
    NOT_AVAILABLE("booked", false);


    private final String message;
    private final boolean custom;


    Availability(String message, boolean custom) {
        this.message = message;
        this.custom = custom;
    }
}
