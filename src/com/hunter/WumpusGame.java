package com.hunter;

import com.hunter.model.Labyrinth;

public class WumpusGame {


    Labyrinth labyrinth;



    public static void main(String [] args) throws Exception {


        GameInitializer.printIntroduction();

        WumpusGame wg = new WumpusGame();
        wg.labyrinth = GameInitializer.initLabyrinth();


        wg.play();

    }

    // TODO
    private void play() {
        System.out.println("Playing... until the end");

        boolean victory = false;

        while (!victory) {

            // move or shoot

            // perceive

            // turn left or turn right

            // exit?

        }

        System.out.println("Playing... until the end");
    }


}
