package pl.pjatk.gameplay.service;

import org.springframework.stereotype.Service;
import pl.pjatk.gameplay.model.Player;
import pl.pjatk.gameplay.repository.PlayerRepository;

@Service
public class DamageService {

    public Player attack (Player defender, Player attacker) {
        int newHealth;
        Player defenderPlayer = defender;
        Player attackerPlayer = attacker;

        newHealth = defenderPlayer.getHealth()-attackerPlayer.getDamage();
        if(newHealth < 0) {
            newHealth = 0;
        }
        defenderPlayer.setHealth(newHealth);
        return defenderPlayer;
    }

    public Player heal (Player defender) {
        Player defenderPlayer = defender;

        if (defenderPlayer.getHealth() < 25) {
            defenderPlayer.setHealth(defenderPlayer.getHealth() + 15);
        } else {
            defenderPlayer.setHealth(defenderPlayer.getHealth() + 5);
        };
        return defenderPlayer;
    };

    public Player debuffAttack (Player attacker) {
        Player attackerPlayer = attacker;
        if (attackerPlayer.getDamage() > 10) {
            attackerPlayer.setDamage(1);
        } else {
            attackerPlayer.setDamage(attackerPlayer.getDamage() - 2);
        };
        return attackerPlayer;
    };

    public Player critAttack (Player attacker, Player defender) {
        int newHealth;
        Player defenderPlayer = defender;
        Player attackerPlayer = attacker;

        if (defenderPlayer.getHealth() < 50) {
            newHealth = defenderPlayer.getHealth()-(attackerPlayer.getDamage() * 3);
        } else {
            newHealth = defenderPlayer.getHealth()-(attackerPlayer.getDamage() * 2);
        }
        if(newHealth < 0) {
            newHealth = 0;
        }
        defenderPlayer.setHealth(newHealth);
        return defenderPlayer;
    }
}
