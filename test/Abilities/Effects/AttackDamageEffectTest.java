package Abilities.Effects;

import Abilities.Abilities.Attack;
import Cards.ICard;
import Cards.IPokemon;
import Cards.Pokemon;
import Players.Trainer;
import Types.Water;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AttackDamageEffectTest {

    private AttackDamageEffect attack_effect;
    private NullAttack attack;
    private NullTrainer trainer;
    private IPokemon piplup;

    @Before
    public void setUp() {
        Water water = new Water();
        piplup = new Pokemon("Piplup", 393, 53, new ArrayList<>(), water, null, null);
        trainer = new NullTrainer(new ArrayList<>(), piplup);
        piplup.setTrainer(trainer);
        attack = new NullAttack(piplup);
        attack_effect = new AttackDamageEffect(attack);
    }

    @Test
    public void executeBefore() {
        attack_effect.executeBefore();
        assertEquals(43, piplup.getHp());
    }

    @Test
    public void executeAfter() {
        attack_effect.executeAfter();
        assertTrue(trainer.attackNotified());
    }

    @Test
    public void visitPokemon() {
        attack_effect.visitPokemon(piplup);
        assertEquals(43, piplup.getHp());
    }

    @Test
    public void visitTrainer() {
        // This method does nothing
        attack_effect.visitTrainer(trainer);
        assertTrue(true);
    }

    private class NullAttack extends Attack {

        NullAttack(IPokemon pokemon) {
            super("null", 10, "test", new HashMap<>(), null, pokemon);
        }

        @Override
        public IPokemon getTargetPokemon() {
            return this.getPokemon();
        }
    }

    private class NullTrainer extends Trainer {

        private boolean notify_attack;

        NullTrainer(ArrayList<ICard> deck, IPokemon pokemon) {
            super(deck);
            this.getTeam().add(pokemon);
            this.notify_attack = false;
        }

        @Override
        public void notifyAttack() {
            this.notify_attack = true;
        }

        boolean attackNotified() {
            return this.notify_attack;
        }

    }
}