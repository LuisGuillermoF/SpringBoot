package com.riwi.primeroweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.riwi.primeroweb.entity.coder;
import com.riwi.primeroweb.service.CoderService;

@Controller
//Crear la ruta donde se activara este controlador
@RequestMapping("/")
public class CoderController {
    @Autowired
    private CoderService obCoderService;

    //Metodo para mostrar la vista y enviarle toda la lista de coders

    @GetMapping
    public String shoViewCoder(Model objModel) {
        List<coder> listCoders = this.obCoderService.findAll();

        //Cargamos la lista en el modelo
        objModel.addAttribute("listCoders",listCoders);
        return "viewCoders";
    }

    //metodo para mostrar la vista del formulario y ademas enviar una instancia de coder vacia
    @GetMapping("/from")
    public String showViemForm(Model model){
        model.addAttribute("coder", new coder());
        model.addAttribute("action", "/create-coder");
        return "viewForm";
    }

    //metodo para recibir toda la informacion del formulario
    //ModelAttribute lo utilizamos para recibir informacion de la vista
    @PostMapping("create-coder")
    public String createCoder(@ModelAttribute coder objCoder){
        this.obCoderService.create(objCoder);
        return "redirect:/viewCoders";
    }
}
