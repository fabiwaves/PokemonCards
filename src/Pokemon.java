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

    @Override
    public Type getType() {
        return type;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isAlive() {
        return (this.hp > 0);
    }

    public boolean getAttacked(Pokemon attacker, Attack move) {
        double effectiveDamage = this.type.calcDamage(attacker.getType(), move.getDamage());
        this.hp -= (int) effectiveDamage;

        if (this.hp <= 0) {
            this.hp = 0;
            return true;
        }

        return false;
    }
}