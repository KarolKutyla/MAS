package com.karol.mas.entity;

import jakarta.persistence.*;

@Entity
public class Raport {
    @Id
    @Column(name = "ID_Przedstawienie")
    private Long ID_Raport;
    @Column
    private int liczba_sprzedanych_biletow;
    @Column
    private int liczba_rezerwacji;
    @Column double calkowity_przychod;

    @OneToOne
    @MapsId
    @JoinColumn(name = "ID_Przedstawienie")
    private Przedstawienie przedstawienie;
}
