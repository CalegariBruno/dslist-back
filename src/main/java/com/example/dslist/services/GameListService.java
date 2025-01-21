package com.example.dslist.services;

import com.example.dslist.domain.GameList;
import com.example.dslist.dtos.GameListDTO;
import com.example.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository repository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> list = repository.findAll();
        return list.stream().map(GameListDTO::new).toList();
    }

}
