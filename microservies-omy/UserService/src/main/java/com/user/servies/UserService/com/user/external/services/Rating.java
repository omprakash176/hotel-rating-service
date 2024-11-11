package com.user.servies.UserService.com.user.external.services;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rating {
    private String ratingId;
    private String userid;
    private String hotelId;
    private Integer rating;
    private String feedback;
    private Hotel hotel;
}
