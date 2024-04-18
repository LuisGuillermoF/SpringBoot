package com.riwi.primeroweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;    
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String shoViewCoder(Model objModel,
    @RequestParam(defaultValue = "1") int page,
    @RequestParam(defaultValue = "2") int size) {
        Page<coder> listCoders = this.obCoderService.findAllPaginate(page -1 ,size);

        //Cargamos la lista en el modelo
        objModel.addAttribute("listCoders",listCoders);
        objModel.addAttribute("currentPage", page);
        objModel.addAttribute("totalPage", listCoders.getTotalPages());
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
        return "redirect:/";
    }

    //Crear un controlador para eliminar recivira el id por URL
    @GetMapping("/delete/{id}")
    //@PathVariable funciona para obtener el valor de una variable en la url solo si es de tipo path (ejem:delete/10) donde el 10 es dinamico
    public String deleteCoder(@PathVariable Long id){
        this.obCoderService.delete(id);

        //redirecionar a la lista de coders
        return "redirect:/"; 
    }

    @GetMapping("/update/{id}")
    public String updateCoder(@PathVariable Long id, Model model){
        coder objCoder = this.obCoderService.finById(id);
        model.addAttribute("coder", objCoder);
        model.addAttribute("action", "/edit/" + id);

        return "viewForm";
    }

    @PostMapping("/edit/{id}")
    public String updateCoder(@PathVariable Long id,@ModelAttribute coder objCoder){
        this.obCoderService.update(id, objCoder);

        return "redirect:/";
    }
}
