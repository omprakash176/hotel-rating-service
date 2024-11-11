package com.user.servies.UserService.com.user.servies;

import com.user.servies.UserService.com.user.entities.User;
import com.user.servies.UserService.com.user.external.services.Rating;

import java.util.List;
import java.util.Optional;

public interface UserServies {

    User saveUser(User user);

    List<User> getallusers();

    User getUserById(String userId);

    public User updateUser(User userArg);

    public User deleteUser(String ratingId);

    public User getConsolidtedByUserId(String userId);

    public Rating updateRating(Rating rating);

    public Optional<Rating> deleteRating(String userId);
}
