package com.karol.mas.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Rekwizyt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID_Rekwizyt;

    @Column
    private String nazwa_rekwizytu;
    @Column
    private String opis_rekwizytu;
    @Column
    private int licznosc;
    @ManyToMany(mappedBy = "rekwizyty")
    private Set<WyposazenieTeatru> wyposazenie_teatru;

    @ManyToOne
    @JoinColumn(name = "ID_Sztuka", nullable = false)
    private Sztuka sztuka;
}
