package pl.pjatk.gameplay.service;

import org.junit.jupiter.api.Test;
import pl.pjatk.gameplay.model.Player;

import static org.assertj.core.api.Assertions.assertThat;

public class DamageServiceTest {

    private DamageService damageService = new DamageService();

    @Test
    void shouldCritAttackPlayer(){
        //given
        Player defender = new Player("test player", 100, 10);
        Player attacker = new Player("test", 100, 10);
        //when
        defender = damageService.critAttack(attacker, defender);
        //then
        assertThat(defender.getHealth()).isLessThan(90);
    }

    @Test
    void shouldHealPlayer() {
        Player defender = new Player("test", 100, 10);
        defender = damageService.heal(defender);
        assertThat(defender.getHealth()).isGreaterThan(100);
    };

    @Test
    void shouldHealDefender() {
        Player defender = new Player("test", 10, 10);
        defender = damageService.heal(defender);
        assertThat(defender.getHealth()).isEqualTo(25);
    }

    @Test
    void didCritReallyHitSoHard() {
        Player defender = new Player("test", 100, 10);
        Player attacker = new Player("test", 100, 10);
        defender = damageService.critAttack(attacker, defender);
        assertThat(defender.getHealth()).isEqualTo(80);
    }

    @Test
    void didDebuffDebuffAttacker() {
        Player attacker = new Player("test", 100, 20);
        attacker = damageService.debuffAttack(attacker);
        assertThat(attacker.getDamage()).isEqualTo(1);
    }

    @Test
    void didCritHitHardAlmostDeadOpponent() {
        Player defender = new Player("test", 40, 10);
        Player attacker = new Player("test", 100, 10);
        defender = damageService.critAttack(attacker, defender);
        assertThat(defender.getHealth()).isEqualTo(10);
    }


}
