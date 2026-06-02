package com.mmmyesgames.UFCAPI.controller;

import com.mmmyesgames.UFCAPI.entity.Fight;
import com.mmmyesgames.UFCAPI.entity.Fighter;
import com.mmmyesgames.UFCAPI.service.FightService;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ufc/fight")
public class FightController {


    private final FightService fightService;

    @Autowired
    public FightController(FightService fightService) {
        this.fightService = fightService;
    }

    @PostMapping("/add")
    public ResponseEntity<Fight> addFight(
            @RequestBody Fight fight,
            @RequestHeader("ufc-api-key") String apiKey) {

        System.out.println("Adding fight: " + fight.getWinner());

        Dotenv dotenv = Dotenv.load();
        String ufcApiKey = dotenv.get("UFC_API_KEY");

        if (apiKey == null || !apiKey.equals(ufcApiKey)) {
            return ResponseEntity.badRequest().build();
        }

        Fight newFight = fightService.addFight(fight);
        return ResponseEntity.ok(newFight);
    }

    @GetMapping("/all")
    public List<Fight> getAllFights() {
        return fightService.getAllFights();
    }
}
