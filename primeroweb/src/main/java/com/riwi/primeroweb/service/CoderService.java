package com.riwi.primeroweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.primeroweb.entity.coder;
import com.riwi.primeroweb.repository.CoderRepository;

@Service
public class CoderService {
    //@autowired registra la inyeccion de dependencias en Spring BOOT
    @Autowired
    private CoderRepository obCoderRepository;

    public List<coder> findAll(){
        //Validaciones ecepsiones etc
        return this.obCoderRepository.findAll();
    }

    //Metodo para crear un nuevo coder , se hace uso del repositorio y del metodo save, el cual se encarga de insertar en la base de datos
    public coder create (coder objCoder){
        return this.obCoderRepository.save(objCoder);
    }
}
