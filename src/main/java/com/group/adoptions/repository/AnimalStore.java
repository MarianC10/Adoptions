package com.group.adoptions.repository;

import com.group.adoptions.model.AnimalDTO;
import com.group.adoptions.model.CatDTO;
import com.group.adoptions.model.Dog;

import java.util.ArrayList;
import java.util.List;

public class AnimalStore {
    public static final List<AnimalDTO> available = new ArrayList<>() {
        {
            add(new CatDTO("Machi", "https://photos.com/dog", 1));
            add(new Dog("Rex", "https://photos.com/cat", 2));
        }
    };
}
