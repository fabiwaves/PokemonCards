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

    public void changeActivePokemon() {

        int i = team.lastIndexOf(activePokemon);
        if (i <= 4) {
            Pokemon nextPokemon = team.get(i + 1);
            setActivePokemon(nextPokemon);
        } else {
            setActivePokemon(null);
        }

    }

    //todo good implementation of opponent move;
    public void attack(Trainer dude) {
        Pokemon opponent = dude.getActivePokemon();
        Attack opponentMove = (Attack) opponent.getAbilities().get(1);
        activePokemon.getAttacked(opponent, opponentMove);

        if (!activePokemon.isAlive()) {
            changeActivePokemon();
        }

    }

}
