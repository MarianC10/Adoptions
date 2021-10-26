package com.group.adoptions.repository.shelter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class AnimalShelter {
    @Id
    private Integer id;
    private String name;
    private String address;

    public AnimalShelter() {
    }

    public Integer getId() {
        return id;
    }

    public AnimalShelter setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AnimalShelter setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public AnimalShelter setAddress(String address) {
        this.address = address;
        return this;
    }
}
