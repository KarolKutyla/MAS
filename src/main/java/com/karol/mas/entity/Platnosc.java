package com.karol.mas.entity;

import jakarta.persistence.*;

@Entity
public class Platnosc {
    @Id
    @Column(name = "ID_Rezerwacja")
    private Long ID_Platnosc;
    @Column
    private double kwota_platnosci;
    @Column
    private String potwierdzenie_platnosci;
    @OneToOne
    @MapsId
    @JoinColumn(name = "ID_Rezerwacja")
    private Rezerwacja rezerwacja;
}
