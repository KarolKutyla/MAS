package com.karol.mas.service;

import com.karol.mas.entity.Sztuka;

import java.util.Collection;

public interface SztukaService {
    void addSztuka(Sztuka sztuka);
    void deleteSztuka(Long id);
    Collection<Sztuka> getAllSztuki();
}
