package com.truelogic.noviceplayers.controller;

import com.truelogic.noviceplayers.model.dto.PlayersDTO;
import com.truelogic.noviceplayers.model.dto.ResultDTO;
import com.truelogic.noviceplayers.service.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PlayerController {
    private final PlayerService playerService;

    @PostMapping
    public ResultDTO savePlayer(@RequestBody PlayersDTO players) {
        return playerService.save(players);
    }
}
