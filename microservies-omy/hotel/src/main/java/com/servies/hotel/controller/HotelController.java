package com.servies.hotel.controller;



import com.servies.hotel.entities.HotelEntity;
import com.servies.hotel.servies.HotelServies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    HotelServies hotelServies;

    @PostMapping("/create")
    public ResponseEntity<HotelEntity> createHotel(@RequestBody HotelEntity hotelEntity) {
        HotelEntity savedHotel = hotelServies.create(hotelEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedHotel);
    }

    @GetMapping("/get-Single-Hotel/{hotelId}")
    public ResponseEntity<HotelEntity> getHotel(@PathVariable String hotelId)
    {
        HotelEntity savedHotel = hotelServies.getHotel(hotelId);
        return ResponseEntity.status(HttpStatus.OK).body(savedHotel);
    }

    @GetMapping("/get-all-hotel")
    public ResponseEntity <List<HotelEntity>> getHotelList()
    {
        List<HotelEntity> hotelEntities = hotelServies.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(hotelEntities);
    }

   @PutMapping("/updateHotel")
   public ResponseEntity <HotelEntity> updateHotel(@RequestBody HotelEntity hotelEntity)
   {
       HotelEntity savedHotel = hotelServies.update(hotelEntity);
       return ResponseEntity.status(HttpStatus.CREATED).body(savedHotel);
   }

    @DeleteMapping("/deleteHotel/{hotelId}")
    public ResponseEntity <HotelEntity> deleteHotelById(@PathVariable String hotelId)
    {
        HotelEntity savedHotel = hotelServies.getHotel(hotelId);
        if(null!=savedHotel)
        {
            hotelServies.deleteById(hotelId);
            return ResponseEntity.status(HttpStatus.OK).body(savedHotel);
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
