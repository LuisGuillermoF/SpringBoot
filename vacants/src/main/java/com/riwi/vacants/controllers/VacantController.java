package com.riwi.vacants.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.vacants.servicies.interfaces.IvacantService;
import com.riwi.vacants.utils.dto.request.VacancyRequest;
import com.riwi.vacants.utils.dto.response.VacantResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/vacants")
@AllArgsConstructor
public class VacantController {
    
    @Autowired
    private final IvacantService objIvacantService;

    @GetMapping
    public ResponseEntity<Page<VacantResponse>> getAll(@RequestParam(defaultValue = "1")int page,
    @RequestParam(defaultValue = "5")int size
    ){
        return ResponseEntity.ok(this.objIvacantService.getAll(page -1, size));
    };

    @PostMapping
    public ResponseEntity<VacantResponse> insert (@Validated @RequestBody VacancyRequest vacant){
        return ResponseEntity.ok(this.objIvacantService.create(vacant));
    }
}
