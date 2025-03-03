package com.example.dslist.controllers;

import com.example.dslist.dtos.GameDTO;
import com.example.dslist.dtos.GameMinDTO;
import com.example.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService service;

    //listar games
    @GetMapping
    public List<GameMinDTO> findAll() {
        return service.findAll();
    }

    // buscar game
    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

}
