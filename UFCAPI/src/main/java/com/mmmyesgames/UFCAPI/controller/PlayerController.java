package com.mmmyesgames.UFCAPI.controller;

import com.mmmyesgames.UFCAPI.entity.Player;
import com.mmmyesgames.UFCAPI.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ufc")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/player")
    public Player savePlayer(@RequestBody Player player) {
        return playerService.addPlayer(player);
    }

    @GetMapping("/player")
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/player/{id}")
    public Player getPlayerById(@RequestParam Integer id) {
        return playerService.getPlayerById(id);
    }

    @GetMapping("/player/{id}/fighters")
    public List<Player> getFightersByPlayerId(@PathVariable Integer id) {
        return playerService.getAllPlayers();
    }

    @DeleteMapping("player/{id}")
    public void deletePlayer(@PathVariable Integer id) {
        playerService.deletePlayer(id);
    }


}
