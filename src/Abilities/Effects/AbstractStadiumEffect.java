package Abilities.Effects;

import Cards.TrainerCards.Stadium;

import java.util.Observer;

public abstract class AbstractStadiumEffect implements IEffect, Observer {
    private Stadium stadium_card;

    public void setStadium(Stadium stadium){
        this.stadium_card = stadium;
    }
}
