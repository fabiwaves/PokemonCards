package Cards.Energies;

import Cards.AbstractCard;
import Cards.IEnergy;
import Controller.Game;

public class LightingEnergy extends AbstractCard implements IEnergy {

    public void notifyType(Game game) {
        game.playLightingEnergy(this);
    }
}
