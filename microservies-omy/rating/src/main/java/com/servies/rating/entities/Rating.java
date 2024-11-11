package com.servies.rating.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity // Add this annotation
@Table(name ="rating")
public class Rating {

    @Id // Also mark the primary key field
    @Column(name = "rating_id")
    private String ratingId;

    @Column(name = "user_id")
    private String userid;

    @Column(name = "hotel_id")
    private String hotelId;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "feedback")
    private String feedback;
}
