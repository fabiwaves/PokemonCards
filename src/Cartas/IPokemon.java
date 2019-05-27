package Cartas;

import Ataques.Type;
import Jugador.Trainer;

import java.util.ArrayList;

public interface IPokemon {

    /**
     * Gives the id of the pokemon
     *
     * @return the id of the pokemon
     */
    public int getId();

    /**
     * Gives the hp of the pokemon
     *
     * @return the hp of the pokemon
     */
    public int getHp();

    /**
     * Gives the collection of abilites of a pokemon
     *
     * @return abilities of the pokemon
     */
    public ArrayList getAbilities();

    /**
     * Gives the energies associated to the pokemon
     *
     * @return the energies of the pokemon
     */
    public ArrayList getEnergies();

    /**
     * Gives the type of the pokemon
     *
     * @return the type of the pokemon
     */
    public Type getType();

    /**
     * Changes the hp of the pokemon
     *
     * @param hp new amount of hp
     */
    public void setHp(int hp);

    /**
     * Changes the trainer of the pokemon
     *
     * @param trainer new amount of hp
     */
    public void setTrainer(Trainer trainer);

    /**
     * Gives if the pokemon is alive
     *
     * @return true is the pokemon hp is greater than 0 and false otherwise
     */
    public boolean isAlive();

    /**
     * Simulates being attacked by other pokemon
     *
     * @param attacker Cartas.Pokemon
     * @param move     move
     * @return true if the pokemon is still alive, false otherwise
     */
    public boolean getAttacked(Pokemon attacker, Attack move);

}
