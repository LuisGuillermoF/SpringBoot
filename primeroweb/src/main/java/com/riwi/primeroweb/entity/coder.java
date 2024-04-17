package com.riwi.primeroweb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//@Entity le dinfiga a sprint boot que esta clase es una entidad
@Entity
//Tabla permite configurar la tabla que creara el ORM 
@Table(name="coder")
public class coder {
    //@id indica que el atributo sera la llave primaria
    @Id
    //@GenerateValue indica que el atributo sera auto generado con la estrategia auto_increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String clan;
    private int age;
    
    public coder(Long id, String name, String clan, int age) {
        this.id = id;
        this.name = name;
        this.clan = clan;
        this.age = age;
    }

    public coder() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClan() {
        return clan;
    }

    public void setClan(String clan) {
        this.clan = clan;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "coder [id=" + id + ", name=" + name + ", clan=" + clan + ", age=" + age + "]";
    }
    
    
}
