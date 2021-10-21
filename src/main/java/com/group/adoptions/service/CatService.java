package com.group.adoptions.service;

import com.group.adoptions.repository.cats.Cat;
import com.group.adoptions.repository.cats.CatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatService {
    private final CatRepository catRepository;

    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    public void addCat(Cat cat) {
        if (cat.getName() == null || cat.getUrl() == null) {
            throw new RuntimeException("Cat must have name and url!\n");
        }

        Cat catToSave = new Cat().setName(cat.getName()).setUrl(cat.getUrl());
        catRepository.save(catToSave);
    }

    public List<Cat> findAll() {
        return catRepository.findAll();
    }

    public Cat findByName(String name) {
        if (name == null || name.equals("")) {
            throw new RuntimeException("Name must not be null or empty!\n");
        }

        return catRepository.findByName(name);
    }
}
