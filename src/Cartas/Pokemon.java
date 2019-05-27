package Cartas; /**
 * @author Fabiwave
 */

import Ataques.Type;
import Jugador.Trainer;

import java.util.ArrayList;

public class Pokemon extends AbstractCard implements IPokemon {

    private String name;
    private int id;
    private int hp;
    private ArrayList abilities;
    private ArrayList energies;
    private Type type;
    private Trainer trainer;

    public Pokemon(String name, int id, int hp, ArrayList abilities, ArrayList energies, Type type, Trainer trainer) {
        this.name = name;
        this.id = id;
        this.hp = hp;
        this.abilities = abilities;
        this.energies = energies;
        this.type = type;
        this.trainer = trainer;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getHp() {
        return hp;
    }

    public ArrayList getAbilities() {
        return abilities;
    }

    public ArrayList getEnergies() {
        return energies;
    }

    public Type getType() {
        return type;
    }

    @Override
    public Trainer getTrainer() {
        return trainer;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public boolean isAlive() {
        return (this.hp > 0);
    }

    public boolean getAttacked(Pokemon attacker, Attack move) {
        int effectiveDamage = this.type.calcDamage(attacker.type, move.getDamage());
        this.hp -= (int) effectiveDamage;

        if (this.hp <= 0) {
            this.setHp(0);
            return true;
        }

        return false;
    }

    //todo implementar esto
    public void play() {
        return;
    }

}