import Types.Fire;
import Types.Psychic;
import Types.Type;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PsychicTest {

    private Psychic psychic;
    private Type otherType;
    private int damage1;
    private int damage2;

    @Before
    public void setUp() {
        psychic = new Psychic();
        otherType = new Fire();
        damage1 = 2;
        damage2 = 32;
    }

    @Test
    public void calcDamage() {
        assertEquals(otherType.calcDamagePsychic(damage1), psychic.calcDamage(otherType, damage1));
    }

    @Test
    public void calcDamagePlant() {
        Assert.assertEquals(damage1,psychic.calcDamagePlant(damage1));
        Assert.assertEquals(damage2,psychic.calcDamagePlant(damage2));
    }

    @Test
    public void calcDamageFire() {
        Assert.assertEquals(damage1,psychic.calcDamageFire(damage1));
        Assert.assertEquals(damage2,psychic.calcDamageFire(damage2));
    }

    @Test
    public void calcDamageWater() {
        Assert.assertEquals(damage1,psychic.calcDamageWater(damage1));
        Assert.assertEquals(damage2,psychic.calcDamageWater(damage2));
    }

    @Test
    public void calcDamageLightning() {
        Assert.assertEquals(damage1,psychic.calcDamageLightning(damage1));
        Assert.assertEquals(damage2,psychic.calcDamageLightning(damage2));
    }

    @Test
    public void calcDamageFighting() {
        Assert.assertEquals(0, psychic.calcDamageFighting(damage1));
        Assert.assertEquals(damage2 - 30, psychic.calcDamageFighting(damage2));
    }

    @Test
    public void calcDamagePsychic() {
        Assert.assertEquals(damage1*2, psychic.calcDamagePsychic(damage1));
        Assert.assertEquals(damage2*2, psychic.calcDamagePsychic(damage2));
    }
}