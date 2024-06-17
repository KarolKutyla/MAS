package com.karol.mas.service;

import com.karol.mas.entity.PracownikTeatru;
import com.karol.mas.repository.PracownikTeatruRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PracownikTeatruServiceImp implements PracownikTeatruService{
    @Autowired
    private PracownikTeatruRepository pracownikTeatruRepository;

    @Override
    public void addPracownikTeatru(PracownikTeatru pracownikTeatru) {
        pracownikTeatruRepository.save(pracownikTeatru);
    }

    @Override
    public void deletePracownikTeatru(Long id) {
        pracownikTeatruRepository.deleteById(id);
    }

    @Override
    public Collection<PracownikTeatru> getPracownicyTeatru() {
        return pracownikTeatruRepository.findAll();
    }
}
