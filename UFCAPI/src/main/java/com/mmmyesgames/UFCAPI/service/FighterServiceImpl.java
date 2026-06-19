package com.mmmyesgames.UFCAPI.service;

import com.mmmyesgames.UFCAPI.entity.Fighter;
import com.mmmyesgames.UFCAPI.repository.FighterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
public class FighterServiceImpl implements FighterService{

    @Autowired
    private FighterRepository fighterRepository;

    @Override
    public Fighter addFighter(Fighter fighter) {
        return fighterRepository.save(fighter);
    }

    @Override
    public Fighter getFighterById(Integer id) {
        return fighterRepository.findById(id).orElse(null);
    }

    @Override
    public Fighter getFighterByFirstNameAndLastName(String firstName, String lastName) {
        return fighterRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public Fighter updateFighter(Integer id, Fighter fighter) {
        Fighter existingFighter = fighterRepository.findById(fighter.getId()).orElse(null);
        if (existingFighter != null) {
            existingFighter.setFirstName(fighter.getFirstName());
            existingFighter.setLastName(fighter.getLastName());
            return fighterRepository.save(existingFighter);
        }
        return null;

    }

    @Override
    public void deleteFighter(Integer id) {
        fighterRepository.deleteById(id);
    }

    @Override
    public List<Fighter> getAllFighters() {
        return fighterRepository.findAll();
    }

    @Override
    public List<Fighter> getFightersByPlayerName(String name) {
        return List.of();
    }
}
