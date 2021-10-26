package com.group.adoptions.api.controllers;

import com.group.adoptions.model.AnimalDTO;
import com.group.adoptions.repository.AnimalStore;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/animals")
public class AnimalController {
    @GetMapping("/hello")
    public ResponseEntity<String> greetOwner(@RequestParam(name = "name", required = false) String ownerName) {
        String name = ownerName == null ? "world" : ownerName;
        return ResponseEntity.ok("Hello " + name + ", from the animal shelter!");
    }

    @GetMapping
    public ResponseEntity<List<AnimalDTO>> getAvailableAnimals() {
        return ResponseEntity.ok(AnimalStore.available);
    }

    @PostMapping
    public ResponseEntity<AnimalDTO> addAnimalForAdoption(@RequestBody AnimalDTO animalDTO) {
        if (animalDTO == null || animalDTO.getName() == null || animalDTO.getPhotoUrl() == null) {
            return ResponseEntity.badRequest().body(animalDTO);
        }
        AnimalStore.available.add(animalDTO);
        return ResponseEntity.ok(animalDTO);
    }

    @PutMapping("/{name}")
    public void updateAnimal(@PathVariable(name = "name") String name, @RequestBody AnimalDTO updatedAnimalDTO) {
        List<AnimalDTO> available = AnimalStore.available;
        for (int i = 0; i < available.size(); ++i) {
            if (available.get(i).getName().equals(name)) {
                available.remove(i);
                available.add(updatedAnimalDTO);
                break;
            }
        }
    }

    @DeleteMapping("/{name}")
    public void deleteAnimal(@PathVariable(name = "name") String name) {
        List<AnimalDTO> available = AnimalStore.available;
        for (int i = 0; i < available.size(); ++i) {
            if (available.get(i).getName().equals(name)) {
                available.remove(i);
                break;
            }
        }
    }
}
