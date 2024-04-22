package com.riwi.operations.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.operations.entity.Operation;

@RestController
@RequestMapping("/api/v1/operations")
public class OperationController {

    @PostMapping("/suma")
    public String suma(@RequestBody Operation objOperation) {
        int num1 = objOperation.getNum1();
        int num2 = objOperation.getNum2();
        return num1 + " + " + num2 + " = " + (num1 + num2);
    }

    @PostMapping("/resta")
    public String resta(@RequestBody Operation objOperation) {
        int num1 = objOperation.getNum1();
        int num2 = objOperation.getNum2();
        return num1 + " - " + num2 + " = " + (num1 - num2);
    }

    @PostMapping("/multiplicacion")
    public String multiplicacion(@RequestBody Operation objOperation) {
        int num1 = objOperation.getNum1();
        int num2 = objOperation.getNum2();
        return num1 + " * " + num2 + " = " + (num1 * num2);
    }

    @PostMapping("/dividir")
    public String dividir(@RequestBody Operation objOperation) {
        int num1 = objOperation.getNum1();
        int num2 = objOperation.getNum2();
        if (num2 < 0)
            return "No se puede dividir por un numeoro menor a 0";
        return num1 + " * " + num2 + " = " + (num1 / num2);
    }
}
