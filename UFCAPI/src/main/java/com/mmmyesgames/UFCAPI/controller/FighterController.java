package com.mmmyesgames.UFCAPI.controller;

import com.mmmyesgames.UFCAPI.entity.Fighter;
import com.mmmyesgames.UFCAPI.service.FighterService;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ufc/fighter")
public class FighterController {
    private final FighterService fighterService;

    @Autowired
    public FighterController(FighterService fighterService) {
        this.fighterService = fighterService;
    }

    @PostMapping("/add")
    public ResponseEntity<Fighter> addFighter(
            @RequestBody Fighter fighter,
            @RequestHeader("ufc-api-key") String apiKey) {

        Dotenv dotenv = Dotenv.load();
        String ufcApiKey = dotenv.get("UFC_API_KEY");

        System.out.println("Adding fighter: " + fighter.getFirstName());
        if (apiKey == null || !apiKey.equals(ufcApiKey)) {
            return ResponseEntity.badRequest().build();
        }

        Fighter newFighter = fighterService.addFighter(fighter);
        return ResponseEntity.ok(newFighter);
    }

    @GetMapping("/all")
    public List<Fighter> getAllFighters() {
        return fighterService.getAllFighters();
    }

    @GetMapping("/{id}")
    public Fighter getFighterById(@PathVariable Long id) {
        return fighterService.getFighterById(id);
    }

    @RequestMapping("/test")
    public String test() {
        return "I smash you brotha";
    }



}
