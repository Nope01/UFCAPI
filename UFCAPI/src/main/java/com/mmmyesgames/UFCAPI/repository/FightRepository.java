package com.mmmyesgames.UFCAPI.repository;

import com.mmmyesgames.UFCAPI.entity.Fight;
import com.mmmyesgames.UFCAPI.entity.Fighter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FightRepository extends JpaRepository<Fight, Long> {
}