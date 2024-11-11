package com.user.servies.UserService.com.user.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@FeignClient(name="RATING-SERVICES")
public interface RatinggServices {

    // GET Rating
    @GetMapping("/rating/get-rating-userId/{userId}")
    List<Rating> getReting(@PathVariable("userId") String userId);

    //POST Rating
    @PostMapping("/rating/create")
    Rating saveRating(@RequestBody Rating rating);

    //UPDATE Rating
    @PutMapping("/rating/update")
    ResponseEntity<Rating> updateRating(@RequestBody Rating updatedRating);

    //DELETE Rating
    @DeleteMapping("/rating/delete/{ratingId}")
    ResponseEntity<Optional<Rating>> deleteRating(@PathVariable String ratingId);
}
