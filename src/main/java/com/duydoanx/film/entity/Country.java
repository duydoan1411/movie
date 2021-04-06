package com.duydoanx.film.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Country {
    @Id
    @Column(name = "country_id")
    private int countryId;

    @Column(name = "country_iso_code")
    private String countryIsoCode;

    @Column(name = "country_name")
    private String countryName;

    public Country(String countryIsoCode, String countryName) {
        this.countryIsoCode = countryIsoCode;
        this.countryName = countryName;
    }
}
