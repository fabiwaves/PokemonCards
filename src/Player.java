import java.util.ArrayList;
public interface Player {

    public Pokemon getActivePokemon();

    public ArrayList<Pokemon> getHand();

    public ArrayList<Pokemon> getTeam();

    public void setActivePokemon(Pokemon activePokemon);

    public void setTeam(ArrayList<Pokemon> team);

    public void setHand(ArrayList<Pokemon> hand);
}
