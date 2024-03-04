package com.skillbox.cryptobot.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "subscribers")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String uuid;

    @Column(name = "id_user")
    private int idUser;

    @Column(name = "price_user")
    private int priceUser;

}
