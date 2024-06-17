package com.karol.mas.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Rezerwacja {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID_Rezerwacja;
    @Column
    private int numer_rezerwacji;
    @Column
    private String status_rezerwacji;

    @OneToOne(mappedBy = "rezerwacja", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Bilet bilet;

    @OneToOne(mappedBy = "rezerwacja", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Platnosc platnosc;

    @ManyToOne
    @JoinColumn(name = "ID_Klient", nullable = false)
    private Klient klient;

    @ManyToOne
    @JoinColumn(name = "ID_Przedstawienie", nullable = false)
    private Przedstawienie przedstawienie;
    @ManyToMany
    @JoinTable(name = "Rezerwacja_Miejsce",
    joinColumns = @JoinColumn(name = "ID_Rezerwacja"),
    inverseJoinColumns = @JoinColumn(name = "ID_Miejsce"))
    private Set<Miejsce> miejsca;

}
