package Abilities.Abilities;

import Abilities.Effects.IEffect;
import Cards.IPokemon;
import Cards.Pokemon;
import Players.Trainer;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class PokemonAbilityTest {

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

    private PokemonAbility pkmnAbility;
    private NullEffect effect;
    private IPokemon piplup;

    @Before
    public void setUp() {
        HashMap<String, Integer> energies = new HashMap<>();
        HashMap<String, Integer> costs = new HashMap<>();
        effect = new NullEffect();
        String[] energy_types = {"Fighting", "Fire", "Lightning", "Plant", "Psychic", "Water"};
        for (String energy : energy_types) {
            energies.put(energy, 0);
            costs.put(energy, 0);
        }
        costs.put(energy_types[0], 1);
        pkmnAbility = new PokemonAbility("test", "test2", costs, effect);
        ArrayList<AbstractAbility> abilities = new ArrayList<>();
        abilities.add(pkmnAbility);
        piplup = new Pokemon("Piplup", 393, 53, abilities, null, null, null);
    }

    @Test
    public void useAbility() {
        piplup.addFightingEnergy();
        pkmnAbility.useAbility();
        assertTrue(effect.checkCounts(1, 1));
    }

    @Test
    public void getName() {
        assertEquals("test", pkmnAbility.getName());
    }

    @Test
    public void getDescription() {
        assertEquals("test2", pkmnAbility.getDescription());
    }

    @Test
    public void checkCost() {
        assertFalse(pkmnAbility.checkCost());
        piplup.addFightingEnergy();
        assertTrue(pkmnAbility.checkCost());
    }

    @Test
    public void getPokemon() {
        assertEquals(piplup, pkmnAbility.getPokemon());
    }

    @Test
    public void setPokemon() {
        pkmnAbility.setPokemon(null);
        assertNull(pkmnAbility.getPokemon());
    }
}