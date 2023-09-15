package com.aquariumetrics.services;

import com.aquariumetrics.models.Aquariums;
import com.aquariumetrics.models.repositories.IAquariumsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AquariumsService {
    @Autowired
    IAquariumsRepository iAquariumsRepository;

    public String saveAquarium(Aquariums Aquarium) {
        try{
            iAquariumsRepository.save(Aquarium);
            return "Added new Aquarium";
        }catch(Exception error) {
            return error.getMessage();
        }
    }

    public Aquariums getAquariumById(long id) {
        return (Aquariums) iAquariumsRepository.findById(id).orElse(null);
    }

    public ArrayList<Aquariums> getAllAquariums() {
        return (ArrayList<Aquariums>) iAquariumsRepository.findAll();
    }

    public String deleteAquarium(long id) {
        try{
            iAquariumsRepository.deleteById(id);
            return "Deleted " + id;
        }catch(Exception error) {
            return error.getMessage();
        }
    }

    public String updateAquarium(Aquariums updateAquarium) {
        try {
            if (iAquariumsRepository.existsById(updateAquarium.getId())) {
                iAquariumsRepository.save(updateAquarium);
                return ("Aquarium updated: " + updateAquarium.getId());
            } else {
                return ("Aquarium not updated: Record with ID :" + updateAquarium.getId() + "does not exist");
            }
        }catch(Exception error) {
            throw new RuntimeException("Aquarium not updated: " + error.getMessage());
        }
    }

}
