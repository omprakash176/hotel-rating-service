package com.servies.hotel.repositories;

import com.servies.hotel.entities.HotelEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HotelRepository extends JpaRepository<HotelEntity, String> {

    @Modifying
    @Transactional
    @Query("UPDATE HotelEntity h SET h.name = :name, h.location = :location, h.about = :about WHERE h.id = :id")
    int updateHotelById(
            @Param("id") String id,
            @Param("name") String name,
            @Param("location") String location,
            @Param("about") String about
    );
}
