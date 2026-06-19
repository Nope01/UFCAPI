package com.mmmyesgames.UFCAPI.service;

import com.mmmyesgames.UFCAPI.entity.Fighter;

import java.util.List;

public interface FighterService {
    Fighter addFighter(Fighter fighter);
    Fighter getFighterById(Integer id);
    Fighter getFighterByFirstNameAndLastName(String firstName, String lastName);
    Fighter updateFighter(Integer id, Fighter fighter);
    void deleteFighter(Integer id);
    List<Fighter> getAllFighters();
    List<Fighter> getFightersByPlayerName(String name);
}
