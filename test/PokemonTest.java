import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PokemonTest {

    @Before
    public void setUp() {
        //Array for the abilities
        ArrayList<String> abilities = new ArrayList<>();
        abilities.add("Bubble Beam");
        abilities.add("Brine");
        abilities.add("Whirlpool");
        abilities.add("Hydro Pump");
        //Array for the energies
        ArrayList<String> energies = new ArrayList<>();
        energies.add("1");
        energies.add("1");
        energies.add("1");
        //Initialization of type
        Water w = new Water();

    }

    @Test
    public void testGetName() {
        System.out.println("YAY");
    }

    @Test
    public void testGetId() {
    }

    @Test
    public void testGetHp() {
    }

    @Test
    public void testGetAbilities() {
    }

    @Test
    public void testGetEnergies() {
    }

    @Test
    public void testGetType() {
    }

    @Test
    public void testSetHp() {
    }

    @Test
    public void testIsAlive() {
    }

    @Test
    public void testGetAttacked() {
    }

    @Test
    public void testCheckEnergy() {
    }

    @Test
    public void testGetTypeOfEnergy() {
    }

    @Test
    public void testCountRep() {
    }
}