package com.user.servies.UserService.com.user.entities;

import com.user.servies.UserService.com.user.external.services.Hotel;
import com.user.servies.UserService.com.user.external.services.Rating;
import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name ="micro_user")
public class User {

    @Id
    @Column(name ="id")
    private String id;

    @Column(name ="name")
    private String name;

    @Column(name ="E_mail")
    private String email;

    @Column(name ="about")
    private String about;

    @Transient
    private List <Rating> ratings;

}