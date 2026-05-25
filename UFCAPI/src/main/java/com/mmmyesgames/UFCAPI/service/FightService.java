package com.mmmyesgames.UFCAPI.service;

import com.mmmyesgames.UFCAPI.entity.Fight;
import com.mmmyesgames.UFCAPI.repository.FightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FightService {

    private final FightRepository fightRepository;

    @Autowired
    public FightService(FightRepository fightRepository) {
        this.fightRepository = fightRepository;
    }

    public Fight addFight(Fight fight) {
        //return FightDao.addFight(fight);
        return null;
    }

    public List<Fight> getAllFights() {
        return fightRepository.findAll();
    }
}
