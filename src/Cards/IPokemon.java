package Cards;

import Cards.Phases.AbstractPhase;
import Cards.TrainerCards.PKMObject;
import Abilities.Abilities.AbstractAbility;
import Players.Trainer;
import Types.Type;
import Visitors.IVisitable;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author fabiwave
 */

public interface IPokemon extends ICard, IVisitable {

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
     * Sets the hp for a pokemon
     *
     * @param hp new value of hp
     */
    void setHp(int hp);

    /**
     * Gives the maximum hp that a pokemon can have
     *
     * @return the max_hp
     */
    int getMax_hp();

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
     *
     * @return the object that its associated to this pokemon
     */
    PKMObject getPKMObject();

    /**
     * Sets an object to a pokemon
     *
     * @param pkmObject object that has to be set
     */
    void setPkmObject(PKMObject pkmObject);

    /**
     * Gives the phase of the pokemon
     *
     * @return phase of the pokemon
     */
    AbstractPhase getPhase();

    /**
     * Gives if the pokemon is alive
     *
     * @return true is the pokemon hp is greater than 0 and false otherwise
     */
    boolean isAlive();

    /**
     * Set the next ability of a pokemon
     *
     * @param index of the attack that want to be used
     */
    void setNextAbility(int index);

    /**
     * Get the next ability index of a pokemon
     *
     * @return index of the next ability to be used by a pokemon
     */
    int getNextAbility();

    /**
     * Makes the action of using an ability
     */
    void useAbility();

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
