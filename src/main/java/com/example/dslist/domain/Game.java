package com.example.dslist.domain;

import com.example.dslist.dtos.GameDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_game")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String platforms;
    private Double score;
    private String genre;

    @Column(name = "game_year")
    private Integer year;
    private String imgUrl;

    @Column(name = "short_description", columnDefinition = "TEXT")
    private String shortDescription;

    @Column(name = "long_description", columnDefinition = "TEXT")
    private String longDescription;

}
