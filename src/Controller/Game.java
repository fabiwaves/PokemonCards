package Controller;


import Players.Player;

import java.util.Observable;
import java.util.Observer;

public class Game implements Observer {

    private Player player1;
    private Player player2;
    private boolean card_stadium_played;
    private Player current_player;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.card_stadium_played = false;
        this.current_player = player1;
    }


    public void setCurrent_player(Player current_player) {
        this.current_player = current_player;
    }

    public void changePlayer() {
        if (current_player == player1) {
            setCurrent_player(player2);
        }
        if (current_player == player2) {
            setCurrent_player(player1);
        }
    }

    public boolean isCard_stadium_played() {
        return card_stadium_played;
    }

    @Override
    public void update(Observable o, Object arg) {

        //Me avisa que el jugador termino su turno y debo cambiarlo por la otra
        if(arg.equals(0)){
            changePlayer();
            // current_player.play();
        }

        //Me avisa que se jugo una carta stadium y debo ver que procede segun el caso
        if (arg.equals(1)){
            if ((card_stadium_played == false)){
                card_stadium_played = true;
            }

            else{
                //TODO: Implementar el caso cuando debo reemplazar la carta por la nueva
            }
        }



    }
}
