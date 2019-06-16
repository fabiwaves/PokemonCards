package Controller;

import Cards.ICard;
import Cards.IEnergy;
import Cards.IPokemon;
import Cards.TrainerCards.PKMObject;
import Cards.TrainerCards.Stadium;
import Cards.TrainerCards.Support;
import Players.Player;
import Players.Trainer;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * @author fabiwave
 */

public class Game implements Observer {

    private Player player1;
    private Player player2;
    private Stadium card_stadium;
    private Player current_player;
    private boolean has_energy_played;
    private boolean has_taken_a_card;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.card_stadium = null;
        this.current_player = player1;
        has_energy_played = false;
        has_taken_a_card = false;

    }

    /**
     * Sets the current player of the game
     *
     * @param current_player the player of the turn
     */
    private void setCurrentPlayer(Player current_player) {
        this.current_player = current_player;
    }

    /**
     * Gets the adversary of a Player
     *
     * @return Adversary
     */
    public Player getAdversary() {
        Player adversary = this.player2;
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
    }

    /**
     * Sets a new StadiumCard for the game
     *
     * @param stadium new stadium card for the game
     */
    public void setCardStadium(Stadium stadium) {
        this.card_stadium = stadium;
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
            Trainer trainer = (Trainer) this.current_player;
            IPokemon replacement = trainer.selectOwnPokemonTarget();

            if (pkm.getPhase().checkPrevId1(replacement)) {
                this.current_player.addPokemonToTeam();
                ((Trainer) this.current_player).sendToGraveyard(replacement, trainer.getTeam());
            }
        }
    }

    /**
     * Makes the action of playing a Stadium
     *
     * @param std
     */
    public void playStadium(Stadium std) {
        setCardStadium(std);
        std.effect.executeBefore();
        std.effect.executeAfter();
    }

    /**
     * Makes the action of playing a PKM Object
     *
     * @param pkmObject that wants to be played
     */
    public void playPKMObject(PKMObject pkmObject) {
        boolean variable = pkmObject.setCurrentPokemon(current_player.getActivePokemon());
        if (variable) {
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
    }

    /**
     * Makes the action of playing a Lighting Energy
     *
     * @param energy that wants to be played
     */
    public void playLightingEnergy(IEnergy energy) {
        if (has_energy_played == false) {
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
        if (has_energy_played == false) {
            current_player.getActivePokemon().addFightingEnergy();
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
        if (has_energy_played == false) {
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
        if (has_energy_played == false) {
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
        if (has_energy_played == false) {
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
        if (has_energy_played == false) {
            current_player.getActivePokemon().addWaterEnergy();
            has_energy_played = true;
            energy.getTrainer().sendToGraveyard(energy, energy.getTrainer().getHand());
        }

    }

    @Override
    public void update(Observable o, Object arg) {

        if (arg.equals(-1)) {
            //todo: Implementar que el juego se termina
        }

        if (arg.equals(0)) {
            // Notify 0 va a ser para notificar que se acabo el turno
            changePlayer();
            has_taken_a_card = false;
            has_energy_played = false;
        }

        if (arg.equals(1)) {
            // El jugador tomo una carta
            if (this.current_player.equals(o)) {
                if (has_taken_a_card == false) {
                    ICard card = current_player.getDeck().remove(0);
                    current_player.getHand().add(card);
                    has_taken_a_card = true;
                }
            }
        }

        if (arg.equals(2)) {
            // El jugador toma una carta extra por el efecto LuckyStadium
            ICard card = current_player.getDeck().remove(0);
            current_player.getHand().add(card);
        }

        if ((arg.equals(7))) {
            //El jugador toma 7 cartas por el Soporte Professor Jupiter
            for (int i = 0; i <= 7; i++) {
                ICard card = current_player.getDeck().remove(0);
                current_player.getHand().add(card);
            }
        }

        if (arg.equals(5)) {
            if (this.current_player.equals(o)) {
                // Notify 5 va a ser "jugador actual juega carta"
                Player aux = (Player) o;
                aux.playACard();
            }
        }

        if (arg.equals(10)) {
            // Notify 10 significa que se efectuo un ataque
            if (!this.getAdversary().getTeam().get(0).isAlive()) {
                this.getAdversary().replaceActivePokemon();
            }
        }

        if (arg.equals(15)) {
            // Notify 15 significa que se daño al pokemon del jugador activo
            if (!this.current_player.getTeam().get(0).isAlive()) {
                this.current_player.replaceActivePokemon();
            }

        }

        if (arg.equals(100)) {
            // El jugador descarta su mano
            this.current_player.getHand().clear();
        }
    }

}


