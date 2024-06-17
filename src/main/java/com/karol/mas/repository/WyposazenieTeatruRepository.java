package com.karol.mas.repository;

import com.karol.mas.entity.WyposazenieTeatru;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WyposazenieTeatruRepository extends JpaRepository<WyposazenieTeatru, Long> {


}
