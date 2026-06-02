package com.mmmyesgames.UFCAPI.service;

import com.mmmyesgames.UFCAPI.dao.FighterDao;
import com.mmmyesgames.UFCAPI.entity.Fighter;
import com.mmmyesgames.UFCAPI.repository.FighterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FighterService {

    private final FighterRepository fighterRepository;

    @Autowired
    public FighterService(FighterRepository fighterRepository) {
        this.fighterRepository = fighterRepository;
    }

    public Fighter addFighter(Fighter fighter) {
        return FighterDao.addFighter(fighter);
    }

    public List<Fighter> getAllFighters() {
        //TODO: Implement in FighterDao
        return FighterDao.getAllFighters();
    }

    public Fighter getFighterById(Long id) {
        //TODO: Implement in FighterDao
        return FighterDao.getFighterById(id);
    }
}
