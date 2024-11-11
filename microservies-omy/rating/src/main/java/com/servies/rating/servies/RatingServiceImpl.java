package com.servies.rating.servies;

import com.servies.rating.entities.Rating;
import com.servies.rating.rating.RatingRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingServiceImpl implements RatingServies {

    @Autowired
    private RatingRepository ratingRepository;


    @Override
    public Rating create(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getRatingsForAllHotel() {
        return ratingRepository.findAll();
    }

    @Override
    public Optional<Rating> singleHotelRating(String id) {
        return ratingRepository.findById(id);
    }

    @Override
    public List<Rating> getHotelRatingListByHostelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }

    @Override
    public List<Rating> getHotelRatingListByUserId(String userId) {
        return ratingRepository.findByUserid(userId);
    }

    @Transactional
    public Rating updateRating(Rating updatedRating) {
        // Find the existing rating
        Rating existingRating = ratingRepository.findById(updatedRating.getRatingId())
                .orElseThrow(() -> new RuntimeException("Rating not found"));

        // Update the fields
        existingRating.setUserid(updatedRating.getUserid());
        existingRating.setHotelId(updatedRating.getHotelId());
        existingRating.setRating(updatedRating.getRating());
        existingRating.setFeedback(updatedRating.getFeedback());

        // Save the updated rating
        return ratingRepository.save(existingRating);
    }

    @Transactional
    public void deleteRating(String ratingId) {
        // Check if the rating exists before attempting to delete it
        if (!ratingRepository.existsById(ratingId)) {
            throw new RuntimeException("Rating not found");
        }

        // Delete the rating
        ratingRepository.deleteById(ratingId);
    }
}