package com.example.dslist.services;

import com.example.dslist.domain.Game;
import com.example.dslist.dtos.GameDTO;
import com.example.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository repository;

    //listar games
    public List<GameDTO> findAll() {

        return repository.findAll().stream()
                .map(game -> new GameDTO(
                        game.getId(),
                        game.getTitle(),
                        game.getYear(),
                        game.getImgUrl(),
                        game.getShortDescription()
                ))
                .toList();

    }

}
