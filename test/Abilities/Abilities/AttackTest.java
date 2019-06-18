package Abilities.Abilities;

import Abilities.Effects.IEffect;
import Cards.ICard;
import Cards.IPokemon;
import Cards.Pokemon;
import Players.Trainer;
import Types.Water;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class AttackTest {

    private class NullTrainer extends Trainer {

        private boolean notify_attack;

        NullTrainer(ArrayList<ICard> deck, IPokemon pokemon) {
            super(deck);
            this.getTeam().add(pokemon);
            this.notify_attack = false;
        }

        @Override
        public Trainer getAdversary() {
            return this;
        }

        @Override
        public void notifyAttack() {
            this.notify_attack = true;
        }

        boolean attackNotified() {
            return this.notify_attack;
        }

    }

    private class NullEffect implements IEffect {
        private int exec_before_count, exec_after_count;

        private NullEffect() {
            this.exec_before_count = 0;
            this.exec_after_count = 0;
        }

        @Override
        public void executeBefore() {
            this.exec_before_count += 1;
        }

        @Override
        public void executeAfter() {
            this.exec_after_count += 1;
        }

        @Override
        public void visitPokemon(IPokemon pokemon) {
        }

        @Override
        public void visitTrainer(Trainer trainer) {
        }

        private boolean checkCounts(int before, int after) {
            return (this.exec_before_count == before) && (this.exec_after_count == after);
        }
    }

    private Attack attack;
    private NullEffect effect;
    private IPokemon piplup;
    private NullTrainer trainer;

    @Before
    public void setUp() {
        HashMap<String, Integer> costs = new HashMap<>();
        String[] energy_types = {"Fighting", "Fire", "Lightning", "Plant", "Psychic", "Water"};
        for (String energy : energy_types) {
            costs.put(energy, 0);
        }
        Water water = new Water();
        effect = new NullEffect();
        piplup = new Pokemon("Piplup", 393, 53, new ArrayList<>(), water, null, null);
        trainer = new NullTrainer(new ArrayList<>(), piplup);
        piplup.setTrainer(trainer);
        attack = new Attack("test", 10, "test2", costs, effect, piplup);
        piplup.getAbilities().add(attack);
    }

    @Test
    public void getDamage() {
        assertEquals(10, attack.getDamage());
    }

    @Test
    public void getTargetPokemon() {
        assertNull(attack.getTargetPokemon());
    }

    @Test
    public void useAbility() {
        attack.useAbility();
        assertEquals(43, piplup.getHp());
        assertTrue(trainer.attackNotified());
        assertTrue(effect.checkCounts(1, 1));
    }
}