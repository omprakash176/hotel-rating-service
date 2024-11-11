package com.user.servies.UserService.com.user.servies;



import com.user.servies.UserService.com.user.entities.User;
import com.user.servies.UserService.com.user.external.services.Hotel;
import com.user.servies.UserService.com.user.external.services.HotelServices;
import com.user.servies.UserService.com.user.external.services.Rating;
import com.user.servies.UserService.com.user.external.services.RatinggServices;
import com.user.servies.UserService.com.user.response.ResourceNotFoundException;
import com.user.servies.UserService.com.user.servies.repository.UserRepositor;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserServiesImpl implements  UserServies {

    @Autowired
    private UserRepositor userRepositor;

    @Autowired
    HotelServices hotelServices;
    
    @Autowired
    RatinggServices ratinggServices;

    @Override
    public User saveUser(User user) {
        return  userRepositor.save(user);
    }

    @Override
    public List<User> getallusers() {
        return userRepositor.findAll();
    }

    @Override
    public User getUserById(String userId) {
        User user = userRepositor.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User Given Id is not found  " + userId));
        return user;
    }

    @Override
    public User getConsolidtedByUserId(String userId) {
        //get user from database with help of user Repository
        User user = userRepositor.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User Given Id is not found  " + userId));
       // Feign Client Interface method called, calling diffrent microservice
        List<Rating> reting = ratinggServices.getReting(user.getId());
        for(Rating rating : reting) {
            // Feign Client Interface method called,  calling diffrent microservice
            Hotel hotel = hotelServices.getHotel(rating.getHotelId());
            rating.setHotel(hotel);
        }
        user.setRatings(reting);

        return user;
    }

    @Transactional
    public User updateUser(User userArg) {
        User user = userRepositor.findById(userArg.getId()).orElseThrow(() -> new RuntimeException("User Not Found"));
        user.setId(userArg.getId());
        user.setAbout(userArg.getAbout());
        user.setName(userArg.getName());
        user.setEmail(userArg.getEmail());
        return userRepositor.save(user);
    }

    @Transactional
    public User deleteUser(String userId) {
        User user = userRepositor.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User Given Id is not found  " + userId));
       if(user!=null)
       {
           userRepositor.deleteById(user.getId());
       }
        return user;
    }

    public Rating updateRating(Rating rating){
        ResponseEntity<Rating> ratings =  ratinggServices.updateRating(rating);
        return ratings.getBody();
    }

    public Optional<Rating> deleteRating(String ratingId){
        ResponseEntity<Optional<Rating>> ratings =  ratinggServices.deleteRating(ratingId);

        return ratings.getBody();
    }

}
