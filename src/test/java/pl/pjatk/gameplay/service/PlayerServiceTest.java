package pl.pjatk.gameplay.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import pl.pjatk.gameplay.model.Player;
import pl.pjatk.gameplay.repository.PlayerRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PlayerServiceTest {

    @Mock
    private DamageService damageService;
    @Mock
    private PlayerRepository playerRepository;
    @InjectMocks
    PlayerService playerService;

    @BeforeEach
    void setUp() {
    };

    @Test
    void findAll() {
        //Given
        when(playerRepository.findAll()).thenReturn(List.of(new Player()));
        //When
        List<Player> all = playerService.findAll();
        //Then
        assertThat(all).hasSize(1);
    }

    @Test
    void findById() {
        when(playerRepository.findById(1L)).thenReturn(Optional.of(new Player(1L, "name", 100, 10)));
        Optional<Player> player = playerService.findById(1L);
        assertThat(player).isNotEmpty();
    }

    @Test
    void savePlayer() {
        Player p1 = new Player(1L, "test", 100, 20);
        Player p2 = new Player(1L, "test", 100, 20);
        when(playerRepository.save(p1)).thenReturn(p2);
        assertThat(playerService.savePlayer(p1).getId()).isEqualTo(p2.getId());
    }

    @Test
    void attack() {
        Player p1 = new Player(1L, "test", 100, 20);
        Player p2 = new Player(2L, "test", 100, 20);
        when(damageService.attack(any(), any())).thenCallRealMethod();
        when(playerRepository.save(p1)).thenReturn(p2);
        when(playerService.findById(1L)).thenReturn(Optional.of(p1));
        assertThat(playerService.attack(1L, 2L).getHealth()).isLessThan(100);
    }
}