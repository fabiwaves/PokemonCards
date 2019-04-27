import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FireTest {
    private Fire fire;
    private Type otherType;
    private int damage1;
    private int damage2;

    @Before
    public void setUp() {
        fire = new Fire();
        otherType = new Fighting();
        damage1 = 2;
        damage2 = 32;
    }

    @Test
    public void calcDamage() {
        assertEquals(otherType.calcDamageLightning(damage1), fire.calcDamage(otherType, damage1));
    }

    @Test
    public void calcDamagePlant() {
        assertEquals(damage1,fire.calcDamagePlant(damage1));
        assertEquals(damage2,fire.calcDamagePlant(damage2));
    }

    @Test
    public void calcDamageFire() {
        assertEquals(damage1,fire.calcDamageFire(damage1));
        assertEquals(damage2,fire.calcDamageFire(damage2));
    }

    @Test
    public void calcDamageWater() {
        assertEquals(damage1 * 2, fire.calcDamageWater(damage1));
        assertEquals(damage2 * 2, fire.calcDamageWater(damage2));
    }

    @Test
    public void calcDamageLightning() {
        assertEquals(damage1,fire.calcDamageLightning(damage1));
        assertEquals(damage2,fire.calcDamageLightning(damage2));
    }

    @Test
    public void calcDamageFighting() {
        assertEquals(damage1,fire.calcDamageFighting(damage1));
        assertEquals(damage2,fire.calcDamageFighting(damage2));
    }

    @Test
    public void calcDamagePsychic() {
        assertEquals(damage1,fire.calcDamagePsychic(damage1));
        assertEquals(damage2,fire.calcDamagePsychic(damage2));
    }
}