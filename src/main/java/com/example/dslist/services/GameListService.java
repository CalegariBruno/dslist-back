package com.example.dslist.services;

import com.example.dslist.domain.GameList;
import com.example.dslist.dtos.GameListDTO;
import com.example.dslist.projections.GameMinProjection;
import com.example.dslist.repositories.GameListRepository;
import com.example.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository repository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> list = repository.findAll();
        return list.stream().map(GameListDTO::new).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){

        int min, max;

        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);

        list.add(destinationIndex, obj);

        min = Math.min(sourceIndex, destinationIndex);

        max = Math.max(sourceIndex, destinationIndex);

        for(int i = min; i <= max; i++){
            repository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }

    }

}
