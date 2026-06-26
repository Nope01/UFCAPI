package com.mmmyesgames.UFCAPI.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString(exclude = "pickedBy")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "fighter")
public class Fighter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Builder.Default
    private String lastName = "Bingus";

    @Builder.Default
    private int age = 0;

    @Builder.Default
    private int wins = 0;

    @Builder.Default
    private int losses = 0;

    @Column(name = "weight_class")
    @Builder.Default
    private String weightClass = "nuggetweight";

    @Builder.Default
    private String gender = "blob";

    @Builder.Default
    private String country = "Dingusland";

    @Column(name = "is_champion")
    @JsonProperty("isChampion")
    @Builder.Default
    private boolean isChampion = false;

    @Builder.Default
    private int ranking = -1;

    @Column(name = "is_active")
    @JsonProperty("isActive")
    @Builder.Default
    private boolean isActive = true;

    //Default removed
    @JoinColumn(name = "picked_by")
    @ManyToOne
    @JsonBackReference
    private Player pickedBy;

    @Column(name = "image_link")
    @Builder.Default
    private String imageLink = "https://i.imgur.com/0000000.png";
}