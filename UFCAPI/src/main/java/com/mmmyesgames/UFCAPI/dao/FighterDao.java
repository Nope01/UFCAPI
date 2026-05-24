package com.mmmyesgames.UFCAPI.dao;

import com.mmmyesgames.UFCAPI.entity.Fighter;

import java.sql.*;

public class FighterDao {

    public static Fighter addFighter(Fighter fighter) {

        try {
            String jdbcUrl = "jdbc:postgresql://localhost:5432/UFC";
            String username = "postgres";
            String password = "nope";

            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            }

            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
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
            e.printStackTrace();
        }

        return fighter;
    }
}
