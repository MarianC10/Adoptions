package com.group.adoptions.repository;

import com.group.adoptions.models.Animal;
import com.group.adoptions.models.Cat;
import com.group.adoptions.models.Dog;

import java.util.ArrayList;
import java.util.List;

public class AnimalStore {
    public static final List<Animal> available = new ArrayList<Animal>() {
        {
            add(new Cat("Machi", "https://photos.com/dog"));
            add(new Dog("Rex", "https://photos.com/cat"));
        }
    };
}
