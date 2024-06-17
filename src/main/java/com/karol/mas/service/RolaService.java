package com.karol.mas.service;

import com.karol.mas.entity.Rola;

import java.util.Collection;

public interface RolaService {
    void addRola(Rola rola);
    void deleteRola(Long id);
    Collection<Rola> getAllRola();
}
