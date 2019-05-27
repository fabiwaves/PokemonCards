import Ataques.Fighting;
import Ataques.Plant;
import Ataques.Type;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlantTest {

    private Plant plant;
    private Type otherType;
    private int damage1;
    private int damage2;

    @Before
    public void setUp() {
        plant = new Plant();
        otherType = new Fighting();
        damage1 = 2;
        damage2 = 32;
    }

    @Test
    public void calcDamage() {
        assertEquals(otherType.calcDamagePlant(damage1), plant.calcDamage(otherType, damage1));
    }

    @Test
    public void calcDamagePlant() {
        Assert.assertEquals(damage1,plant.calcDamagePlant(damage1));
        Assert.assertEquals(damage2,plant.calcDamagePlant(damage2));
    }

    @Test
    public void calcDamageFire() {
        Assert.assertEquals(damage1 * 2, plant.calcDamageFire(damage1));
        Assert.assertEquals(damage2 * 2, plant.calcDamageFire(damage2));
    }

    @Test
    public void calcDamageWater() {
        Assert.assertEquals(0, plant.calcDamageWater(damage1));
        Assert.assertEquals(damage2 - 30, plant.calcDamageWater(damage2));
    }

    @Test
    public void calcDamageLightning() {

        Assert.assertEquals(damage1, plant.calcDamageLightning(damage1));
        Assert.assertEquals(damage2, plant.calcDamageLightning(damage2));
    }

    @Test
    public void calcDamageFighting() {
        Assert.assertEquals(damage1,plant.calcDamageFighting(damage1));
        Assert.assertEquals(damage2,plant.calcDamageFighting(damage2));
    }

    @Test
    public void calcDamagePsychic() {
        Assert.assertEquals(damage1,plant.calcDamagePsychic(damage1));
        Assert.assertEquals(damage2,plant.calcDamagePsychic(damage2));
    }
}