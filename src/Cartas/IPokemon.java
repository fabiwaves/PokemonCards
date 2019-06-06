package Cartas;

import Other.Attack;
import Types.Type;
import Jugador.Player;
import Jugador.Trainer;

import java.util.ArrayList;

// TODO: extends ICard

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
    public ArrayList<Attack> getAttacks();

    /**
     * Gives the energies associated to the pokemon
     *
     * @return the energies of the pokemon
     */
    public int[] getEnergies();

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

    void setNextAttack(int index);

    void attackTrainer(Player adversary);

    void addFightingEnergy(IEnergy energy);

    void addFireEnergy(IEnergy energy);

    void addLightningEnergy(IEnergy energy);

    void addPlantEnergy(IEnergy energy);

    void addPsychicEnergy(IEnergy energy);

    void addWaterEnergy(IEnergy energy);
}
