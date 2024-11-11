package com.servies.hotel.servies;

import com.servies.hotel.entities.HotelEntity;

import java.util.List;
import java.util.Optional;

public interface HotelServies {

    HotelEntity create(HotelEntity hotel);

    HotelEntity update(HotelEntity hotel);

    Optional<HotelEntity> deleteById(String hotelId);

    List<HotelEntity> getAll();

    HotelEntity getHotel(String id);
}
