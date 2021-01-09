package pl.pjatk.gameplay.service;

import org.springframework.stereotype.Component;
import pl.pjatk.gameplay.model.Player;
import pl.pjatk.gameplay.model.PlayerDTO;

@Component
public class PlayerMapper {
    public void mapDtoToPlayer(Player player, PlayerDTO playerDTO) {
        if (playerDTO.getHealth() != null) {
            player.setHealth(playerDTO.getHealth());
        }
        if (playerDTO.getDamage() != null) {
            player.setDamage(playerDTO.getDamage());
        }
        if (playerDTO.getName() != null) {
            player.setName(playerDTO.getName());
        }
    }
}
