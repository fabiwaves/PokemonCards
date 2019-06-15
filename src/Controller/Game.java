package Controller;


import Cards.IPokemon;
import Cards.TrainerCards.PKMObject;
import Cards.TrainerCards.Stadium;
import Cards.TrainerCards.Support;
import Players.Player;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Game implements Observer {

    private Player player1;
    private Player player2;
    private Stadium card_stadium;
    private Player current_player;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.card_stadium = null;
        this.current_player = player1;
    }

    private void setCurrentPlayer(Player current_player) {
        this.current_player = current_player;
    }

    public Player getAdversary() {
        Player adversary = this.player2;
        if (this.current_player.equals(player2)) {
            adversary = player1;
        }
        return adversary;
    }

    public ArrayList<IPokemon> getAdversaryPokemon() {
        return this.getAdversary().getTeam();
    }

    private void changePlayer() {
        if (current_player == player1) {
            setCurrentPlayer(player2);
        }
        if (current_player == player2) {
            setCurrentPlayer(player1);
        }
    }

    public void setCardStadium(Stadium stadium) {
        this.card_stadium = stadium;
    }

    public void playPokemon(IPokemon pkm) {
        // TODO: Agregar lo de las evoluciones en el addPokemonToTeam
        this.current_player.addPokemonToTeam();
    }

    public void playStadium(Stadium std){
        setCardStadium(std);
    }

    public void playPKMObject(PKMObject pkmObject){
        pkmObject.setCurrentPokemon(current_player.getActivePokemon());
    }

    public void playSupport(Support support){

    }

    @Override
    public void update(Observable o, Object arg) {

        if(arg.equals(-1)){
            //todo: Implementar que el juego se termina
        }

        if (arg.equals(0)) {
            // Notify 0 va a ser para notificar que se acabo el turno
            changePlayer();
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

    }

}

