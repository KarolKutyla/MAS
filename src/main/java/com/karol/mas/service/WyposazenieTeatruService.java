package com.karol.mas.service;

import com.karol.mas.entity.WyposazenieTeatru;

import java.util.Collection;

public interface WyposazenieTeatruService {
    WyposazenieTeatru saveWyposazenieTeatru(WyposazenieTeatru wyposazenieTeatru);
    void addWyposazenieTeatru(WyposazenieTeatru wyposazenieTeatru);
    void deleteWyposazenieTeatru(long ID);

    WyposazenieTeatru getWyposazenieById(long id);
    Collection<WyposazenieTeatru> getAllWyposazenie();
}
