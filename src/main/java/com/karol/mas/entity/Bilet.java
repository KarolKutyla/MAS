package com.karol.mas.entity;

import jakarta.persistence.*;

@Entity
public class Bilet {
    @Id
    @Column(name = "ID_Rezerwacja")
    private Long ID_Bilet;
    @Column
    private String dane_biletu;

    @OneToOne
    @MapsId
    @JoinColumn(name = "ID_Rezerwacja")
    private Rezerwacja rezerwacja;
}
