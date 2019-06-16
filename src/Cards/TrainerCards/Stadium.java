package Cards.TrainerCards;

import Controller.Game;
import Other.Effects.IEffect;

public class Stadium extends TrainerCard {

    public IEffect effect;

    public Stadium(IEffect effect) {
        this.effect = effect;
    }


    @Override
    public void notifyType(Game game) {
        game.playStadium(this);
    }
}
