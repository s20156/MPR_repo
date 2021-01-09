
package pl.pjatk.gameplay.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.pjatk.gameplay.model.Player;
import pl.pjatk.gameplay.model.PlayerDTO;
import pl.pjatk.gameplay.repository.PlayerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private PlayerRepository playerRepository;
    private DamageService damageService;
    private PlayerMapper playerMapper;

    public PlayerService(PlayerRepository playerRepository, DamageService damageService) {
        this.playerRepository = this.playerRepository;
        this.damageService = this.damageService;
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

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }

    public Player updatePlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player attack(Long attackerId, Long defenderId) {
        Player attackerPlayer = playerRepository.findById(attackerId).get();
        Player defenderPlayer = playerRepository.findById(defenderId).get();

        defenderPlayer = damageService.attack(defenderPlayer, attackerPlayer);
        return playerRepository.save(defenderPlayer);
    }
}