package Players;

import Cards.ICard;
import Cards.IPokemon;
import Controller.Game;
import Visitors.IVisitable;
import Visitors.IVisitor;

import java.util.ArrayList;
import java.util.Observable;

public class Trainer extends Observable implements Player, IVisitable {

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

    public IPokemon getActivePokemon() {
        return this.team.get(0);
    }

    public void setActivePokemon(IPokemon activePokemon) {
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

    public void setHand(ArrayList<IPokemon> hand) {
        // TODO: WAT
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
            notifyObservers(-1);
        }
    }

    public void addPokemonToTeam() {
        try {
            IPokemon pkm = (IPokemon) this.cardToPlay;
            if (this.team.size() < 6) {
                this.team.add(pkm);
                this.hand.remove(pkm);
            }
        } catch (Exception e) {
            // To stop unauthorized executions
            return;
        }
    }

    public void selectAbility(int index) {
        this.team.get(0).setNextAbility(index);
    }

    public void useAbility(int index) {
        this.team.get(0).useAbility();
    }

    public IPokemon selectOwnPokemonTarget() {
        // TODO (Not in this version): Show pokemons to the player
        int index = 0; // TODO (Not in this version): Get player input
        return this.team.get(index);
    }

    public IPokemon selectEnemyPokemonTarget() {
        ArrayList<IPokemon> enemy_team = this.observer.getAdversaryPokemon();
        int index = 0; // TODO (Not in this version): Get player input
        return enemy_team.get(index);
    }

    public Player selectTrainerTarget() {
        Player target = this;
        boolean select_enemy = true; // TODO (Not in this version): Get trainer input
        if (select_enemy) {
            target = this.observer.getAdversary();
        }
        return target;
    }

    public void playACard() {
        if (this.cardToPlay != null) {
            cardToPlay.notifyType(this.observer);
        }
        this.cardToPlay = null;
    }

    public void play(ICard card) {
        card.setTrainer(this);
        this.cardToPlay = card;
        notifyObservers(5);
    }

    public void checkActivePokemon() {
        if (!this.team.get(0).isAlive()) {
            this.replaceActivePokemon();
        }
    }

    public Player getAdversary() {
        return this.observer.getAdversary();
    }

    /**
     * Sends a card from any place to the cemetery pile
     *
     * @param card  Card that you want to send to the graveyard
     * @param place Location of the card
     */
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
        notifyObservers(10);
        // End turn automatically
        endTurn();
    }

    public void getCard(){
        notifyObservers(1);
    }

    public void endTurn(){notifyObservers(0);}
}
