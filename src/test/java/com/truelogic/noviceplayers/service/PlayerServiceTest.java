package com.truelogic.noviceplayers.service;

import com.truelogic.noviceplayers.model.Player;
import com.truelogic.noviceplayers.model.dto.PlayersDTO;
import com.truelogic.noviceplayers.model.dto.ResultDTO;
import com.truelogic.noviceplayers.repository.PlayerRepository;
import com.truelogic.noviceplayers.utils.DataCompose;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PlayerServiceTest {

    @InjectMocks
    private PlayerService playerService;

    @Mock
    private PlayerRepository playerRepository;

    @Test
    @DisplayName("Should save a player in H2 database")
    void shouldSavePlayerInH2Database() {
        //Given
        PlayersDTO playersDTO = DataCompose.composePlayersDTOWithOnePlayer();
        Player player = Player.builder().id(1L).type("expert").name("Sub zero").build();
        when(playerRepository.save(any())).thenReturn(player);
        ResultDTO resultExpected = ResultDTO.builder()
                .result(List.of("player Sub zero stored in DB"))
                .build();

        //When
        ResultDTO resultActual = playerService.save(playersDTO);

        //Then
        assertThat(resultActual).isNotNull();
        assertThat(resultActual).isEqualTo(resultExpected);
    }

    @Test
    @DisplayName("Should return a message to server client that not fit")
    void shouldReturnMessageNotFit() {
        //Given
        PlayersDTO playersDTO = DataCompose.composePlayersDTOWithNotFitType();
        ResultDTO resultExpected = ResultDTO.builder()
                .result(List.of("player Reptile did not fit"))
                .build();

        //When
        ResultDTO resultActual = playerService.save(playersDTO);

        //Then
        assertThat(resultActual).isNotNull();
        assertThat(resultActual).isEqualTo(resultExpected);
    }

}