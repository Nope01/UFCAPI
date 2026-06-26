package com.mmmyesgames.UFCAPI.service;

import com.mmmyesgames.UFCAPI.entity.Player;
import com.mmmyesgames.UFCAPI.projection.PlayerProjection;
import com.mmmyesgames.UFCAPI.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player getPlayerById(Integer id) {
        return playerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public Player getPlayerByFirstName(String firstName) {
        return playerRepository.findByFirstName(firstName);
    }

    @Override
    public Player getPlayerByLastName(String lastName) {
        return playerRepository.findByLastName(lastName);
    }

    @Override
    public Player updatePlayer(Integer id, Player player) {
        return playerRepository.save(player);
    }

    @Override
    public List<PlayerProjection> getPlayersByScoreDescending() {
        return playerRepository.findAllProjectedBy().stream().sorted((p1, p2) -> p2.getScore() - p1.getScore()).toList();
    }

    @Override
    public void deletePlayer(Integer id) {
        playerRepository.deleteById(id);
    }
}
