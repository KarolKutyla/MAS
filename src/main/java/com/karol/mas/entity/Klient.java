package com.karol.mas.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Klient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID_Klient;

    @Column
    private String imie;
    @Column
    private String nazwisko;
    @Column
    private String email;

    @OneToMany(mappedBy = "klient")
    private Set<Rezerwacja> rezerwacje;
}
