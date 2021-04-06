package com.duydoanx.film.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Gender {

    @Id
    @Column(name = "gender_id")
    private int genderId;

    private String gender;

    @JsonBackReference("person-gender")
    @OneToMany(mappedBy = "gender")
    private List<Person> persons;

    public Gender(String gender) {
        this.gender = gender;
    }
}
