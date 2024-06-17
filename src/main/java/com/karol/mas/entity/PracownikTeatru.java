package com.karol.mas.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity

public class PracownikTeatru {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID_PracownikTeatru;
    @Column
    private String imie;
    @Column
    private String nazwisko;
    @Column
    private String email;
    @Column
    private String numer_telefou;
    @ManyToMany
    @JoinTable(name = "PracownikTeatru_Rola",
    joinColumns = @JoinColumn(name = "ID_PracownikTeatru"),
    inverseJoinColumns = @JoinColumn(name = "ID_Rola"))
    private Set<Rola> role;

    @ManyToMany(mappedBy = "pracownicyTeatru")
    private Set<Przedstawienie> przedstawienia;
}
