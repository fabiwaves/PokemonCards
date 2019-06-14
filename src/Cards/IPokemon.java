package Cards;

import Cards.TrainerCards.PKMObject;
import Other.AbstractAbility;
import Other.Attack;
import Players.Player;
import Players.Trainer;
import Types.Type;

import java.util.ArrayList;
import java.util.HashMap;


public interface IPokemon extends ICard {

    /**
     * Gives the id of the pokemon
     *
     * @return the id of the pokemon
     */
    int getId();

    /**
     * Gives the hp of the pokemon
     *
     * @return the hp of the pokemon
     */
    int getHp();

    /**
     * Gives the collection of abilites of a pokemon
     *
     * @return abilities of the pokemon
     */
    ArrayList<AbstractAbility> getAbilities();

    /**
     * Gives the energies associated to the pokemon
     *
     * @return the energies of the pokemon
     */
    HashMap<String, Integer> getEnergies();

    /**
     * Gives the type of the pokemon
     *
     * @return the type of the pokemon
     */
    Type getType();

    /**
     * Changes the trainer of the pokemon
     *
     * @param trainer new amount of hp
     */
    void setTrainer(Trainer trainer);

    /**
     * Gives the object associated to the pokemon
     * @return the object that its associated to this pokemon
     */
    PKMObject getPKMObject();

    /**
     * Sets an object to a pokemon
     * @param pkmObject object that has to be set
     */
    void setPkmObject(PKMObject pkmObject);

    /**
     * Gives if the pokemon is alive
     *
     * @return true is the pokemon hp is greater than 0 and false otherwise
     */
    boolean isAlive();

    /**
     * Simulates being attacked by other pokemon
     *
     * @param attacker Cards.Pokemon
     * @param move     move
     * @return true if the pokemon is still alive, false otherwise
     */
    boolean getAttacked(Pokemon attacker, AbstractAbility move);

    /**
     * Set the next ability of a pokemon
     * @param index of the attack that want to be used
     */
    void setNextAbility(int index);

    /**
     * Attacks a trainer
     * @param adversary player that it is going to attack to
     */
    void attackTrainer(Player adversary);

    /**
     * Adds a fighting energy to the pokemon
     */
    void addFightingEnergy();

    /**
     * Adds a fire energy to the pokemon
     */
    void addFireEnergy();

    /**
     * Adds a lighting energy to the pokemon
     */
    void addLightningEnergy();

    /**
     * Adds a plat energy to the pokemon
     */
    void addPlantEnergy();

    /**
     * Adds a physic energy to the pokemon
     */
    void addPsychicEnergy();

    /**
     * Adds a water energy to the pokemon
     */
    void addWaterEnergy();
}
