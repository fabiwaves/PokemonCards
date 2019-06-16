package Cards.Energies;

import Cards.AbstractCard;
import Cards.IEnergy;
import Controller.Game;

/**
 * @author fabiwave
 */

public class PlantEnergy extends AbstractCard implements IEnergy {

    public void notifyType(Game game) {
        game.playPlantEnergy(this);
    }
}
