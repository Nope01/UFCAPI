package com.mmmyesgames.UFCAPI.repository;

import com.mmmyesgames.UFCAPI.entity.Player;
import com.mmmyesgames.UFCAPI.projection.PlayerProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {


    @Query("select p from Player p where p.firstName = ?1")
    Player findByFirstName(String firstName);

    @Query("select p from Player p where p.lastName = ?1")
    Player findByLastName(String lastName);

    @Query("select p from Player p where p.id != 0")
    List<PlayerProjection> findAllProjectedBy();


    @Transactional
    @Modifying
    @Query("update Player p set p.score = ?1 where p.id = ?2")
    int updateScoreById(int score, Integer id);
}
