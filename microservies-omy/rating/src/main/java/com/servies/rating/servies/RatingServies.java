package com.servies.rating.servies;

import com.servies.rating.entities.Rating;

import java.util.List;
import java.util.Optional;

public interface RatingServies {

   public Rating create(Rating rating);
   public List<Rating> getRatingsForAllHotel();
   public Optional<Rating> singleHotelRating(String id);
   public List<Rating>  getHotelRatingListByHostelId(String hotelId);
   public List<Rating> getHotelRatingListByUserId(String userId);
}
