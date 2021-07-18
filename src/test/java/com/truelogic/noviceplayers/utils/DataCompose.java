package com.truelogic.noviceplayers.utils;

import com.truelogic.noviceplayers.model.Player;
import com.truelogic.noviceplayers.model.dto.PlayersDTO;

import java.util.List;

public class DataCompose {

    public static PlayersDTO composePlayersDTOWithOnePlayer() {
        Player player1 = Player.builder().name("Sub zero").type("expert").build();

        List<Player> players = List.of(player1);

        return PlayersDTO.builder()
                .players(players)
                .build();
    }

    public static PlayersDTO composePlayersDTOWithNotFitType() {
        Player player1 = Player.builder().name("Reptile").type("meh").build();

        List<Player> players = List.of(player1);

        return PlayersDTO.builder()
                .players(players)
                .build();
    }

    public static PlayersDTO composePlayersDTOWithMoreThanOnePlayer() {
        Player player1 = Player.builder().name("Sub zero").type("expert").build();
        Player player2 = Player.builder().name("Scorpion").type("novice").build();
        Player player3 = Player.builder().name("Reptile").type("meh").build();

        List<Player> players = List.of(player1, player2, player3);

        return PlayersDTO.builder()
                .players(players)
                .build();
    }

}
