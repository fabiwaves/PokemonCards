package Players;

import Cards.ICard;
import Cards.IPokemon;
import Controller.Game;
import Visitors.IVisitable;
import Visitors.IVisitor;

import java.util.ArrayList;
import java.util.Observable;

/**
 * @author fabiwave
 */

public class Trainer extends Observable implements IVisitable {

    private ArrayList<IPokemon> team;
    private ArrayList<ICard> hand;
    private ArrayList<ICard> deck;
    private ArrayList<ICard> graveyard;
    private ArrayList<ICard> prizes;
    private Game observer;
    private ICard cardToPlay;

    public Trainer(ArrayList<ICard> deck) {
        this.team = new ArrayList<>();
        this.hand = new ArrayList<>();
        this.graveyard = new ArrayList<>();
        this.prizes = new ArrayList<>();
        if (deck.size() == 60) {
            this.deck = deck;
        }
        this.observer = null;
        this.cardToPlay = null;
    }

    ArrayList<ICard> getGraveyard() {
        return this.graveyard;
    }

    public IPokemon getActivePokemon() {
        return this.team.get(0);
    }

    public void setObserver(Game game) {
        this.observer = game;
    }

    public void setChangedObs() {
        this.setChanged();
    }

    void setActivePokemon(IPokemon activePokemon) {
        int pkm_index = this.team.indexOf(activePokemon);
        IPokemon current_active = this.team.get(0);
        this.team.set(0, activePokemon);
        this.team.set(pkm_index, current_active);
    }

    public ArrayList getAbilities() {
        return this.team.get(0).getAbilities();
    }

    public ArrayList<ICard> getHand() {
        return hand;
    }

    public void setHand(ArrayList<ICard> hand) {
        this.hand = hand;
    }

    public ArrayList<ICard> getDeck() {
        return deck;
    }

    public ArrayList<IPokemon> getTeam() {
        return team;
    }

    public void replaceActivePokemon() {
        int remaining_pkm = this.team.size() - 1;
        this.sendToGraveyard(this.team.get(0), this.team);
        if (remaining_pkm <= 0) {
            this.setChanged();
            notifyObservers(-1);
        }
    }

    public void addPokemonToTeam() {
        IPokemon pkm = (IPokemon) this.cardToPlay;
        if (this.team.size() < 6 && this.cardToPlay != null) {
            this.team.add(pkm);
            this.hand.remove(pkm);
        }
    }

    void selectAbility(int index) {
        this.team.get(0).setNextAbility(index);
    }

    public void useAbility() {
        this.team.get(0).useAbility();
    }

    public IPokemon selectOwnPokemonTarget() {
        // TODO (Not in this version): Show pokemons to the player
        int index = 0; // TODO (Not in this version): Get player input
        return this.team.get(index);
    }

    IPokemon selectEnemyPokemonTarget() {
        ArrayList<IPokemon> enemy_team = this.observer.getAdversaryPokemon();
        int index = 0; // TODO (Not in this version): Get player input
        return enemy_team.get(index);
    }

    Trainer selectTrainerTarget() {
        Trainer target = this;
        boolean select_enemy = true; // TODO (Not in this version): Get trainer input
        if (select_enemy) {
            target = this.observer.getAdversary();
        }
        return target;
    }

    public void playACard() {
        if (this.cardToPlay != null) {
            this.cardToPlay.notifyType(this.observer);
        }
        this.cardToPlay = null;
    }

    public void play(ICard card) {
        card.setTrainer(this);
        this.cardToPlay = card;
        this.setChanged();
        this.notifyObservers(5);
    }

    void checkActivePokemon() {
        if (!this.team.get(0).isAlive()) {
            this.replaceActivePokemon();
        }
    }

    public Trainer getAdversary() {
        return this.observer.getAdversary();
    }

    public <T> void sendToGraveyard(T card, ArrayList<T> place) {
        place.remove(card);
        this.graveyard.add((ICard) card);
    }

    @Override
    public void acceptVisitor(IVisitor visitor) {
        visitor.visitTrainer(this);
    }

    public void notifyAttack() {
        // Attacks are notified with 10 argument
        this.setChanged();
        notifyObservers(10);
        // End turn automatically
        endTurn();
    }

    private void endTurn() {
        this.setChanged();
        notifyObservers(0);
    }

    void getCard() {
        this.setChanged();
        notifyObservers(1);
    }

    ArrayList<ICard> getPrizes() {
        return prizes;
    }

    void setPrizes(ArrayList<ICard> prizes) {
        this.prizes = prizes;
    }
}
