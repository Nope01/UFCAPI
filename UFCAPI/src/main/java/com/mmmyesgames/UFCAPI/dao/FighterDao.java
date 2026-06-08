package com.mmmyesgames.UFCAPI.dao;

import com.mmmyesgames.UFCAPI.entity.Fighter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FighterDao {

    public static final String jdbcUrl = "jdbc:postgresql://192.168.0.18:5432/ufc";
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
                fighter.updateFighter(connection);
                connection.close();

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
            connection.close();

            while (fighters.next()) {
                Fighter fighter = new Fighter();
                fighter.populateFighter(fighters);
                fighterList.add(fighter);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return fighterList;
    }

    public static Fighter getFighterByFirstNameAndLastName(String name) {
        try {
            Connection connection = getConnection();

            String[] nameParts = name.split("-");
            String firstName = nameParts[0];
            String lastName = nameParts[1];
            String sql = "SELECT * FROM fighter WHERE first_name = ? AND last_name = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            ResultSet fighterResult = preparedStatement.executeQuery();
            connection.close();

            if (!fighterResult.next()) {
                return null;
            }
            else {
                Fighter fighter = new Fighter();
                fighter.populateFighter(fighterResult);
                return fighter;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Fighter> getFightersByPlayerName(String firstName) {
        try {
            //Get id for name, then all fighters belonging to that id
            Connection connection = getConnection();
            String idSql = "SELECT id FROM player WHERE first_name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(idSql);
            preparedStatement.setString(1, firstName);
            ResultSet playerIdResult = preparedStatement.executeQuery();

            if (!playerIdResult.next()) {
                return null;
            }
            else {
                long playerId = playerIdResult.getLong(1);
                String fightersSql = "SELECT * FROM fighter WHERE picked_by = ?";
                PreparedStatement preparedStatement2 = connection.prepareStatement(fightersSql);
                preparedStatement2.setLong(1, playerId);
                ResultSet fighterResult = preparedStatement2.executeQuery();

                connection.close();

                if (!fighterResult.next()) {
                    return null;
                }
                else {
                    List<Fighter> fighterList = new ArrayList<>();

                    while (fighterResult.next()) {
                        Fighter fighter = new Fighter();
                        fighter.populateFighter(fighterResult);
                        fighterList.add(fighter);
                    }
                    return fighterList;
                }
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
                fighter.populateFighter(fighterResult);
                return fighter;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
