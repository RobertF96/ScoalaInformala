package service;

import domain.hotel.Hotel;

import java.util.Collection;

public interface HotelServiceInterface {

    public String validateAndRemoveHotel(Hotel hotel);

    public Collection<Hotel> getHotels();

    public Hotel findByName(String name);

    public String validateAndAddHotel(Hotel hotel);
}