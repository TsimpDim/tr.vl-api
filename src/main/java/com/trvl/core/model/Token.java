package com.trvl.core.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Token {
    @Id
    private String token;

    @JoinColumn(name = "id")
    @OneToOne
    private User user;
}