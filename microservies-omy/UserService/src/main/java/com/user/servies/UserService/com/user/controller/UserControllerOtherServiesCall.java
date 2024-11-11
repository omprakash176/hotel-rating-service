package com.user.servies.UserService.com.user.controller;

import com.user.servies.UserService.com.user.entities.User;
import com.user.servies.UserService.com.user.external.services.Rating;
import com.user.servies.UserService.com.user.servies.UserServies;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.Optional;

@RestController
@RequestMapping("/user-rating-hotel-ms")
public class UserControllerOtherServiesCall {

    private static final Logger logger = LoggerFactory.getLogger(UserControllerOtherServiesCall.class);

    private Integer retryCount = 1;

    @Autowired
    private UserServies userServies;

    @GetMapping("/user/{userId}")
//    @CircuitBreaker(name="ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
//    @Retry (name="ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
    @RateLimiter(name="userRateLimiter",fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getConsolidtedUserData(@PathVariable String userId) {
        retryCount++;
        logger.info("Re-try count : {} for @Retry (name=\"ratingHotelBreaker\",fallbackMethod = \"ratingHotelFallback\")", retryCount);
        User user = userServies.getConsolidtedByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex) {
        logger.info("Fallback is executed because service is down: " + ex.getMessage());
        User user = User.builder().email("dummy@gmail.com")
                .name("Dummy")
                .about("This user is created dummy because some service is down")
                .id("157")
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }


    @PutMapping("/rating-update")
    public ResponseEntity<Rating> updateRating(@RequestBody Rating updatedRating) {
        Rating rating = userServies.updateRating(updatedRating);
        return ResponseEntity.ok(rating);
    }

    @DeleteMapping("/rating-delete/{ratingId}")
    public ResponseEntity<Rating> deleteRating(@PathVariable String ratingId) {
        Optional<Rating> deleteRating=  userServies.deleteRating(ratingId);
        return ResponseEntity.status(HttpStatus.OK).body(deleteRating.get());
    }
}
