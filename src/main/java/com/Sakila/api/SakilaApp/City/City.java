package com.Sakila.api.SakilaApp.City;

import com.Sakila.api.SakilaApp.Country.Country;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@Entity
@Table(name = "city")
@AllArgsConstructor
@NoArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Long id;

    @Column(name = "city", nullable = false)
    @NotBlank
    private String city;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    public City(String city, Country country) {
        this.city = city;
        this.country = country;
    }
}
