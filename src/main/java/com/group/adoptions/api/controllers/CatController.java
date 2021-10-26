package com.group.adoptions.api.controllers;

import com.group.adoptions.model.CatDTO;
import com.group.adoptions.model.ListDTO;
import com.group.adoptions.service.CatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/cats")
public class CatController {
    private final CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping
    public ResponseEntity<ListDTO<CatDTO>> getAllCats() {
        return ResponseEntity.ok(catService.findAll());
    }

    @PostMapping
    public void addCat(@RequestBody CatDTO catDto) {
        this.catService.addCat(catDto);
    }

    @GetMapping("/{name}")
    public ResponseEntity<CatDTO> findCatByName(@PathVariable(name = "name") String name) {
        return ResponseEntity.ok(catService.findByName(name));
    }
}
