package com.hibernate.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="review")
public class Review {

    //define fields
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "comment")
    private String comment;

    //define constructor
    public Review(){}

    public Review(String comment ){
        this.comment=comment;
    }

    //define getter & setters

    //define tostring

    //annotate field
}