package com.riwi.primeroweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    public Page<coder> findAllPaginate(int page, int size){
        //Validar que la pagina no sea menor a 0
        if (page < 0 ) {
            page = 0;
        }
        //crear la paginacion
        org.springframework.data.domain.Pageable objPage = PageRequest.of(page, size);

        return this.obCoderRepository.findAll(objPage);
        
    }

    //Metodo para crear un nuevo coder , se hace uso del repositorio y del metodo save, el cual se encarga de insertar en la base de datos
    public coder create (coder objCoder){
        return this.obCoderRepository.save(objCoder);
    }

    //Metodo para eliminar un coder (deleteById)
    public void delete(Long id){
        //llamar al repositorio
        this.obCoderRepository.deleteById(id);
    }

    //Metodo para obtener la id

    public coder finById(Long id){
        //Buscar un coder por id y en casa de que no lo encuentre retorna un null
        return this.obCoderRepository.findById(id).orElse(null);
    }

    //metodo para actualizar un coder
    public coder update(Long id,coder coder){
        //Buscar el coder por id
        coder objCoder  = this.finById(id);

        //verificamos que el coder exista
        if (objCoder == null) return null;

        //actualizmosa el coder viejo

        objCoder = coder;

        return this.obCoderRepository.save(objCoder);
        
    }
}
