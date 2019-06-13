package Visitors;

import Cards.Pokemon;
import Players.Trainer;

public interface IVisitor {

    public void visitPokemon(Pokemon pokemon);

    public void visitTrainer(Trainer trainer);

}
