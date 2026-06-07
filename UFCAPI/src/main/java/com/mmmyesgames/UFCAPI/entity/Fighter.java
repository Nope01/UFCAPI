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
    private int age;
    private int ranking;
    private boolean isChampion;
    private boolean isActive;
    private String imageLink;


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

    //TODO: add fighter tier to db and program
    //TODO: add fighters in our list to db
    //TODO: get fighters each person has picked


    public void populateFighter(ResultSet fighterResult) throws SQLException {
        this.setId(fighterResult.getLong("id"));
        this.setFirstName(fighterResult.getString("first_name"));
        this.setLastName(fighterResult.getString("last_name"));
        this.setWins(fighterResult.getInt("wins"));
        this.setLosses(fighterResult.getInt("losses"));
        this.setWeightClass(fighterResult.getString("weight_class"));
        this.setGender(fighterResult.getString("gender"));
        this.setCountry(fighterResult.getString("country"));
        this.setRanking(fighterResult.getInt("ranking"));
        this.setChampion(fighterResult.getBoolean("is_champion"));
        this.setActive(fighterResult.getBoolean("is_active"));
        this.setImageLink(fighterResult.getString("image_link"));
    }
    public boolean updateFighter(Connection connection) throws SQLException {
        String sql = "UPDATE fighter " +
                "SET wins = ?, " +
                "losses = ?, " +
                "weight_class = ?, " +
                "gender = ?, " +
                "country = ?, " +
                "age = ?, " +
                "ranking = ?, " +
                "is_champion = ?, " +
                "is_active = ?, " +
                "image_link = ? " +
                "WHERE first_name = ? AND last_name = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, this.getWins());
        preparedStatement.setInt(2, this.getLosses());
        preparedStatement.setString(3, this.getWeightClass());
        preparedStatement.setString(4, this.getGender());
        preparedStatement.setString(5, this.getCountry());
        preparedStatement.setInt(6, this.getAge());
        preparedStatement.setInt(7, this.getRanking());
        preparedStatement.setBoolean(8, this.getIsChampion());
        preparedStatement.setBoolean(9, this.getIsActive());
        preparedStatement.setString(10, this.getImageLink());

        preparedStatement.setString(11, this.getFirstName());
        preparedStatement.setString(12, this.getLastName());

        System.out.println("Updating fighter: " + this.getFirstName() + " " + this.getLastName());
        System.out.println("Rows updated: " + preparedStatement.executeUpdate());
        return true;
    }


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

    public int getRanking() { return ranking;}

    public boolean getIsChampion() { return isChampion;}

    public boolean getIsActive() { return isActive;}
    public String getImageLink() { return imageLink;}

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

    public void setRanking(int ranking) { this.ranking = ranking;}

    public void setChampion(boolean champion) { this.isChampion = champion;}

    public void setActive(boolean active) { this.isActive = active;}

    public void setImageLink(String imageLink) { this.imageLink = imageLink;}




}
