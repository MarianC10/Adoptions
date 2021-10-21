package com.group.adoptions.api.controllers;

import com.group.adoptions.repository.cats.Cat;
import com.group.adoptions.service.CatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/cats")
public class CatController {
    private final CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping
    public ResponseEntity<List<Cat>> getAllCats() {
        return ResponseEntity.ok(catService.findAll());
    }

    @PostMapping
    public void addCat(@RequestBody Cat cat) {
        this.catService.addCat(cat);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Cat> findCatByName(@PathVariable(name = "name") String name) {
        return ResponseEntity.ok(catService.findByName(name));
    }
}
