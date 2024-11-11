package com.servies.hotel.servies;

import com.servies.hotel.entities.HotelEntity;
import com.servies.hotel.exceptions.ResourceNotFoundException;
import com.servies.hotel.repositories.HotelRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class HotelServiesImpl implements  HotelServies{

    @Autowired
    HotelRepository hotelRepository;

    private static final Logger logger = Logger.getLogger(HotelServiesImpl.class.getName());


    @Override
    public HotelEntity create(HotelEntity hotel) {
        return hotelRepository.save(hotel);

    }

    @Override
    public List<HotelEntity> getAll() {
        return  hotelRepository.findAll();
    }
    @Override
    public HotelEntity getHotel(String id) {
        return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel Given Id is not found  " + id));
    }

    @Override
    @Transactional
    public HotelEntity update(HotelEntity hotel) {
        if(hotelRepository.findById(hotel.getId())!=null)
        {
            hotelRepository.updateHotelById(hotel.getId(),hotel.getName(),hotel.getLocation(),hotel.getAbout());
            logger.info("record updated");

        }
        else
        {
            return hotelRepository.save(hotel);
        }
        return hotel;
    }

    @Override
    @Transactional
    public Optional<HotelEntity> deleteById(String hotelId) {
        Optional<HotelEntity> hotelEntity =hotelRepository.findById(hotelId);
        if(hotelEntity.isPresent())
        {
            hotelRepository.deleteById(hotelId);
        }
        return hotelEntity;
    }


}