package Cartas; /**
 * @author Fabiwave
 */

import Other.Attack;
import Types.Type;
import Jugador.Player;
import Jugador.Trainer;

import java.util.ArrayList;

public class Pokemon extends AbstractCard implements IPokemon {

    private String name;
    private int id;
    private int hp;
    private ArrayList<Attack> attacks;
    private int[] energies;
    private Type type;
    private Trainer trainer;
    private int next_attack_index;

    public Pokemon(String name, int id, int hp, ArrayList<Attack> abilities, Type type, Trainer trainer) {
        this.name = name;
        this.id = id;
        this.hp = hp;
        this.attacks = abilities;
        // energies: {Fighning, Fire, Lightning, Plant, Psychic, Water}
        this.energies = new int[] {0, 0, 0, 0, 0, 0};
        this.type = type;
        this.trainer = trainer;
        this.next_attack_index = -1;
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

    public ArrayList getAttacks() {
        return attacks;
    }

    public int[] getEnergies() {
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

    @Override
    public void setNextAttack(int index) {
        if (index >= 0 && index < attacks.size()){
            this.next_attack_index = index;
        }
    }

    @Override
    public void attackTrainer(Player adversary) {
        adversary.getActivePokemon().getAttacked(this, this.attacks.get(next_attack_index));
    }

    @Override
    public void addFightingEnergy(IEnergy energy) {
        this.energies[0] += 1;
    }

    @Override
    public void addFireEnergy(IEnergy energy) {
        this.energies[1] += 1;
    }

    @Override
    public void addLightningEnergy(IEnergy energy) {
        this.energies[2] += 1;
    }

    @Override
    public void addPlantEnergy(IEnergy energy) {
        this.energies[3] += 1;
    }

    @Override
    public void addPsychicEnergy(IEnergy energy) {
        this.energies[4] += 1;
    }

    @Override
    public void addWaterEnergy(IEnergy energy) {
        this.energies[5] += 1;
    }

    //todo implementar esto
    public void play() {
        this.trainer.addPokemonToTeam(this);
    }

}