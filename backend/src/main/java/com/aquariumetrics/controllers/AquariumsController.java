package com.aquariumetrics.controllers;

import com.aquariumetrics.models.Aquariums;
import com.aquariumetrics.services.AquariumsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping(path = "/aquariums")
public class AquariumsController {

    @Autowired
    AquariumsService AquariumsService;

    @GetMapping
    public ArrayList<Aquariums> getAllAquariums() {
        return AquariumsService.getAllAquariums();
    }

    @GetMapping(path = "/{id}")
    public Aquariums getTaskById(@PathVariable long id) {
        return AquariumsService.getAquariumById(id);
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteAquarium(@PathVariable long id) {
        return AquariumsService.deleteAquarium(id);
    }

    @PostMapping
    public String saveAquarium(@RequestBody Aquariums Aquarium) {
        return (AquariumsService.saveAquarium(Aquarium));
    }

    @PutMapping(path = "/update/{id}")
    public String updateAquarium (@PathVariable long id, @RequestBody Aquariums Aquarium) {
        Aquarium.setId(id);
        return (AquariumsService.updateAquarium(Aquarium));
    }

}
