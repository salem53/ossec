package com.sip.ams.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sip.ams.entities.Coach;

@Repository
public interface CoachRepository extends CrudRepository<Coach,Integer> {
// on peut ajouter des méthodes.
}
