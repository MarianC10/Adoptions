package com.group.adoptions.model;

public class Dog extends AnimalDTO {
    public Dog() {
    }

    public Dog(String name, String photoUrl, Integer id) {
        super(name, photoUrl, id);
    }
}
