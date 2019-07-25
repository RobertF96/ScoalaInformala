package service;

import domain.hotel.Hotel;
import repository.HotelRepoInterface;

import java.util.Collection;

public class HotelService implements HotelServiceInterface {

    HotelRepoInterface hotelRepository;

    public HotelService(HotelRepoInterface hotelRepository) {

        this.hotelRepository = hotelRepository;
    }

    @Override
    public String validateAndRemoveHotel(Hotel hotel) {
        if(hotel == null){
            return "Hotel Invalid";
        }

        if(hotelRepository.findByName(hotel.getName()) == null){
            return "No hotel";
        }

        hotelRepository.removeHotel(hotel.getName());
        return "Hotel removed";
    }

    @Override
    public Collection<Hotel> getHotels() {

        return hotelRepository.getAll();
    }

    @Override
    public Hotel findByName(String name) {

        return hotelRepository.findByName(name);
    }

    @Override
    public String validateAndAddHotel(Hotel hotel) {
        if (hotel == null) {
            return "Hotel invalid";
        }

        if (hotel.getName().length() > 20) {
            return "Please add a shorter name";
        }

        hotelRepository.add(hotel);
        return "All good";
    }

}