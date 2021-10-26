package com.group.adoptions.repository.cats;

import com.group.adoptions.repository.animals.Animal;

import javax.persistence.Entity;

@Entity
public class Cat extends Animal {
    private String purrLevel;

    public String getPurrLevel() {
        return purrLevel;
    }

    public Cat setPurrLevel(String purrLevel) {
        this.purrLevel = purrLevel;
        return this;
    }

    @Override
    public Cat setId(Integer id) {
        this.id = id;
        return this;
    }

    @Override
    public Cat setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public Cat setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
        return this;
    }
}
