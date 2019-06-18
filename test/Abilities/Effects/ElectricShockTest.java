package Abilities.Effects;

import Abilities.Abilities.PokemonAbility;
import Cards.IPokemon;
import Cards.Pokemon;
import Visitors.IVisitor;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ElectricShockTest {

    private ElectricShock electric_shock;
    private NullPokemon pokemon;

    @Before
    public void setUp() {
        pokemon = new NullPokemon();
        electric_shock = new ElectricShock();
        NullAbility ability = new NullAbility(electric_shock, pokemon);
        electric_shock.ability = ability;
        pokemon.getAbilities().add(ability);
    }

    @Test
    public void executeBefore() {
        // This method does nothing
        electric_shock.executeBefore();
        assertTrue(true);
    }

    @Test
    public void executeAfter() {
        electric_shock.executeAfter();
        assertTrue(pokemon.acceptVisitorCalled());
    }

    @Test
    public void visitPokemon() {
        // This test CAN fail, as it depends on a random value
        // However, it's highly unlikely
        for (int i = 0; i < 20; i++) {
            electric_shock.visitPokemon(pokemon);
        }
        assertTrue(pokemon.getHpCalled());
        assertEquals(1, pokemon.setHpCalledWith());
    }

    @Test
    public void visitTrainer() {
        // This method does nothing
        electric_shock.visitTrainer(null);
        assertTrue(true);
    }

    public class NullAbility extends PokemonAbility {

        NullAbility(IEffect effect, IPokemon pokemon) {
            super("null", "test", new HashMap<>(), effect);
            this.setPokemon(pokemon);
        }
    }

    public class NullPokemon extends Pokemon {

        private boolean accept_visitor_called;
        private boolean get_hp_called;
        private int set_hp_called_with;

        NullPokemon() {
            super("test", 0, 1, new ArrayList<>(), null, null, null);
            this.accept_visitor_called = false;
            this.get_hp_called = false;
            this.set_hp_called_with = -1;
        }

        @Override
        public void acceptVisitor(IVisitor visitor) {
            this.accept_visitor_called = true;
        }

        boolean acceptVisitorCalled() {
            return this.accept_visitor_called;
        }

        @Override
        public int getHp() {
            this.get_hp_called = true;
            return 11;
        }

        @Override
        public void setHp(int hp) {
            this.set_hp_called_with = hp;
        }

        boolean getHpCalled() {
            return this.get_hp_called;
        }

        int setHpCalledWith() {
            return this.set_hp_called_with;
        }


    }
}