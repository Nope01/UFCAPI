package com.mmmyesgames.UFCAPI.dao;

import com.mmmyesgames.UFCAPI.entity.Fighter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FighterDao {

    public static final String jdbcUrl = "jdbc:postgresql://localhost:5432/UFC";
    public static final String username = "postgres";
    public static final String password = "nope";


    //Shared connection method for all queries
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(jdbcUrl, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static Fighter addFighter(Fighter fighter) {

        try {
            Connection connection = getConnection();

            if (fighter.checkIfFighterExists(connection)) {
                return null;
            }
            String sql = "INSERT INTO fighter (first_name, last_name) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, fighter.getFirstName());
            preparedStatement.setString(2, fighter.getLastName());

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return fighter;
    }

    public static List<Fighter> getAllFighters() {
        List<Fighter> fighterList = new ArrayList<>();
        try {
            Connection connection = getConnection();

            String sql = "SELECT * FROM fighter";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet fighters = preparedStatement.executeQuery();
            while (fighters.next()) {
                Fighter fighter = new Fighter();
                fighter.setId(fighters.getLong("id"));
                fighter.setFirstName(fighters.getString("first_name"));
                fighter.setLastName(fighters.getString("last_name"));
                fighterList.add(fighter);
            }

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return fighterList;
    }

    public static Fighter getFighterById(Long id) {
        try {
            Connection connection = getConnection();

            String sql = "SELECT * FROM fighter WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, id);

            ResultSet fighterResult = preparedStatement.executeQuery();
            connection.close();

            if (!fighterResult.next()) {
                return null;
            }
            else {
                Fighter fighter = new Fighter();
                fighter.setId(fighterResult.getLong("id"));
                fighter.setFirstName(fighterResult.getString("first_name"));
                fighter.setLastName(fighterResult.getString("last_name"));
                return fighter;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
