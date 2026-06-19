package com.mmmyesgames.UFCAPI.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString(exclude = "fighters")
@Builder
@Table(name = "player")
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    @Id
    @Column(nullable = false)
    private Integer id;

    private String firstName;
    private String lastName;
    private int score;

    @OneToMany(mappedBy = "pickedBy")
    @JsonManagedReference
    private List<Fighter> fighters;
}
