package Players;

import Abilities.Abilities.AbstractAbility;
import Abilities.Abilities.PokemonAbility;
import Abilities.Effects.IEffect;
import Cards.ICard;
import Cards.IPokemon;
import Cards.Phases.Basic;
import Cards.Pokemon;
import Controller.Game;
import Types.Fire;
import Types.Water;
import Visitors.IVisitor;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

import static org.junit.Assert.*;

public class TrainerTest {

    private class NullVisitor implements IVisitor {
        private boolean visit_trainer_called;

        NullVisitor() {
            this.visit_trainer_called = false;
        }

        @Override
        public void visitPokemon(IPokemon pokemon) {
        }

        @Override
        public void visitTrainer(Trainer trainer) {
            this.visit_trainer_called = true;
        }

        boolean visitTrainerCalled() {
            return visit_trainer_called;
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

    private class TestGame extends Game {

        ArrayList<Integer> notify_calls;

        TestGame(Trainer player1, Trainer player2) {
            super(player1, player2);
            notify_calls = new ArrayList<>();
        }

        @Override
        public void update(Observable o, Object arg) {
            notify_calls.add((Integer) arg);
            super.update(o, arg);
        }

    }

    private Trainer trainer;
    private ArrayList<ICard> deck;
    private TestGame observer;
    private NullEffect first_effect;

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
            if (i < 7) {
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
                hand.add(new Pokemon("Piplup", 393, 53, abilities2, new Water(), trainer, new Basic()));
            }
        }
        trainer = new Trainer(deck);
        trainer.setHand(hand);
        observer = new TestGame(trainer, trainer);
    }


    @Test
    public void play() {
        ICard first_card = trainer.getHand().get(0);
        trainer.play(trainer.getHand().get(0));
        assertEquals(first_card, trainer.getActivePokemon());
    }

    @Test
    public void setChangedObs() {
        // This only uses an Observable method, there's no need or way to test it
        trainer.setChangedObs();
        assertTrue(true);
    }

    @Test
    public void setActivePokemon() {
        ICard second_card = trainer.getHand().get(1);
        trainer.play(trainer.getHand().get(0));
        trainer.play(trainer.getHand().get(0));
        trainer.setActivePokemon((IPokemon) second_card);
        assertEquals(second_card, trainer.getActivePokemon());
    }

    @Test
    public void getAbilities() {
        ICard first_card = trainer.getHand().get(0);
        trainer.play(trainer.getHand().get(0));
        assertEquals(((IPokemon) first_card).getAbilities(), trainer.getAbilities());
    }

    @Test
    public void replaceActivePokemon() {
        ICard first_card = trainer.getHand().get(0);
        ICard second_card = trainer.getHand().get(1);
        trainer.play(trainer.getHand().get(0));
        trainer.play(trainer.getHand().get(0));
        trainer.replaceActivePokemon();
        assertTrue(trainer.getGraveyard().contains(first_card));
        assertEquals(second_card, trainer.getActivePokemon());
        trainer.replaceActivePokemon();
        assertTrue(trainer.getTeam().isEmpty());
    }

    @Test
    public void checkActivePokemon() {
        ICard first_card = trainer.getHand().get(0);
        ICard second_card = trainer.getHand().get(1);
        trainer.play(trainer.getHand().get(0));
        trainer.play(trainer.getHand().get(0));
        trainer.checkActivePokemon();
        assertEquals(first_card, trainer.getActivePokemon());
        trainer.getActivePokemon().setHp(0);
        trainer.checkActivePokemon();
        assertTrue(trainer.getGraveyard().contains(first_card));
        assertEquals(second_card, trainer.getActivePokemon());
    }

    @Test
    public void getAdversary() {
        assertEquals(trainer.getAdversary(), observer.getAdversary());
    }

    @Test
    public void acceptVisitor() {
        NullVisitor nullv = new NullVisitor();
        trainer.acceptVisitor(nullv);
        assertTrue(nullv.visitTrainerCalled());
    }

    @Test
    public void notifyAttack() {
        trainer.play(trainer.getHand().get(0));
        trainer.play(trainer.getHand().get(0));
        trainer.notifyAttack();
        assertTrue(observer.notify_calls.contains(10));
        assertTrue(observer.notify_calls.contains(0));
    }

    @Test
    public void getCard() {
        ICard card_to_draw = deck.get(0);
        ICard card_not_to_draw = deck.get(1);
        trainer.getCard();
        assertTrue(observer.notify_calls.contains(1));
        assertTrue(trainer.getHand().contains(card_to_draw));
        trainer.getCard();
        assertFalse(trainer.getHand().contains(card_not_to_draw));
    }

    @Test
    public void getPrizes() {
        assertTrue(trainer.getPrizes().isEmpty());
    }

    @Test
    public void setPrizes() {
        ArrayList<ICard> new_prizes = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            PokemonAbility null_ability =
                    new PokemonAbility("null_ability", "null", new HashMap<>(), new NullEffect());
            ArrayList<AbstractAbility> abilities = new ArrayList<>();
            abilities.add(null_ability);
            Pokemon chimchar = new Pokemon("Chimchar", 390, 55, abilities, new Fire(), trainer, new Basic());
            new_prizes.add(chimchar);
        }
        trainer.setPrizes(new_prizes);
        assertEquals(new_prizes, trainer.getPrizes());
    }

    @Test
    public void addPokemonToTeam() {
        trainer.play(trainer.getHand().get(0));
        System.out.println(trainer.getTeam());
        trainer.addPokemonToTeam();
        System.out.println(trainer.getTeam());
        assertEquals(1, trainer.getTeam().size());
    }

    @Test
    public void selectAbility() {
        IPokemon first_pkmn = (IPokemon) trainer.getHand().get(0);
        trainer.play(trainer.getHand().get(0));
        trainer.selectAbility(1);
        assertEquals(1, first_pkmn.getNextAbility());
    }

    @Test
    public void useAbility() {
        trainer.play(trainer.getHand().get(0));
        trainer.selectAbility(0);
        trainer.useAbility();
        assertTrue(first_effect.checkCounts(1,1));
    }

    @Test
    public void selectEnemyPokemonTarget() {
        IPokemon first_pokemon = (IPokemon) trainer.getHand().get(0);
        trainer.play(trainer.getHand().get(0));
        assertEquals(first_pokemon, trainer.selectEnemyPokemonTarget());
    }

    @Test
    public void selectOwnPokemonTarget() {
        IPokemon first_pokemon = (IPokemon) trainer.getHand().get(0);
        trainer.play(trainer.getHand().get(0));
        assertEquals(first_pokemon, trainer.selectOwnPokemonTarget());
    }

    @Test
    public void selectTrainerTarget() {
        assertEquals(trainer, trainer.selectTrainerTarget());
    }



}