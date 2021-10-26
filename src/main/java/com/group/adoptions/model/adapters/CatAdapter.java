package com.group.adoptions.model.adapters;

import com.group.adoptions.model.CatDTO;
import com.group.adoptions.repository.cats.Cat;

import java.util.ArrayList;
import java.util.List;

public class CatAdapter {
    public static Cat fromDto(CatDTO catDto) {
        return new Cat().setName(catDto.getName()).setPhotoUrl(catDto.getPhotoUrl());
    }

    public static CatDTO toDto(Cat cat) {
        return new CatDTO(cat.getName(), cat.getPhotoUrl(), cat.getId());
    }

    public static List<CatDTO> toDtoList(List<Cat> catList) {
        List<CatDTO> dtoList = new ArrayList<>();

        catList.forEach(cat -> dtoList.add(CatAdapter.toDto(cat)));

        return dtoList;
    }
}
