package com.truelogic.noviceplayers.model.dto;

import com.truelogic.noviceplayers.model.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayersDTO {
    private List<Player> players;
}
