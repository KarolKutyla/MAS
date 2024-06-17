package com.karol.mas.service;

import com.karol.mas.entity.Sztuka;
import com.karol.mas.repository.SztukaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SztukaServiceImp implements SztukaService{
    @Autowired
    SztukaRepository sztukaRepository;

    @Override
    public void addSztuka(Sztuka sztuka) {
        sztukaRepository.save(sztuka);
    }

    @Override
    public void deleteSztuka(Long id) {
        sztukaRepository.deleteById(id);
    }

    @Override
    public Collection<Sztuka> getAllSztuki() {
        return sztukaRepository.findAll();
    }
}
