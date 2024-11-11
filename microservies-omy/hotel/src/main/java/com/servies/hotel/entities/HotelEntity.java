package com.servies.hotel.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="hotels")
public class HotelEntity {

    @Id
    private String id;

    @Column(name ="name")
    private String  name;

    @Column(name ="location")
    private String location;

    @Column(name ="about")
    private String about;
}
