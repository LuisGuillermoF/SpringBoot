package com.riwi.primeroweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.primeroweb.entity.coder;
//@Reposiroty se encarga de toda la persistencia de los datos interactua directamente con la Base de datos
@Repository
//Extendemos de la interefaz de JPA para pbtener todos los metods del CRUD
public interface CoderRepository extends JpaRepository<coder,Long>{
    
}


