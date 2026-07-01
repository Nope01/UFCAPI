package com.mmmyesgames.UFCAPI.service;

import com.mmmyesgames.UFCAPI.entity.Player;
import com.mmmyesgames.UFCAPI.projection.PlayerProjection;

import java.util.List;

public interface PlayerService {
    Player addPlayer(Player player);
    Player getPlayerById(Integer id);
    List<Player> getAllPlayers();
    Player getPlayerByFirstName(String firstName);
    Player getPlayerByLastName(String lastName);
    Player updatePlayer(Integer id, Player player);
    List<PlayerProjection> getPlayersByScoreDescending();
    int getPlayerScore(Integer id);
    int updatePlayerScore(Integer id, int score);
    void deletePlayer(Integer id);

}
