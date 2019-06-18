package Abilities.Effects;

import Abilities.Abilities.PokemonAbility;
import Cards.IPokemon;
import Cards.Pokemon;
import Types.Water;
import Visitors.IVisitor;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EnergyBurnTest {

    private EnergyBurn energy_burn;
    private NullPokemon pokemon;

    @Before
    public void setUp() {
        pokemon = new NullPokemon();
        energy_burn = new EnergyBurn();
        NullAbility ability = new NullAbility(energy_burn, pokemon);
        energy_burn.ability = ability;
        pokemon.getAbilities().add(ability);
    }

    @Test
    public void executeBefore() {
        energy_burn.executeBefore();
        assertTrue(pokemon.acceptVisitorCalled());
    }

    @Test
    public void executeAfter() {
        // This method does nothing
        energy_burn.executeAfter();
        assertTrue(true);
    }

    @Test
    public void visitPokemon() {
        energy_burn.visitPokemon(pokemon);
        String[] energy_names = {"Fighting", "Fire", "Lightning", "Plant", "Psychic", "Water"};
        HashMap<String, Integer> energies = pokemon.getEnergies();
        for (String energy : energy_names) {
            if (energy.equals("Water")) {
                assertEquals(2, (int) energies.get(energy));
            } else {
                assertEquals(0, (int) energies.get(energy));
            }
        }
    }

    @Test
    public void visitTrainer() {
        // This method does nothing
        energy_burn.visitTrainer(null);
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

        NullPokemon() {
            super("test", 1, 11, new ArrayList<>(), new Water(), null, null);
            this.accept_visitor_called = false;
            super.addFightingEnergy();
            super.addFireEnergy();
        }

        @Override
        public void acceptVisitor(IVisitor visitor) {
            this.accept_visitor_called = true;
        }

        boolean acceptVisitorCalled() {
            return this.accept_visitor_called;
        }


    }
}