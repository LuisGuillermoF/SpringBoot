package com.riwi.vacants.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name ="company")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(length = 40,nullable = false)
    private String name;


    private String location;

    @Column(length = 14,nullable = false)
    private String contact;

    @OneToMany(mappedBy = "company" ,cascade = CascadeType.ALL,orphanRemoval = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Vacant> vancats;
}
