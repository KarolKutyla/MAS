package com.karol.mas.repository;

import com.karol.mas.entity.Rola;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolaRepository extends JpaRepository<Rola, Long> {

}
