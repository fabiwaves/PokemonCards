package Players;

import Cards.ICard;
import Cards.IPokemon;

import java.util.ArrayList;

public class Trainer implements Player {

    private IPokemon activePokemon;
    private ArrayList<IPokemon> team;
    private ArrayList<ICard> hand;
    private ArrayList<ICard> deck;
    private ArrayList<ICard> cementery;
    private ArrayList<ICard> prizes;

    public Trainer(ArrayList<ICard> deck) {
        this.activePokemon = null;
        this.team = new ArrayList<>();
        this.hand = new ArrayList<>();
        this.cementery = new ArrayList<>();
        this.prizes =  new ArrayList<>();
        if(deck.size()==60){
            this.deck = deck;
        }
    }

    public IPokemon getActivePokemon() {
        return activePokemon;
    }

    public void setActivePokemon(IPokemon activePokemon) {
        this.activePokemon = activePokemon;
    }

    public ArrayList getAbilities() {
        return activePokemon.getAttacks();
    }

    public ArrayList<ICard> getHand() {
        return hand;
    }

    public void setHand(ArrayList<IPokemon> hand) {
        for (IPokemon pokemon : hand) {
            addPokemonToTeam(pokemon);
        }
    }

    public ArrayList<IPokemon> getTeam() {
        return team;
    }

    public void changeActivePokemon() {

        int i = team.lastIndexOf(activePokemon);
        if (i <= 4) {
            IPokemon nextPokemon = team.get(i + 1);
            setActivePokemon(nextPokemon);
        } else {
            setActivePokemon(null);
        }

    }

    public void addPokemonToTeam(IPokemon pokemon) {
        if (this.team.size() < 5) {
            this.team.add(pokemon);
            this.hand.remove(pokemon);
        }
    }

    public void selectAttack(int index) {
        activePokemon.setNextAttack(index);
    }

    public void attackEnemy(Player adversary) {
        activePokemon.attackTrainer(adversary);
    }

    public void play(ICard card) {
        card.setTrainer(this);
        card.play();
    }

    public void checkActivePokemon() {
        if (!this.activePokemon.isAlive()) {
            this.changeActivePokemon();
        }
    }

    public void sendToCementery(ICard card, ArrayList<ICard> place){
        place.remove(card);
        this.cementery.add(card);
    }

}
