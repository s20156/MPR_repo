
package pl.pjatk.gameplay.service;

import org.springframework.stereotype.Service;
import pl.pjatk.gameplay.model.Player;
import pl.pjatk.gameplay.repository.PlayerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }


    public List<Player> findAll(){
        return playerRepository.findAll();
    }

    public Optional<Player> findById(Long id){
        return playerRepository.findById(id);
    }

    public Player savePlayer(Player player){
        return playerRepository.save(player);
    }

}