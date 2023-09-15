package com.aquariumetrics.services;

import com.aquariumetrics.models.Metrics;
import com.aquariumetrics.models.repositories.IMetricsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;

@Service
public class MetricsService {

    @Autowired
    IMetricsRepository iMetricsRepository;

    public String saveMetric(Metrics metric) {
        try{
            iMetricsRepository.save(metric);
            return "Added new metric";
        }catch(Exception error) {
            return error.getMessage();
        }
    }

    public Metrics getMetricById(long id) {
        return (Metrics) iMetricsRepository.findById(id).orElse(null);
    }

    public ArrayList<Metrics> getAllMetrics() {
        return (ArrayList<Metrics>) iMetricsRepository.findAll();
    }

    public String deleteMetric(long id) {
        try{
            iMetricsRepository.deleteById(id);
            return "Deleted " + id;
        }catch(Exception error) {
            return error.getMessage();
        }
    }

    public String updateMetric(Metrics updateMetric) {
        try {
            if (iMetricsRepository.existsById(updateMetric.getId())) {
                iMetricsRepository.save(updateMetric);
                return ("Metric updated: " + updateMetric.getId());
            } else {
                return ("Metric not updated: Record with ID :" + updateMetric.getId() + "does not exist");
            }
        }catch(Exception error) {
            throw new RuntimeException("Metric not updated: " + error.getMessage());
        }
    }

}
