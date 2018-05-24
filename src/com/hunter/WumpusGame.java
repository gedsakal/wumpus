package com.hunter;

import com.hunter.actions.Action;
import com.hunter.exceptions.InitializationException;
import com.hunter.model.Hunter;
import com.hunter.model.Labyrinth;
import com.hunter.model.perceptions.Perception;
import com.hunter.utils.PlayerListener;
import com.hunter.utils.PlayerSpeaker;

import java.util.ArrayList;
import java.util.List;

public class WumpusGame {


    private Labyrinth labyrinth;
    private Hunter hunter;


    public static void main(String [] args) throws Exception {
        WumpusGame wg = new WumpusGame();
        wg.init();
        wg.play();
        wg.resume();
    }

    private void init() throws InitializationException {
        PlayerSpeaker.speak("*** Hello! This is not a game - this is WUMPUS Hunting... \n ");

        labyrinth = GameInitializer.initLabyrinth();
        hunter = GameInitializer.initHunter(labyrinth.getWidth());

    }

    // TODO
    private void play() {
        PlayerSpeaker.speak("*** Lets begin!");

        Action action;
        List<Perception> currentPerceptions = new ArrayList<>();

        while (!hunter.isWinner() && hunter.isAlive()) {
            // tell me what is happening
            PlayerSpeaker.tellPerceptions(currentPerceptions, hunter);

            PlayerSpeaker.speak("Move [M] or turn left [L] or turn right [R] or shoot [S] or grab the gold [G] or exit [E]");
            // take an action
            action = PlayerListener.readAction();

            // perceive
            currentPerceptions = action.doAction(hunter, labyrinth);

        }

    }


    private void resume() {
        if (hunter.isWinner()) {
            PlayerSpeaker.speak("  You are the winner!");
        } else {
            PlayerSpeaker.speak("  UPPS.... you are died.");
        }
        PlayerSpeaker.speak("*** Game over.");
    }


}
