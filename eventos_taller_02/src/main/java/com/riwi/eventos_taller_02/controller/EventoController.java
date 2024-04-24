package com.riwi.eventos_taller_02.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.eventos_taller_02.entity.Evento;
import com.riwi.eventos_taller_02.servicies.EventoService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/events")
@AllArgsConstructor
public class EventoController {
    
    @Autowired
    private final EventoService objEventoService;

    @GetMapping
    public ResponseEntity<List<Evento>> getAll(){
        return ResponseEntity.ok(this.objEventoService.getAllEvents());
    }


    @PostMapping
    public ResponseEntity<Evento> agregar(@RequestBody Evento objEvento){
        return ResponseEntity.ok(this.objEventoService.save(objEvento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,Boolean>> delete(@PathVariable String id){
        
    }
}
