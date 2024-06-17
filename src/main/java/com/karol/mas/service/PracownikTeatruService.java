package com.karol.mas.service;

import com.karol.mas.entity.PracownikTeatru;

import java.util.Collection;

public interface PracownikTeatruService {
    void addPracownikTeatru(PracownikTeatru pracownikTeatru);
    void deletePracownikTeatru(Long id);
    Collection<PracownikTeatru> getPracownicyTeatru();
}
