package com.user.servies.UserService.com.user.external.services;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="HOTEL-SERVICES")
public interface HotelServices {

    //GET Rating
    @GetMapping("/hotel/get-Single-Hotel/{hotelId}")
    Hotel getHotel(@PathVariable("hotelId") String hotelId);

    // POST Rating

    // PUT Rating

    // DELETE Rating
}
