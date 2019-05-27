package Cartas; /**
 * @author Fabiwave
 */

import java.util.ArrayList;

public class Trainer implements Player {

    private Pokemon activePokemon;
    private ArrayList<Pokemon> team;
    private ArrayList<Pokemon> hand;

    public Trainer() {
    }

    public Pokemon getActivePokemon() {
        return activePokemon;
    }

    public ArrayList<Pokemon> getHand() {
        return hand;
    }

    public ArrayList<Pokemon> getTeam() {
        return team;
    }

    public void setActivePokemon(Pokemon activePokemon) {
        this.activePokemon = activePokemon;
    }

    public void setTeam(ArrayList<Pokemon> team) {
        for (int i = 0;i<team.size();i++){
            Pokemon pokemon = team.get(i);
            this.team.add(pokemon);
        }
    }

    public void setHand(ArrayList<Pokemon> hand) {
        for (int i = 0; i < hand.size();i++){
            Pokemon pokemon = hand.get(i);
            addPokemon(pokemon);
        }
    }

    public void changeActivePokemon() {

        int i = team.lastIndexOf(activePokemon);
        if (i <= 4) {
            Pokemon nextPokemon = team.get(i + 1);
            setActivePokemon(nextPokemon);
        } else {
            setActivePokemon(null);
        }

    }

    public void addPokemon(Pokemon pokemon){
        if (this.hand.size() < 5){
            this.hand.add(pokemon);
        }
    }

    public void play(AbstractCard card) {
        card.setTrainer(this);
        card.play();
    }

}
