package com.aquariumetrics.models.repositories;

import com.aquariumetrics.models.Aquariums;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAquariumsRepository extends JpaRepository<Aquariums, Long> {
}
