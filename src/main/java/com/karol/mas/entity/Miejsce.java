package com.karol.mas.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Miejsce {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID_Miejsce;
    @Column
    private int numer_miejsca;
    @Column
    private int numer_rzedu;
    @ManyToOne
    @JoinColumn(name = "ID_Sala", nullable = false)
    private Sala sala;

    @ManyToMany(mappedBy = "miejsca")
    private Set<Rezerwacja> rezerwacje;
}
