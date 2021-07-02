package com.group.adoptions.controllers;

import com.group.adoptions.models.Animal;
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
    public ResponseEntity<List<Animal>> getAvailableAnimals() {
        return ResponseEntity.ok(AnimalStore.available);
    }

    @PostMapping
    public ResponseEntity<Animal> addAnimalForAdoption(@RequestBody Animal animal) {
        if (animal == null || animal.getName() == null || animal.getPhotoUrl() == null) {
            return ResponseEntity.badRequest().body(animal);
        }
        AnimalStore.available.add(animal);
        return ResponseEntity.ok(animal);
    }

    @PutMapping("/{name}")
    public void updateAnimal(@PathVariable(name = "name") String name, @RequestBody Animal updatedAnimal) {
        List<Animal> available = AnimalStore.available;
        for (int i = 0; i < available.size(); ++i) {
            if (available.get(i).getName().equals(name)) {
                available.remove(i);
                available.add(updatedAnimal);
                break;
            }
        }
    }

    @DeleteMapping("/{name}")
    public void deleteAnimal(@PathVariable(name = "name") String name) {
        List<Animal> available = AnimalStore.available;
        for (int i = 0; i < available.size(); ++i) {
            if (available.get(i).getName().equals(name)) {
                available.remove(i);
                break;
            }
        }
    }
}
