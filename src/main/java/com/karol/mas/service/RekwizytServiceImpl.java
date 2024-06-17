package com.karol.mas.service;

import com.karol.mas.entity.Rekwizyt;
import com.karol.mas.entity.Sztuka;
import com.karol.mas.repository.RekwizytRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Collection;

@Service
@EnableTransactionManagement
public class RekwizytServiceImpl implements RekwizytService{
    @Autowired
    private RekwizytRepository rekwizytRepository;
    @Override
    public Collection<Rekwizyt> getAllRekwizyty() {
        return rekwizytRepository.findAll();
    }

    @Override
    public void addRekwizyt(Rekwizyt rekwizyt) {
        rekwizytRepository.save(rekwizyt);
    }

    @Override
    public void deleteRekwizyt(Long id) {
        rekwizytRepository.deleteById(id);
    }

    @Override
    public void addRekwizytToSztuka(Rekwizyt rekwizyt, Sztuka sztuka)
    {
        sztuka.getRekwizyty().add(rekwizyt);
    }
    @Override
    public Collection<Rekwizyt> getRekwizytyFromSztuka(Sztuka sztuka)
    {
        return sztuka.getRekwizyty();
    }
}
