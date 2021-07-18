package com.truelogic.noviceplayers.service;

import com.truelogic.noviceplayers.model.dto.PlayersDTO;
import com.truelogic.noviceplayers.model.dto.ResultDTO;
import com.truelogic.noviceplayers.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public ResultDTO save(PlayersDTO playerDTO) {
        ResultDTO resultDTO = ResultDTO.builder().result(new ArrayList<>()).build();

        playerDTO.getPlayers().forEach(player -> {
            switch (player.getType()) {
                case "expert":
                    playerRepository.save(player);
                    resultDTO.getResult().add("player " + player.getName() + " stored in DB");
                    break;
                case "novice":
                    kafkaTemplate.send("novice-players", player.toString());
                    resultDTO.getResult().add("player " + player.getName() + " sent to Kafka topic");
                    break;
                default:
                    resultDTO.getResult().add("player " + player.getName() + " did not fit");
            }
        });

        return resultDTO;
    }
}
