package com.group.adoptions.repository.dogs;

import com.group.adoptions.repository.animals.Animal;

import javax.persistence.Entity;

@Entity
public class Dog extends Animal {
    private String size;

    public String getSize() {
        return size;
    }

    public Dog setSize(String size) {
        this.size = size;
        return this;
    }

    @Override
    public Dog setId(Integer id) {
        this.id = id;
        return this;
    }

    @Override
    public Dog setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public Dog setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
        return this;
    }
}
