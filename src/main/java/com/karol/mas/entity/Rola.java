package com.karol.mas.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Rola {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID_Rola;
    @Column
    private String nazwa_roli;
    @Column
    private String opis_roli;
    @Column
    private int licznosc;

    @ManyToMany(mappedBy="role")
    private Set<PracownikTeatru> pracownicy_teatru;

    @ManyToOne
    @JoinColumn(name="ID_Sztuka", nullable = false)
    private Sztuka sztuka;
}
