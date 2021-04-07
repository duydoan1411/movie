package com.duydoanx.film.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Keyword {

    @Id
    @Column(name = "keyword_id")
    private int keywordId;

    @Column(name = "keyword_name")
    private String keywordName;



    public Keyword(String keywordName) {
        this.keywordName = keywordName;
    }
}
