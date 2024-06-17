package com.karol.mas.service;

import com.karol.mas.entity.Rekwizyt;
import com.karol.mas.entity.Sztuka;

import java.util.Collection;

public interface RekwizytService {
    Collection<Rekwizyt> getAllRekwizyty();
    void addRekwizyt(Rekwizyt rekwizyt);
    void deleteRekwizyt(Long id);
    void addRekwizytToSztuka(Rekwizyt rekwizyt, Sztuka sztuka);
    Collection<Rekwizyt> getRekwizytyFromSztuka(Sztuka sztuka);
}
