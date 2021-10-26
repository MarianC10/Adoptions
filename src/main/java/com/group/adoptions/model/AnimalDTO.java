package com.group.adoptions.model;

public class AnimalDTO {
    protected String name;
    protected String photoUrl;
    protected Integer id;

    public AnimalDTO() {
    }

    public AnimalDTO(String name, String photoUrl, Integer id) {
        this.name = name;
        this.photoUrl = photoUrl;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public AnimalDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public AnimalDTO setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public AnimalDTO setId(Integer id) {
        this.id = id;
        return this;
    }
}
