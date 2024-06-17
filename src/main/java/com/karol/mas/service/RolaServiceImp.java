package com.karol.mas.service;

import com.karol.mas.entity.Rola;
import com.karol.mas.repository.RolaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RolaServiceImp implements RolaService{
    @Autowired
    RolaRepository rolaRepository;

    @Override
    public void addRola(Rola rola) {
        rolaRepository.save(rola);
    }

    @Override
    public void deleteRola(Long id) {
        rolaRepository.deleteById(id);
    }

    @Override
    public Collection<Rola> getAllRola() {
        return rolaRepository.findAll();
    }
}
