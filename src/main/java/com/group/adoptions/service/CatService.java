package com.group.adoptions.service;

import com.group.adoptions.model.CatDTO;
import com.group.adoptions.model.ListDTO;
import com.group.adoptions.model.adapters.CatAdapter;
import com.group.adoptions.repository.cats.CatRepository;
import org.springframework.stereotype.Service;

@Service
public class CatService {
    private final CatRepository catRepository;

    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    public void addCat(CatDTO catDto) {
        if (catDto.getName() == null || catDto.getPhotoUrl() == null) {
            throw new RuntimeException("Cat must have name and url!\n");
        }

        catRepository.save(CatAdapter.fromDto(catDto));
    }

    public ListDTO<CatDTO> findAll() {
        return new ListDTO<>(CatAdapter.toDtoList(catRepository.findAll()), catRepository.count());
    }

    public CatDTO findByName(String name) {
        if (name == null || name.equals("")) {
            throw new RuntimeException("Name must not be null or empty!\n");
        }

        return CatAdapter.toDto(catRepository.findByName(name));
    }
}
