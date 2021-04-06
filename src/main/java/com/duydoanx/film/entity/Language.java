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
public class Language {

    @Id
    @Column(name = "language_id")
    private int languageId;

    @Column(name = "language_code")
    private String languageCode;

    @Column(name = "language_name")
    private String languageName;

    public Language(String languageCode, String languageName) {
        this.languageCode = languageCode;
        this.languageName = languageName;
    }
}
