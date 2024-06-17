package com.karol.mas.service;

import com.karol.mas.repository.PrzedstawienieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrzedstawienieServiceImp implements PrzedstawienieService{
    @Autowired
    private PrzedstawienieRepository przedstawienieRepository;

}
