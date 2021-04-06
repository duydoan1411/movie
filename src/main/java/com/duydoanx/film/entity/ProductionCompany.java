package com.duydoanx.film.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "production_company")
public class ProductionCompany {

    @Id
    @Column(name = "company_id")
    private int companyId;

    @Column(name = "company_name")
    private String companyName;

    @ManyToMany
    @JoinTable(
            name = "movie_company",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    @JsonIgnoreProperties("productionCompanies")
    private List<Movie> movies;

    public ProductionCompany(String companyName) {
        this.companyName = companyName;
    }
}
