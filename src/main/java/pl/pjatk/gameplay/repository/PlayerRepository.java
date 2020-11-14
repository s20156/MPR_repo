package pl.pjatk.gameplay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjatk.gameplay.model.Player;


public interface PlayerRepository extends JpaRepository<Player, Long> {
}