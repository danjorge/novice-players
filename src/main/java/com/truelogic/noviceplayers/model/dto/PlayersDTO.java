package com.truelogic.noviceplayers.model.dto;

import com.truelogic.noviceplayers.model.Player;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayersDTO {
    private List<Player> players;
}
