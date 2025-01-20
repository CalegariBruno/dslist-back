package com.example.dslist.dtos;

import com.example.dslist.domain.Game;

public record GameDTO(Long id,
                      String title,
                      Integer year,
                      String imgUrl,
                      String shortDescription) {

}
