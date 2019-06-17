package Players;

import Cards.ICard;
import Cards.IPokemon;
import Controller.Game;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TrainerTest {
    private Trainer trainer;
    private ArrayList<IPokemon> team;
    private ArrayList<ICard> hand;
    private ArrayList<ICard> deck;
    private ArrayList<ICard> graveyard;
    private ArrayList<ICard> prizes;
    private Game observer;
    private ICard cardToPlay;

    @Before
    public void setUp(){
        deck = new ArrayList<>();
    }

    @Test
    public void getActivePokemon() {
    }

    @Test
    public void setActivePokemon() {
    }

    @Test
    public void getAbilities() {
    }

    @Test
    public void getHand() {
    }

    @Test
    public void setHand() {
    }

    @Test
    public void getDeck() {
    }

    @Test
    public void getTeam() {
    }

    @Test
    public void replaceActivePokemon() {
    }

    @Test
    public void addPokemonToTeam() {
    }

    @Test
    public void selectAbility() {
    }

    @Test
    public void useAbility() {
    }

    @Test
    public void selectOwnPokemonTarget() {
    }

    @Test
    public void selectEnemyPokemonTarget() {
    }

    @Test
    public void selectTrainerTarget() {
    }

    @Test
    public void playACard() {
    }

    @Test
    public void play() {
    }

    @Test
    public void checkActivePokemon() {
    }

    @Test
    public void getAdversary() {
    }

    @Test
    public void sendToGraveyard() {
    }

    @Test
    public void acceptVisitor() {
    }

    @Test
    public void notifyAttack() {
    }

    @Test
    public void endTurn() {
    }

    @Test
    public void getCard() {
    }
}