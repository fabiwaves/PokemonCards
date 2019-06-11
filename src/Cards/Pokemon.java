package Cards;

import Cards.TrainerCards.PKMObject;
import Other.Attack;
import Players.Player;
import Players.Trainer;
import Types.Type;

import java.util.ArrayList;
import java.util.HashMap;

public class Pokemon extends AbstractCard implements IPokemon {
    private String name;
    private int id;
    private int hp;
    private ArrayList<Attack> attacks;
    private HashMap<String, Integer> energies;
    private Type type;
    private Trainer trainer;
    private int next_attack_index;
    private PKMObject pkmObject;

    public Pokemon(String name, int id, int hp, ArrayList<Attack> abilities, Type type, Trainer trainer) {
        String[] energy_names = {"Fighting", "Fire", "Lightning", "Plant", "Psychic", "Water"};
        this.name = name;
        this.id = id;
        this.hp = hp;
        this.attacks = abilities;
        this.energies = new HashMap<>();
        for (String a_name :
                energy_names) {
            this.energies.put(a_name, 0);
        }
        this.type = type;
        this.trainer = trainer;
        this.next_attack_index = -1;
        this.pkmObject = null;
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

    public ArrayList<Attack> getAttacks() {
        return attacks;
    }

    public HashMap<String, Integer> getEnergies() {
        return energies;
    }

    public Type getType() {
        return type;
    }

    @Override
    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public PKMObject getPKMObject(){
        return this.pkmObject;
    }

    public void setPkmObject(PKMObject pkmObject) {
        this.pkmObject = pkmObject;
    }

    public boolean isAlive() {
        return (this.hp > 0);
    }

    public boolean getAttacked(Pokemon attacker, Attack move) {
        int effectiveDamage = this.type.calcDamage(attacker.type, move.getDamage());
        this.hp -= effectiveDamage;

        if (this.hp <= 0) {
            this.hp = 0;
            return true;
        }

        return false;
    }

    @Override
    public void setNextAttack(int index) {
        if (index >= 0 && index < attacks.size()) {
            this.next_attack_index = index;
        }
    }

    @Override
    public void attackTrainer(Player adversary) {
        adversary.getActivePokemon().getAttacked(this, this.attacks.get(next_attack_index));
        adversary.checkActivePokemon();
    }

    @Override
    public void addFightingEnergy() {
        this.energies.replace(
                "Fighting",
                this.energies.get("Fighting") + 1
        );
    }

    @Override
    public void addFireEnergy() {
        this.energies.replace(
                "Fire",
                this.energies.get("Fire") + 1
        );
    }

    @Override
    public void addLightningEnergy() {
        this.energies.replace(
                "Lightning",
                this.energies.get("Lightning") + 1
        );
    }

    @Override
    public void addPlantEnergy() {
        this.energies.replace(
                "Plant",
                this.energies.get("Plant") + 1
        );
    }

    @Override
    public void addPsychicEnergy() {
        this.energies.replace(
                "Psychic",
                this.energies.get("Psychic") + 1
        );
    }

    @Override
    public void addWaterEnergy() {
        this.energies.replace(
                "Water",
                this.energies.get("Water") + 1
        );
    }

    public void play(ICard card) {
        this.trainer.addPokemonToTeam(this);
    }

}