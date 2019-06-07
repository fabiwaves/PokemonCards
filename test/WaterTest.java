import Types.Fire;
import Types.Type;
import Types.Water;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WaterTest {

    private Water water;
    private Type otherType;
    private int damage1;
    private int damage2;

    @Before
    public void setUp() {
        water = new Water();
        otherType = new Fire();
        damage1 = 2;
        damage2 = 32;
    }

    @Test
    public void calcDamage() {
        assertEquals(otherType.calcDamageWater(damage1), water.calcDamage(otherType, damage1));
    }

    @Test
    public void calcDamagePlant() {
        assertEquals(water.calcDamagePlant(damage1), 2 * damage1);
        assertEquals(water.calcDamagePlant(damage2), 2 * damage2);
    }

    @Test
    public void calcDamageFire() {
        assertEquals(water.calcDamageFire(damage1), damage1);
        assertEquals(water.calcDamageFire(damage2), damage2);
    }

    @Test
    public void calcDamageWater() {
        assertEquals(water.calcDamageWater(damage1), damage1);
        assertEquals(water.calcDamageWater(damage2), damage2);
    }

    @Test
    public void calcDamageLightning() {
        assertEquals(water.calcDamageLightning(damage1), 2 * damage1);
        assertEquals(water.calcDamageLightning(damage2), 2 * damage2);
    }

    @Test
    public void calcDamageFighting() {
        assertEquals(water.calcDamageFighting(damage1), 0);
        assertEquals(water.calcDamageFighting(damage2), damage2 - 30);
    }

    @Test
    public void calcDamagePsychic() {
        assertEquals(damage1, water.calcDamagePsychic(damage1));
        assertEquals(damage2, water.calcDamagePsychic(damage2));
    }
}