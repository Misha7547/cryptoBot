package com.skillbox.cryptobot.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="subscribers")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String uuid;

    @Column(name = "id_user")
    private int idUser;

    @Column(name = "price_User")
    private int priceUser;

}
