package com.example.dslist.services;

import com.example.dslist.domain.Game;
import com.example.dslist.dtos.GameDTO;
import com.example.dslist.dtos.GameMinDTO;
import com.example.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository repository;

    //listar games
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {

        return repository.findAll().stream()
                .map(game -> new GameMinDTO(
                        game.getId(),
                        game.getTitle(),
                        game.getYear(),
                        game.getImgUrl(),
                        game.getShortDescription()
                ))
                .toList();

    }

    //buscar game por id
    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game result = repository.findById(id).get();
        return new GameDTO(result);
    }

}
