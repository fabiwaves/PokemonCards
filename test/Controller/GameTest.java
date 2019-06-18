package Controller;

import Abilities.Abilities.AbstractAbility;
import Abilities.Abilities.PokemonAbility;
import Abilities.Effects.IEffect;
import Abilities.Effects.LuckyStadium;
import Cards.Energies.*;
import Cards.ICard;
import Cards.IPokemon;
import Cards.Phases.Basic;
import Cards.Phases.Phase1;
import Cards.Pokemon;
import Cards.TrainerCards.PKMObject;
import Cards.TrainerCards.Stadium;
import Cards.TrainerCards.Support;
import Players.Trainer;
import Types.Water;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class GameTest {

    private Trainer trainer;
    private ArrayList<ICard> deck;
    private Game observer;
    private NullEffect first_effect;
    private Stadium stadium;

    @Before
    public void setUp() {
        deck = new ArrayList<>();
        ArrayList<ICard> hand = new ArrayList<>();
        for (int i = 0; i < 60; i++) {
            PokemonAbility null_ability =
                    new PokemonAbility("null_ability", "null", new HashMap<>(), new NullEffect());
            ArrayList<AbstractAbility> abilities = new ArrayList<>();
            abilities.add(null_ability);
            Pokemon piplup = new Pokemon("Piplup", 393, 53, abilities, new Water(), trainer, new Basic());
            deck.add(piplup);
            if (i < 5) {
                ArrayList<AbstractAbility> abilities2 = new ArrayList<>();
                PokemonAbility null_ability1;
                if (i == 0) {
                    first_effect = new NullEffect();
                    null_ability1 =
                            new PokemonAbility("null_ability", "null", new HashMap<>(), first_effect);
                } else {
                    null_ability1 =
                            new PokemonAbility("null_ability", "null", new HashMap<>(), new NullEffect());
                }
                PokemonAbility null_ability2 =
                        new PokemonAbility("null_ability2", "null", new HashMap<>(), new NullEffect());
                abilities2.add(null_ability1);
                abilities2.add(null_ability2);
                if (i == 1) {
                    hand.add(new Pokemon("Prinplup", 394, 73, abilities2, new Water(), trainer, new Phase1(393)));
                }
                hand.add(new Pokemon("Piplup", 393, 53, abilities2, new Water(), trainer, new Basic()));
            }
        }
        trainer = new Trainer(deck);
        trainer.setHand(hand);
        observer = new Game(trainer, trainer);
        stadium = new Stadium(new LuckyStadium());
    }

    @Test
    public void playStadium() {
        assertNull(observer.getStadium());
        observer.playStadium(stadium);
        assertEquals(stadium, observer.getStadium());
    }

    @Test
    public void playPokemon() {
        IPokemon prinplup = (IPokemon) trainer.getHand().get(1);
        trainer.play(trainer.getHand().get(0));
        trainer.play(trainer.getHand().get(0));
        assertEquals(prinplup, trainer.getActivePokemon());
    }

    @Test
    public void playPKMObject() {
        trainer.play(trainer.getHand().get(0));
        PKMObject pkm_object = new PKMObject(first_effect);
        PKMObject pkm_object2 = new PKMObject(first_effect);
        observer.playPKMObject(pkm_object);
        assertTrue(first_effect.checkCounts(1, 1));
        assertEquals(pkm_object, trainer.getActivePokemon().getPKMObject());
        observer.playPKMObject(pkm_object2);
        assertEquals(pkm_object, trainer.getActivePokemon().getPKMObject());
    }

    @Test
    public void playSupport() {
        Support support = new Support(first_effect);
        observer.playSupport(support);
        assertTrue(first_effect.checkCounts(1, 1));
    }

    @Test
    public void playLightingEnergy() {
        trainer.play(trainer.getHand().get(0));
        LightningEnergy energy = new LightningEnergy();
        energy.setTrainer(trainer);
        trainer.getHand().add(energy);
        observer.playLightningEnergy(energy);
        assertEquals(1, (int) trainer.getActivePokemon().getEnergies().get("Lightning"));
        trainer.getHand().add(energy);
        observer.playLightningEnergy(energy);
        assertEquals(1, (int) trainer.getActivePokemon().getEnergies().get("Lightning"));
    }

    @Test
    public void playFireEnergy() {
        trainer.play(trainer.getHand().get(0));
        FireEnergy energy = new FireEnergy();
        energy.setTrainer(trainer);
        trainer.getHand().add(energy);
        observer.playFireEnergy(energy);
        assertEquals(1, (int) trainer.getActivePokemon().getEnergies().get("Fire"));
        trainer.getHand().add(energy);
        observer.playFireEnergy(energy);
        assertEquals(1, (int) trainer.getActivePokemon().getEnergies().get("Fire"));
    }

    @Test
    public void playFightingEnergy() {
        trainer.play(trainer.getHand().get(0));
        FightingEnergy energy = new FightingEnergy();
        energy.setTrainer(trainer);
        trainer.getHand().add(energy);
        observer.playFightingEnergy(energy);
        assertEquals(1, (int) trainer.getActivePokemon().getEnergies().get("Fighting"));
        trainer.getHand().add(energy);
        observer.playFightingEnergy(energy);
        assertEquals(1, (int) trainer.getActivePokemon().getEnergies().get("Fighting"));
    }

    @Test
    public void playPlantEnergy() {
        trainer.play(trainer.getHand().get(0));
        PlantEnergy energy = new PlantEnergy();
        energy.setTrainer(trainer);
        trainer.getHand().add(energy);
        observer.playPlantEnergy(energy);
        assertEquals(1, (int) trainer.getActivePokemon().getEnergies().get("Plant"));
        trainer.getHand().add(energy);
        observer.playPlantEnergy(energy);
        assertEquals(1, (int) trainer.getActivePokemon().getEnergies().get("Plant"));
    }

    @Test
    public void playPsychicEnergy() {
        trainer.play(trainer.getHand().get(0));
        PsychicEnergy energy = new PsychicEnergy();
        energy.setTrainer(trainer);
        trainer.getHand().add(energy);
        observer.playPsychicEnergy(energy);
        assertEquals(1, (int) trainer.getActivePokemon().getEnergies().get("Psychic"));
        trainer.getHand().add(energy);
        observer.playPsychicEnergy(energy);
        assertEquals(1, (int) trainer.getActivePokemon().getEnergies().get("Psychic"));
    }

    @Test
    public void playWaterEnergy() {
        trainer.play(trainer.getHand().get(0));
        WaterEnergy energy = new WaterEnergy();
        energy.setTrainer(trainer);
        trainer.getHand().add(energy);
        observer.playWaterEnergy(energy);
        assertEquals(1, (int) trainer.getActivePokemon().getEnergies().get("Water"));
        trainer.getHand().add(energy);
        observer.playWaterEnergy(energy);
        assertEquals(1, (int) trainer.getActivePokemon().getEnergies().get("Water"));
    }

    @Test
    public void update() {
        trainer.play(trainer.getHand().get(0));
        // Remembering to skip the Prinplup
        IPokemon second = (IPokemon) trainer.getHand().get(1);
        trainer.play(trainer.getHand().get(1));
        IPokemon third = (IPokemon) trainer.getHand().get(1);
        trainer.play(trainer.getHand().get(1));
        trainer.getActivePokemon().setHp(0);
        observer.update(trainer, 10);
        assertEquals(second, trainer.getActivePokemon());
        trainer.getActivePokemon().setHp(0);
        observer.update(trainer, 15);
        assertEquals(third, trainer.getActivePokemon());
        observer.update(trainer, 100);
        assertTrue(trainer.getHand().isEmpty());
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
}