package com.aquariumetrics.models.repositories;

import com.aquariumetrics.models.Metrics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMetricsRepository extends JpaRepository<Metrics, Long> {
}
