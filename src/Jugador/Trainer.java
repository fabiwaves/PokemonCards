 /**
 * @author Fabiwave
 */

 package Jugador;
import Cartas.AbstractCard;
import Cartas.IPokemon;

import java.util.ArrayList;

public class Trainer implements Player {

    private IPokemon activePokemon;
    private ArrayList<IPokemon> team;
    private ArrayList<AbstractCard> hand;

    public Trainer() {
        this.activePokemon = null;
        this.team = null;
        this.hand = null;
    }

    public IPokemon getActivePokemon() {
        return activePokemon;
    }

    public ArrayList getAbilities() {
        return activePokemon.getAttacks();
    }

    public ArrayList<AbstractCard> getHand() {
        return hand;
    }

    public ArrayList<IPokemon> getTeam() {
        return team;
    }

    public void setActivePokemon(IPokemon activePokemon) {
        this.activePokemon = activePokemon;
    }

    public void setTeam(ArrayList<IPokemon> team) {
        for (int i = 0;i<team.size();i++){
            IPokemon pokemon = team.get(i);
            this.team.add(pokemon);
        }
    }

    public void setHand(ArrayList<IPokemon> hand) {
        for (int i = 0; i < hand.size();i++){
            IPokemon pokemon = hand.get(i);
            addPokemonToTeam(pokemon);
        }
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

    public void addPokemonToTeam(IPokemon pokemon){
        if (this.team.size() < 5){
            this.team.add(pokemon);
            this.hand.remove((AbstractCard) pokemon);
        }
    }

    public void selectAttack(int index){
        activePokemon.setNextAttack(index);
    }

    public void attackEnemy(Player adversary){
        activePokemon.attackTrainer(adversary);
    }

    public void play(AbstractCard card) {
        card.setTrainer(this);
        card.play();
    }

}
