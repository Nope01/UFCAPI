package com.mmmyesgames.UFCAPI.entity;

import jakarta.persistence.*;

@Entity
@Table(name="fight")
public class Fight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    

}
