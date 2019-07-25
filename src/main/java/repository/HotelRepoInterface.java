package repository;

import domain.hotel.Hotel;

public interface HotelRepoInterface extends RepoInterface {

    void add(Hotel hotel);

    void removeHotel(String name);

    Hotel findByName(String name);
}