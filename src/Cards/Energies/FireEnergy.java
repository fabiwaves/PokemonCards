package Cards.Energies;

import Cards.AbstractCard;
import Cards.IEnergy;
import Controller.Game;

public class FireEnergy extends AbstractCard implements IEnergy {

    public void notifyType(Game game) {
        game.playFireEnergy(this);
    }
}
