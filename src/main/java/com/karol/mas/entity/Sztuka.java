package com.karol.mas.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="Sztuka",
        uniqueConstraints = @UniqueConstraint(columnNames = {"nazwa"}))
public class Sztuka {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID_Sztuka;

    @Column(nullable = false)
    private String nazwa;

    @Column(nullable = true) String opis;
    @OneToMany(mappedBy="sztuka")
    private Set<Rola> role;

    @OneToMany(mappedBy="sztuka")
    private Set<Rekwizyt> rekwizyty;

    @OneToMany(mappedBy="sztuka")
    private Set<Przedstawienie> przedstawienia;

    public Long getID_Sztuka() {
        return ID_Sztuka;
    }

    public void setID_Sztuka(Long ID_Sztuka) {
        this.ID_Sztuka = ID_Sztuka;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Set<Rola> getRole() {
        return role;
    }

    public Set<Rekwizyt> getRekwizyty() {
        return rekwizyty;
    }

    public void setRekwizyty(Set<Rekwizyt> rekwizyty) {
        this.rekwizyty = rekwizyty;
    }

    public Set<Przedstawienie> getPrzedstawienia() {
        return przedstawienia;
    }

    public void setPrzedstawienia(Set<Przedstawienie> przedstawienia) {
        this.przedstawienia = przedstawienia;
    }



}
