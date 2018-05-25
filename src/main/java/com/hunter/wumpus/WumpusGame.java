package com.hunter.wumpus;


import java.util.ArrayList;
import java.util.List;

import com.hunter.wumpus.actions.Action;
import com.hunter.wumpus.model.Hunter;
import com.hunter.wumpus.model.Labyrinth;
import com.hunter.wumpus.perceptions.Perception;
import com.hunter.wumpus.utils.PlayerListener;
import com.hunter.wumpus.utils.PlayerSpeaker;

/**
 * Principal Class with Main() Entry
 */
public class WumpusGame {

    private Labyrinth labyrinth;
    private Hunter hunter;

    private static GameInitializer initializer;

    /**
     * Main
     * @param args
     * @throws Exception
     */
    public static void main(String [] args) throws Exception {
        initializer = new GameInitializer((args.length > 0 && args[0].equals("DEBUG")));

        WumpusGame wg = new WumpusGame();
        wg.init();
        wg.play();
        wg.resume();
        PlayerListener.exit();
    }

    /**
     * Reads parameters and initializes the game
     */
    private void init() {
        PlayerSpeaker.speak("*** Hi There! This is not a game - this is WUMPUS Hunting... \n ");
        labyrinth = initializer.initLabyrinth();
        hunter = initializer.initHunter(labyrinth.getWidth());
    }

    /**
     * Playing
     */
    private void play() {
        PlayerSpeaker.speak("*** Lets begin!");

        Action action = null;
        List<Perception> currentPerceptions = new ArrayList<>();

        while (!hunter.isAWinner() && hunter.isAlive()) {
            // tell me what is happening
            PlayerSpeaker.tellPerceptions(currentPerceptions, hunter, action);

            PlayerSpeaker.speak("Move [M] or turn left [L] or turn right [R] or shoot [S] or grab the gold [G] or exit [E]");
            // take an action
            action = PlayerListener.readAction();

            // perceive
            currentPerceptions = action.doAction(hunter, labyrinth);

        }

        PlayerSpeaker.tellPerceptions(currentPerceptions, hunter, action);

    }


    /**
     * Shows result
     */
    private void resume() {
        if (hunter.isAWinner()) {
            PlayerSpeaker.speak("  You are the winner!");
        } else {
            PlayerSpeaker.speak("  So sorry.. you are died.");
        }
        PlayerSpeaker.speak("*** Game over.");
    }

}
