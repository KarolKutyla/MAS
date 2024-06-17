package com.karol.mas.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID_Sala;
    @Column
    private String nazwa_sali;

    @OneToMany(mappedBy = "sala")
    private Set<Miejsce> miejsca;
}
