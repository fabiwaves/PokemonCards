package Cards;

import Abilities.Abilities.AbstractAbility;
import Abilities.Abilities.PokemonAbility;
import Abilities.Effects.IEffect;
import Cards.Phases.AbstractPhase;
import Cards.Phases.Basic;
import Cards.TrainerCards.PKMObject;
import Controller.Game;
import Players.Trainer;
import Types.Type;
import Types.Water;
import Visitors.IVisitor;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class PokemonTest {

    private Pokemon piplup;
    private Type water;
    private ArrayList<ICard> deck;
    private Trainer trainer;
    private AbstractPhase phase;
    private ArrayList<AbstractAbility> abilities;
    private HashMap<String, Integer> energies;
    private PKMObject object;
    private NullEffect effect;

    @Before
    public void setUp() {
        abilities = new ArrayList<>();
        water = new Water();
        deck = new ArrayList<>();
        trainer = new Trainer(deck);
        phase = new Basic();
        energies = new HashMap<>();
        HashMap<String, Integer> energies2 = new HashMap<>();
        String[] energy_types = {"Fighting", "Fire", "Lightning", "Plant", "Psychic", "Water"};
        for (String energy : energy_types) {
            energies.put(energy, 0);
            energies2.put(energy, 0);
        }
        energies2.put("Fire", 1);
        effect = new NullEffect();
        object = new PKMObject(effect);
        PokemonAbility null_ability = new PokemonAbility("null_ability", "null", energies2, effect);
        abilities.add(null_ability);
        abilities.add(null_ability);
        piplup = new Pokemon("Piplup", 393, 53, abilities, water, trainer, phase);
    }

    @Test
    public void getName() {
        assertEquals("Piplup", piplup.getName());
        assertNotEquals("Empoleon", piplup.getName());
    }

    @Test
    public void getId() {
        assertEquals(393, piplup.getId());
        assertNotEquals(394, piplup.getId());
    }

    @Test
    public void getHp() {
        assertEquals(53, piplup.getHp());
        assertNotEquals(-1, piplup.getHp());
    }

    @Test
    public void setHp() {
        int hp1 = 40;
        int hp2 = 100;
        int hp3 = -10;
        piplup.setHp(hp1);
        assertEquals(hp1, piplup.getHp());
        assertNotEquals(53, piplup.getHp());
        piplup.setHp(hp2);
        assertEquals(53, piplup.getHp());
        piplup.setHp(hp3);
        assertEquals(0, piplup.getHp());
    }

    @Test
    public void getMax_hp() {
        assertEquals(53, piplup.getMax_hp());
    }

    @Test
    public void getAbilities() {
        assertEquals(abilities, piplup.getAbilities());
    }

    @Test
    public void getEnergies() {
        assertEquals(energies, piplup.getEnergies());
    }

    @Test
    public void getType() {
        assertEquals(water, piplup.getType());
    }

    @Test
    public void getTrainer() {
        assertEquals(trainer, piplup.getTrainer());
    }

    @Test
    public void setTrainer() {
        Trainer trainer1 = new Trainer(deck);
        piplup.setTrainer(trainer1);
        assertEquals(trainer1, piplup.getTrainer());
    }

    @Test
    public void getPKMObject1() {
        assertNull(piplup.getPKMObject());
    }

    @Test
    public void setPkmObject() {
        piplup.setPkmObject(object);
        assertEquals(object, piplup.getPKMObject());
    }

    @Test
    public void getPhase() {
        assertEquals(phase, this.piplup.getPhase());
    }

    @Test
    public void isAlive() {
        assertTrue(piplup.isAlive());
        piplup.setHp(0);
        assertFalse(piplup.isAlive());
    }

    @Test
    public void getNextAbility1() {
        assertEquals(0, piplup.getNextAbility());
    }

    @Test
    public void setNextAbility1() {
        piplup.setNextAbility(-1);
        assertEquals(0, piplup.getNextAbility());
    }

    @Test
    public void setNextAbility2() {
        piplup.setNextAbility(7);
        assertEquals(0, piplup.getNextAbility());
    }

    @Test
    public void setNextAbility3() {
        piplup.setNextAbility(1);
        assertEquals(1, piplup.getNextAbility());
    }

    @Test
    public void useAbility1() {
        piplup.setNextAbility(1);
        piplup.useAbility();
        assertTrue(effect.checkCounts(0, 0));
    }

    @Test
    public void addFightingEnergy() {
        piplup.addFightingEnergy();
        assertEquals(1, (int) piplup.getEnergies().get("Fighting"));
    }

    @Test
    public void useAbility2() {
        piplup.setNextAbility(1);
        piplup.addFireEnergy();
        piplup.useAbility();
        assertTrue(effect.checkCounts(1, 1));
    }

    @Test
    public void addFireEnergy() {
        piplup.addFireEnergy();
        assertEquals(1, (int) piplup.getEnergies().get("Fire"));
    }

    @Test
    public void addLightningEnergy() {
        piplup.addLightningEnergy();
        assertEquals(1, (int) piplup.getEnergies().get("Lightning"));
    }

    @Test
    public void addPlantEnergy() {
        piplup.addPlantEnergy();
        assertEquals(1, (int) piplup.getEnergies().get("Plant"));
    }

    @Test
    public void addPsychicEnergy() {
        piplup.addPsychicEnergy();
        assertEquals(1, (int) piplup.getEnergies().get("Psychic"));
    }

    @Test
    public void addWaterEnergy() {
        piplup.addWaterEnergy();
        assertEquals(1, (int) piplup.getEnergies().get("Water"));
    }

    @Test
    public void notifyType() {
        NullGame game = new NullGame();
        piplup.notifyType(game);
        assertTrue(game.playPokemonCalled());
    }

    @Test
    public void acceptVisitor() {
        NullVisitor visitor = new NullVisitor();
        piplup.acceptVisitor(visitor);
        assertTrue(visitor.visitPokemonCalled());
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

    private class NullGame extends Game {
        private boolean play_pkmn_called;

        NullGame() {
            super(new Trainer(new ArrayList<>()), new Trainer(new ArrayList<>()));
            this.play_pkmn_called = false;
        }

        @Override
        public void playPokemon(IPokemon pkm) {
            this.play_pkmn_called = true;
        }

        boolean playPokemonCalled() {
            return this.play_pkmn_called;
        }
    }

    private class NullVisitor implements IVisitor {

        private boolean visit_pkmn_called;

        NullVisitor() {
            this.visit_pkmn_called = false;
        }

        @Override
        public void visitPokemon(IPokemon pokemon) {
            this.visit_pkmn_called = true;
        }

        @Override
        public void visitTrainer(Trainer trainer) {
        }

        boolean visitPokemonCalled() {
            return this.visit_pkmn_called;
        }

    }
}