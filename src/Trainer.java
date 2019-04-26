import java.util.ArrayList;

public class Trainer implements Player {

    protected Pokemon activePokemon;
    protected ArrayList<Pokemon> team;
    protected ArrayList<Pokemon> hand;

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
        this.team = team;
    }

    public void setHand(ArrayList<Pokemon> hand) {
        this.hand = hand;
    }

}
