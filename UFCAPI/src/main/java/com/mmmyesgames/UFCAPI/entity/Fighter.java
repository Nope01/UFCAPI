package com.mmmyesgames.UFCAPI.entity;

import jakarta.persistence.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Entity
@Table(name = "fighter")
public class Fighter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private int wins;

    private int losses;

    private String weightClass;

    private String gender;

    private String country;

    @Column(nullable = false)
    private int age;



    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public String getWeightClass() {
        return weightClass;
    }

    public String getGender() {
        return gender;
    }

    public String getCountry() {
        return country;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public void setLastName(String name) {
        this.lastName = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public void setWeightClass(String weightClass) {
        this.weightClass = weightClass;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public boolean checkIfFighterExists(Connection connection) throws SQLException {
        String sql = "SELECT * FROM fighter WHERE first_name = ? AND last_name = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, this.getFirstName());
        preparedStatement.setString(2, this.getLastName());

        ResultSet results = preparedStatement.executeQuery();

        //If next exists, then the query returned a value, so that means the fighter already exists.
        if (results.next()) {
            System.out.println("Fighter exists already: " + results.getString(2));
            return true;
        }
        else {
            System.out.println("Fighter doesn't exist. Adding now...");
            return false;
        }
    }
}
