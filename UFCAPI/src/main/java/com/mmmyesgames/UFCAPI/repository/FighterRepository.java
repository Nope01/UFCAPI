package com.mmmyesgames.UFCAPI.repository;

import com.mmmyesgames.UFCAPI.entity.Fighter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FighterRepository extends JpaRepository<Fighter, Integer> {

    @Query("select f from Fighter f where f.firstName = ?1 and f.lastName = ?2")
    Fighter findByFirstNameAndLastName(String firstName, String lastName);

    @Query("select f from Fighter f where f.pickedBy = ?1")
    List<Fighter> findByPickedBy(Long playerId);
}
