package com.mmmyesgames.UFCAPI.controller;

import com.mmmyesgames.UFCAPI.entity.Fight;
import com.mmmyesgames.UFCAPI.entity.Fighter;
import com.mmmyesgames.UFCAPI.service.FightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ufc/fight")
public class FightController {

    private static final String API_KEY = "bingus";

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
        if (apiKey == null || !apiKey.equals(API_KEY)) {
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
