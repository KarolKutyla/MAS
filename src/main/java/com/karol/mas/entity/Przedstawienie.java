package com.karol.mas.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Przedstawienie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID_Przedstawienie;
    @OneToOne(mappedBy = "przedstawienie", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Raport raport;

    @ManyToOne
    @JoinColumn(name = "ID_Sztuka", nullable = false)
    private Sztuka sztuka;

    @ManyToMany
    @JoinTable(name = "PracownikTeatru_Przedstawienie",
    joinColumns = @JoinColumn(name = "ID_Przedstawienie"),
    inverseJoinColumns = @JoinColumn(name = "ID_PracownikTeatru"))
    private Set<PracownikTeatru> pracownicyTeatru;

    @ManyToMany
    @JoinTable(name = "WyposazenieTeatru_Przedstawienie",
    joinColumns = @JoinColumn(name = "ID_Przedstawienie"),
    inverseJoinColumns = @JoinColumn(name = "ID_Wyposazenie"))
    private Set<WyposazenieTeatru> wyposazenieTeatru;

    @OneToMany(mappedBy = "przedstawienie")
    private Set<Rezerwacja> rezerwacje;

}
