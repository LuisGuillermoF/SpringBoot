package com.riwi.vacants.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.vacants.entity.Company;

@Repository
public interface CompanyRepositorie extends JpaRepository<Company,String>{
    
}
