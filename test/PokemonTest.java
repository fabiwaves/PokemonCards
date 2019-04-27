import junit.framework.TestCase;
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
    public void getName() {

    }

    @Test
    public void getId() {
    }

    @Test
    public void getHp() {
    }

    @Test
    public void getAbilities() {
    }

    @Test
    public void getEnergies() {
    }

    @Test
    public void getType() {
    }

    @Test
    public void setHp() {
    }

    @Test
    public void isAlive() {
    }

    @Test
    public void getAttacked() {
    }
}