import java.lang.Math;

public abstract class Type {

    protected String name;

    abstract public int calcDamage(Type type, int damage);

    abstract public int calcDamagePlant(int damage);

    abstract public int calcDamageFire(int damage);

    abstract public int calcDamageWater(int damage);

    abstract public int calcDamageLightning(int damage);

    abstract public int calcDamageFight(int damage);

    abstract public int calcDamagePsychic(int damage);

    public int resistant(int damage){
        return Math.max(damage - 30, 0);
    }

    public int weak(int damage){
        return damage * 2;
    }
}
