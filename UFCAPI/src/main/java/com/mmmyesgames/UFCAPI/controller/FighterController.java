package com.mmmyesgames.UFCAPI.controller;

import com.mmmyesgames.UFCAPI.entity.Fighter;
import com.mmmyesgames.UFCAPI.service.FighterService;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ufc")
public class FighterController {

    @Autowired
    private FighterService fighterService;
    @PostMapping("/fighter")
    public Fighter saveFighter(@RequestBody Fighter fighter) {
        return fighterService.addFighter(fighter);
    }

    @GetMapping("/fighter")
    public List<Fighter> getAllFighters() {
        return fighterService.getAllFighters();
    }

    @GetMapping("/fighter/{id}")
    public ResponseEntity<?> getFighterById(@PathVariable Integer id) {
        Fighter fighter = fighterService.getFighterById(id);

        if (fighter == null) {
            // This will print explicitly in your browser if the database search fails
            return ResponseEntity.status(404).body("Error: Fighter with ID " + id + " was not found in the database.");
        }

        return ResponseEntity.ok(fighter);
    }

    @GetMapping("/fighter/player/{name}")
    public List<Fighter> getFightersByPlayerName(@PathVariable String name) {
        return fighterService.getFightersByPlayerName(name);
    }

//    @PutMapping("/fighter/{id}")
//    public Fighter updateFighter(@PathVariable Long id, @RequestBody Fighter fighter) {
//        return fighterService.updateFighter(id, fighter);
//    }

    @DeleteMapping("/fighter/{id}")
    public void deleteFighter(@PathVariable Integer id) {
        fighterService.deleteFighter(id);
    }

}
