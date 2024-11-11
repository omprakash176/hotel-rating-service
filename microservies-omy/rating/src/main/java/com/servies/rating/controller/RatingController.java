package com.servies.rating.controller;


import com.servies.rating.entities.Rating;
import com.servies.rating.servies.RatingServiceImpl;
import com.servies.rating.servies.RatingServies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingServiceImpl ratingServies;

    @PostMapping("/create")
    public ResponseEntity<Rating> create(@RequestBody  Rating rating) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingServies.create(rating));
    }

    @GetMapping("/get-all-rating")
    public ResponseEntity<List<Rating>> getRatings() {
        return ResponseEntity.status(HttpStatus.OK).body(ratingServies.getRatingsForAllHotel());
    }

    @GetMapping("/get-rating-hotel-Id/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId) {
        return ResponseEntity.status(HttpStatus.OK).body(ratingServies.getHotelRatingListByHostelId(hotelId));
    }

    @GetMapping("/get-rating-userId/{userId}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId) {
        return ResponseEntity.status(HttpStatus.OK).body(ratingServies.getHotelRatingListByUserId(userId));
    }

    @PutMapping("/update")
    public ResponseEntity<Rating> updateRating(@RequestBody Rating updatedRating) {
        Rating rating = ratingServies.updateRating(updatedRating);
        return ResponseEntity.ok(rating);
    }

    @DeleteMapping("/delete/{ratingId}")
    public ResponseEntity<Optional<Rating>> deleteRating(@PathVariable String ratingId) {

        Optional<Rating> rating=  ratingServies.singleHotelRating(ratingId);
        if(rating.isPresent())
        {
            ratingServies.deleteRating(ratingId);
        }
        return  ResponseEntity.status(HttpStatus.OK).body(rating);
    }
}
