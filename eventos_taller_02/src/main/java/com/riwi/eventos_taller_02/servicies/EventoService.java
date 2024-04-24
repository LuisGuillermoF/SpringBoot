package com.riwi.eventos_taller_02.servicies;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.riwi.eventos_taller_02.entity.Evento;
import com.riwi.eventos_taller_02.repository.EventoRepository;
import com.riwi.eventos_taller_02.servicies.abtract_service.EventoIService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EventoService implements EventoIService{

    @Autowired
    private final EventoRepository objEventoRepository;

    @Override
    public List<Evento> getAllEvents() {
        return this.objEventoRepository.findAll();
    }

    @Override
    public Page<Evento> getAllPages(int page, int size) {
        if (page < 0) {
            page = 0;
        }
        Pageable objPageable = PageRequest.of(page, size);

        return this.objEventoRepository.findAll(objPageable);
    }

    @Override
    public Evento save(Evento objEvento) {
        return this.objEventoRepository.save(objEvento);
    }

    @Override
    public Evento getEventoById(String id) {
        return this.objEventoRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean delete(String id) {
        Evento objEvento = this.objEventoRepository.findById(id).orElse(null);
        if (objEvento != null) {
            this.objEventoRepository.delete(objEvento);
            return true;
        }
        return false;
    }

    @Override
    public Evento update(Evento objEvento) {
        return this.objEventoRepository.save(objEvento);
    }

    
}
