package Controller;

import Cards.Energies.IEnergy;
import Cards.ICard;
import Cards.IPokemon;
import Cards.TrainerCards.PKMObject;
import Cards.TrainerCards.Stadium;
import Cards.TrainerCards.Support;
import Players.Trainer;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * @author fabiwave
 */

public class Game extends Observable implements Observer {

    private Trainer player1;
    private Trainer player2;
    private Stadium card_stadium;
    private Trainer current_player;
    private boolean has_energy_played;
    private int allowed_cards_to_take;
    private int remaining_cards_to_take;

    public Game(Trainer player1, Trainer player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.player1.addObserver(this);
        this.player2.addObserver(this);
        this.player1.setObserver(this);
        this.player2.setObserver(this);
        this.card_stadium = null;
        this.current_player = player1;
        this.has_energy_played = false;
        this.allowed_cards_to_take = 1;
        this.remaining_cards_to_take = this.allowed_cards_to_take;
    }

    /**
     * Gets the current player
     *
     * @return The current player
     */
    public Trainer getCurrentPlayer() {
        return this.current_player;
    }

    /**
     * Sets the current player of the game
     *
     * @param current_player the player of the turn
     */
    private void setCurrentPlayer(Trainer current_player) {
        this.current_player = current_player;
    }

    /**
     * Gets the adversary of the current player
     *
     * @return Adversary
     */
    public Trainer getAdversary() {
        Trainer adversary = this.player2;
        if (this.current_player.equals(player2)) {
            adversary = player1;
        }
        return adversary;
    }

    /**
     * Gives the adversary pokemon
     *
     * @return Arraylist with the pokemon of the adversary
     */
    public ArrayList<IPokemon> getAdversaryPokemon() {
        return this.getAdversary().getTeam();
    }

    /**
     * Changes the current player of the game
     */
    private void changePlayer() {
        if (current_player == player1) {
            setCurrentPlayer(player2);
        }
        if (current_player == player2) {
            setCurrentPlayer(player1);
        }
        this.remaining_cards_to_take = this.allowed_cards_to_take;
        has_energy_played = false;
    }

    /**
     * Sets a new StadiumCard for the game
     *
     * @param stadium new stadium card for the game
     */
    private void setCardStadium(Stadium stadium) {
        if (this.card_stadium != null) {
            this.card_stadium.effect.executeAfter();
            this.deleteObserver(this.card_stadium.effect);
        }
        this.card_stadium = stadium;
        this.addObserver(this.card_stadium.effect);
        this.card_stadium.effect.executeBefore();
    }

    /**
     * Makes the action of playing a pokemon
     *
     * @param pkm that wants to be played
     */
    public void playPokemon(IPokemon pkm) {

        if (!pkm.getPhase().isEvolution()) {
            this.current_player.addPokemonToTeam();
        } else {
            Trainer trainer = this.current_player;
            IPokemon replacement = trainer.selectOwnPokemonTarget();

            if (pkm.getPhase().checkPrevId1(replacement)) {
                this.current_player.addPokemonToTeam();
                this.current_player.sendToGraveyard(replacement, trainer.getTeam());
            }
        }
    }

    /**
     * Makes the action of playing a Stadium
     *
     * @param std Stadium card to be played
     */
    public void playStadium(Stadium std) {
        setCardStadium(std);
    }

    /**
     * Shows the current Stadium card
     *
     * @return current Stadium card
     */
    ICard getStadium() {
        return this.card_stadium;
    }

    /**
     * Makes the action of playing a PKM Object
     *
     * @param pkmObject that wants to be played
     */
    public void playPKMObject(PKMObject pkmObject) {
        boolean variable = pkmObject.setCurrentPokemon(current_player.getActivePokemon());
        if (variable) {
            current_player.getActivePokemon().setPkmObject(pkmObject);
            pkmObject.effect.executeBefore();
            pkmObject.effect.executeAfter();
        }
    }

    /**
     * Makes the action of playing a Support
     *
     * @param support that wants to be played
     */
    public void playSupport(Support support) {
        support.effect.executeBefore();
        support.effect.executeAfter();
        current_player.sendToGraveyard(support, current_player.getHand());
    }

    /**
     * Makes the action of playing a Lighting Energy
     *
     * @param energy that wants to be played
     */
    public void playLightningEnergy(IEnergy energy) {
        if (!has_energy_played) {
            current_player.getActivePokemon().addLightningEnergy();
            has_energy_played = true;
            energy.getTrainer().sendToGraveyard(energy, energy.getTrainer().getHand());
        }
    }

    /**
     * Makes the action of playing a FireEnergy
     *
     * @param energy that wants to be played
     */
    public void playFireEnergy(IEnergy energy) {
        if (!has_energy_played) {
            current_player.getActivePokemon().addFireEnergy();
            has_energy_played = true;
            energy.getTrainer().sendToGraveyard(energy, energy.getTrainer().getHand());
        }
    }

    /**
     * Makes the action of playing a FightingEnergy
     *
     * @param energy that want to be played
     */
    public void playFightingEnergy(IEnergy energy) {
        if (!has_energy_played) {
            current_player.getActivePokemon().addFightingEnergy();
            has_energy_played = true;
            energy.getTrainer().sendToGraveyard(energy, energy.getTrainer().getHand());
        }
    }

    /**
     * Makes the action of playing a FightingEnergy
     *
     * @param energy that wants to be played
     */
    public void playPlantEnergy(IEnergy energy) {
        if (!has_energy_played) {
            current_player.getActivePokemon().addPlantEnergy();
            has_energy_played = true;
            energy.getTrainer().sendToGraveyard(energy, energy.getTrainer().getHand());
        }

    }

    /**
     * Makes the action of playing an PsychicEnergy
     *
     * @param energy that wants to be played
     */
    public void playPsychicEnergy(IEnergy energy) {
        if (!has_energy_played) {
            current_player.getActivePokemon().addPsychicEnergy();
            has_energy_played = true;
            energy.getTrainer().sendToGraveyard(energy, energy.getTrainer().getHand());
        }

    }

    /**
     * Makes the action of playing a WaterEnergy
     *
     * @param energy that wants to be played
     */
    public void playWaterEnergy(IEnergy energy) {
        if (!has_energy_played) {
            current_player.getActivePokemon().addWaterEnergy();
            has_energy_played = true;
            energy.getTrainer().sendToGraveyard(energy, energy.getTrainer().getHand());
        }

    }

    @Override
    public void update(Observable o, Object arg) {

        if (arg.equals(-1)) {
            this.setChanged();
            notifyObservers(-1);
            //todo: Implementar que el juego se termina
        }

        if (arg.equals(0)) {
            // Notify 0 va a ser para notificar que se acabo el turno
            changePlayer();
            this.setChanged();
            notifyObservers(0);
        }

        if (arg.equals(1)) {
            // El jugador tomo una carta
            if (this.current_player.equals(o)) {
                if (remaining_cards_to_take > 0) {
                    ICard card = current_player.getDeck().remove(0);
                    current_player.getHand().add(card);
                    remaining_cards_to_take--;
                }
                this.setChanged();
                notifyObservers(1);
            }
        }

        if ((arg.equals(7))) {
            //El jugador toma 7 cartas por el Soporte Professor Jupiter
            for (int i = 0; i <= 7; i++) {
                ICard card = current_player.getDeck().remove(0);
                current_player.getHand().add(card);
            }
            this.setChanged();
            notifyObservers(7);
        }

        if (arg.equals(5)) {
            if (this.current_player.equals(o)) {
                // Notify 5 va a ser "jugador actual juega carta"
                Trainer aux = (Trainer) o;
                aux.playACard();
                this.setChanged();
                notifyObservers(5);
            }
        }

        if (arg.equals(10)) {
            // Notify 10 significa que se efectuo un ataque
            if (!this.getAdversary().getTeam().get(0).isAlive()) {
                this.getAdversary().replaceActivePokemon();
            }
            this.setChanged();
            notifyObservers(10);
        }

        if (arg.equals(15)) {
            // Notify 15 significa que se daño al pokemon del jugador activo
            if (!this.current_player.getTeam().get(0).isAlive()) {
                this.current_player.replaceActivePokemon();
            }
            this.setChanged();
            notifyObservers(15);
        }

        if (arg.equals(100)) {
            // El jugador descarta su mano
            ArrayList<ICard> hand = this.current_player.getHand();
            int hand_size = hand.size();
            for (int i = 0; i < hand_size; i++) {
                this.current_player.sendToGraveyard(hand.get(0), hand);
            }
            this.setChanged();
            notifyObservers(100);
        }
    }

}


