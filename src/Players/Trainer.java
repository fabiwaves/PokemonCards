package Players;

import Cards.ICard;
import Cards.IPokemon;
import Visitors.IVisitable;
import Visitors.IVisitor;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Trainer extends Observable implements Player, IVisitable {

    private IPokemon activePokemon;
    private ArrayList<IPokemon> team;
    private ArrayList<ICard> hand;
    private ArrayList<ICard> deck;
    private ArrayList<ICard> graveyard;
    private ArrayList<ICard> prizes;
    private Observer observer;
    private Trainer trainer_target;
    private IPokemon pokemon_target;

    public Trainer(ArrayList<ICard> deck) {
        this.activePokemon = null;
        this.team = new ArrayList<>();
        this.hand = new ArrayList<>();
        this.graveyard = new ArrayList<>();
        this.prizes =  new ArrayList<>();
        if(deck.size()==60){
            this.deck = deck;
        }
        this.observer = null;
        this.pokemon_target = null;
        this.trainer_target = null;
    }

    public IPokemon getActivePokemon() {
        return activePokemon;
    }

    public void setActivePokemon(IPokemon activePokemon) {
        this.activePokemon = activePokemon;
    }

    public ArrayList getAbilities() {
        return activePokemon.getAbilities();
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
        activePokemon.setNextAbility(index);
    }

    public void attackEnemy(Player adversary) {
        activePokemon.attackTrainer(adversary);
    }

    public void setTrainer_target(Trainer trainer){
        this.trainer_target = trainer;
    }

    public void setPokemon_target(IPokemon pokemon){
        this.pokemon_target = pokemon;
    }

    public IPokemon getPokemon_target(){
        return this.pokemon_target;
    }

    public Trainer getTrainer_target(){
        return this.trainer_target;
    }

    public void play(ICard card) {
        card.setTrainer(this);
        /* card.play(this.nextTarget);
        this.nextTarget = null;
        notifyObservers(card);
        // todo: notifyObservers(1); */
    }

    public void checkActivePokemon() {
        if (!this.activePokemon.isAlive()) {
            this.changeActivePokemon();
        }
    }

    public void sendToGraveyard(ICard card, ArrayList<ICard> place){
        place.remove(card);
        this.graveyard.add(card);
    }

    @Override
    public void acceptVisitor(IVisitor visitor) {
        visitor.visitTrainer(this);
    }
}
