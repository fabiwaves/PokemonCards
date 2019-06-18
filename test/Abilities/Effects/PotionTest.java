package Abilities.Effects;

import Cards.ICard;
import Cards.IPokemon;
import Cards.Pokemon;
import Cards.TrainerCards.Support;
import Players.Trainer;
import Visitors.IVisitor;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class PotionTest {

    private TestTrainer trainer;
    private Potion potion;
    private NullPokemon pokemon;

    @Before
    public void setUp() {
        pokemon = new NullPokemon(trainer);
        trainer = new TestTrainer(new ArrayList<>(), pokemon);
        pokemon.setTrainer(trainer);
        potion = new Potion();
        Support potion_support = new Support(potion);
        potion_support.setTrainer(trainer);
        potion.setSupport(potion_support);
        pokemon.setHp(1);
    }

    @Test
    public void executeBefore() {
        potion.executeBefore();
        System.out.println(pokemon);
        assertTrue(pokemon.beenVisited());
    }

    @Test
    public void executeAfter() {
        // This method does nothing
        potion.executeAfter();
        assertTrue(true);
    }

    @Test
    public void visitPokemon() {
        int current_hp = pokemon.getHp();
        potion.visitPokemon(pokemon);
        assertTrue(current_hp < pokemon.getHp());
    }

    @Test
    public void visitTrainer() {
        // This method does nothing
        potion.visitTrainer(trainer);
        assertTrue(true);
    }

    private class NullPokemon extends Pokemon {

        private boolean been_visited;

        NullPokemon(Trainer trainer) {
            super("test", 1, 40, new ArrayList<>(), null, trainer, null);
            this.been_visited = false;
        }

        @Override
        public void acceptVisitor(IVisitor visitor) {
            System.out.println("visited");
            System.out.println(this);
            this.been_visited = true;
        }

        boolean beenVisited() {
            return this.been_visited;
        }

    }

    class TestTrainer extends Trainer {

        private IPokemon pokemon;

        TestTrainer(ArrayList<ICard> deck, IPokemon pokemon) {
            super(deck);
            this.pokemon = pokemon;
        }

        @Override
        public IPokemon selectOwnPokemonTarget() {
            return this.pokemon;
        }
    }
}