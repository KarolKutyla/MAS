package com.karol.mas.service;

import com.karol.mas.entity.WyposazenieTeatru;
import com.karol.mas.repository.WyposazenieTeatruRepository;
import com.karol.mas.service.WyposazenieTeatruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Collection;

@Service
@EnableTransactionManagement
//@EnableJpaRepositories(basePackages = {"com.karol.mas.repository"})
public class WyposazenieTeatruServiceImp implements WyposazenieTeatruService
{


    @Autowired
    WyposazenieTeatruRepository wyposazenieTeatruRepository;

    @Override
    public WyposazenieTeatru saveWyposazenieTeatru(WyposazenieTeatru wyposazenieTeatru) {
        return wyposazenieTeatruRepository.save(wyposazenieTeatru);
    }

    @Override
    public void addWyposazenieTeatru(WyposazenieTeatru wyposazenieTeatru) {
        wyposazenieTeatruRepository.save(wyposazenieTeatru);
    }

    @Override
    public void deleteWyposazenieTeatru(long ID) {
        wyposazenieTeatruRepository.deleteById(ID);
    }
    @Override
    public WyposazenieTeatru getWyposazenieById(long id)
    {
        return wyposazenieTeatruRepository.findById(id).orElseThrow(() -> new RuntimeException("Nie znaleziono wyniku"));
    }

    @Override
    public Collection<WyposazenieTeatru> getAllWyposazenie()
    {
        return wyposazenieTeatruRepository.findAll();
    }
}
