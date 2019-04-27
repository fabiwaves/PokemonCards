/**
 * @author Fabiwave
 */

import java.util.ArrayList;

public class Pokemon implements Card {

    protected String name;
    protected int id;
    protected int hp;
    protected ArrayList abilities;
    protected ArrayList energies;
    protected Type type;

    public Pokemon(String name, int id, int hp, ArrayList abilities, ArrayList energies, Type type) {
        this.name = name;
        this.id = id;
        this.hp = hp;
        this.abilities = abilities;
        this.energies = energies;
        this.type = type;
    }

    /**
     * Gives the name of the pokemon
     *
     * @return the name of the pokemon
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Gives the id of the pokemon
     *
     * @return the id of the pokemon
     */
    public int getId() {
        return id;
    }

    /**
     * Gives the hp of the pokemon
     *
     * @return the hp of the pokemon
     */
    public int getHp() {
        return hp;
    }

    /**
     * Gives the collection of abilites of a pokemon
     *
     * @return abilities of the pokemon
     */
    public ArrayList getAbilities() {
        return abilities;
    }

    /**
     * Gives the energies associated to the pokemon
     *
     * @return the energies of the pokemon
     */
    public ArrayList getEnergies() {
        return energies;
    }

    /**
     * Gives the type of the pokemon
     *
     * @return the type of the pokemon
     */
    public Type getType() {
        return type;
    }

    /**
     * Changes the hp of the pokemon
     *
     * @param hp new amount of hp
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * Gives if the pokemon is alive
     *
     * @return true is the pokemon hp is greater than 0 and false otherwise
     */
    public boolean isAlive() {
        return (this.hp > 0);
    }

    /**
     * Simulates being attacked by other pokemon
     *
     * @param attacker Pokemon
     * @param move     move
     * @return true if the pokemon is still alive, false otherwise
     */
    public boolean getAttacked(Pokemon attacker, Attack move) {
        int effectiveDamage = this.type.calcDamage(attacker.type, move.getDamage());
        this.hp -= (int) effectiveDamage;


        if (this.hp <= 0) {
            this.setHp(0);
            return true;
        }

        return false;
    }

    /**
     * Check if the pokemon has the necessary energies to do the attack
     * @param pokemon pokemon to which I want to check the condition
     * @param move move to which I want to check the condition
     * @return true if it has the necessary energy, false otherwise
     */
    public boolean checkEnergy(Pokemon pokemon, Attack move) {

        boolean cond = true;
        ArrayList<Energy> auxEnergy = pokemon.getEnergies();
        String[] listOfTypes = {"Fighting", "Fire,", "Lighting", "Plant", "Psychic", "Water"};

        for (int i = 0; i < 6; i++) {
            int energiesInPokemon = countRep(auxEnergy, listOfTypes[i]);
            int costOfEnergy = move.getCost(listOfTypes[1]);

            if (costOfEnergy == energiesInPokemon) {
                cond = true;
            } else {
                cond = false;
            }
        }

        return cond;
    }

    /**
     * Counts the repetition of a String in an ArrayList
     *
     * @param array ArrayListi we want to check
     * @param type  String we want to count
     * @return amount of repetitions of the string in the ArrayList
     */
    public int countRep(ArrayList<Energy> array, String type) {
        int count = 0;
        for (int i = 0; i < array.size(); i++) {
            Energy energy = array.get(i);
            String compare = energy.getType();

            if (compare == type)
                count++;
        }
        return count;
    }
}