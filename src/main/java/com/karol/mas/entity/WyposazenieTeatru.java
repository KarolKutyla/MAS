package com.karol.mas.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;

import java.util.Map;
import java.util.Set;

@Entity
public class WyposazenieTeatru {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("ID_Wyposazenie")
    private Long ID_Wyposazenie;
    @Column
    private String identyfikator_magazynowy;
    @Column
    private String nazwa;
    @Column
    private String opis;
    @ManyToMany
    @JoinTable(name = "Rekwizyt_WyposazenieTeatru",
    joinColumns = @JoinColumn(name = "ID_Wyposazenie"),
    inverseJoinColumns = @JoinColumn(name = "ID_Rekwizyt"))
    private Set<Rekwizyt> rekwizyty;

    @ManyToMany(mappedBy = "wyposazenieTeatru")
    private Set<Przedstawienie> przedstawienia;

    public long getID_Wyposazenie()
    {
        return ID_Wyposazenie;
    }
    public void setID_Wyposazenie(long idWyposazenie)
    {
        this.ID_Wyposazenie = idWyposazenie;
    }

    public String getIdentyfikator_magazynowy()
    {
        return identyfikator_magazynowy;
    }

    public void setIdentyfikator_magazynowy(String identyfikator_magazynowy)
    {
        this.identyfikator_magazynowy = identyfikator_magazynowy;
    }

    public String getNazwa()
    {
        return nazwa;
    }

    public void setNazwa(String nazwa)
    {
        this.nazwa = nazwa;
    }

    public String getOpis()
    {
        return opis;
    }

    public void setOpis(String opis)
    {
        this.opis = opis;
    }

    @Override
    public String toString() {
        return "ID: " + ID_Wyposazenie + ", Numer Magazynowy: " + identyfikator_magazynowy + ", Nazwa: " + nazwa;
    }
}
