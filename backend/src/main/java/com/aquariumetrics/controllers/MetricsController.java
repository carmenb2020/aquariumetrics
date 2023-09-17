package com.aquariumetrics.controllers;

import com.aquariumetrics.models.Metrics;
import com.aquariumetrics.services.MetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/metrics")
public class MetricsController {

    @Autowired
    MetricsService metricsService;

    @GetMapping
    public ArrayList<Metrics> getAllMetrics() {
        return metricsService.getAllMetrics();
    }

    @GetMapping(path = "/{id}")
    public Metrics getTaskById(@PathVariable long id) {
        return metricsService.getMetricById(id);
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteMetric(@PathVariable long id) {
        return metricsService.deleteMetric(id);
    }

    @PostMapping(path = "/save")
    public String saveMetric(@RequestBody Metrics metric) {
        return (metricsService.saveMetric(metric));
    }

    @PutMapping(path = "/update/{id}")
    public String updateMetric (@PathVariable long id, @RequestBody Metrics metric) {
        metric.setId(id);
        return (metricsService.updateMetric(metric));
    }



}
