package com.riwi.vacants.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.vacants.entity.Vacant;

@Repository
public interface VacantRepositorie extends JpaRepository<Vacant,Long>{
    
}
