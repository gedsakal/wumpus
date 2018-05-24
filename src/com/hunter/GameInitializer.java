package com.hunter;

import com.hunter.exceptions.InitializationException;
import com.hunter.model.Hunter;
import com.hunter.model.Labyrinth;
import com.hunter.model.Position;
import com.hunter.model.RoomTypeEnum;
import com.hunter.utils.PlayerListener;
import com.hunter.utils.PlayerSpeaker;

import java.util.Random;
import java.util.Scanner;

public class GameInitializer extends PlayerSpeaker {

    final static boolean SHOW_THE_SECRET = true; // tell the configuration

    static Random ran = new Random();

    public static Labyrinth initLabyrinth() throws InitializationException  {
        int labyrinthSize = PlayerListener.readANumber("-> Enter Labyrinth size:", -1);
        int numberOfPits = PlayerListener.readANumber("-> Enter number of pits:", labyrinthSize);
        Labyrinth initialLabyrinth = initLabyrinth(labyrinthSize, numberOfPits);

        setupPerceptions(initialLabyrinth);

        return initialLabyrinth;
    }


    private static Labyrinth initLabyrinth(int size, int pitsCount) throws InitializationException {
        Labyrinth labyrinth = new Labyrinth(size);

        labyrinth.getRoom(0, labyrinth.getWidth()-1).setRoomType(RoomTypeEnum.EXIT);

        createRoomByType(labyrinth, pitsCount, RoomTypeEnum.PIT);
        createRoomByType(labyrinth, 1, RoomTypeEnum.GOLD);
        createRoomByType(labyrinth, 1, RoomTypeEnum.WUMPUS);

        return labyrinth;
    }

    public static Hunter initHunter(int labyrinthSize) {
        int numberOfArrows= PlayerListener.readANumber("-> Enter number of arrows you wish to give for your hunter:", -1);
        return new Hunter(numberOfArrows, labyrinthSize);
    }

    public static void setupPerceptions(Labyrinth labyrinth) {
        // TODO
        speak("Making this live..");
    }

    private static void createRoomByType(Labyrinth labyrinth, int roomsCount, RoomTypeEnum roomType) throws InitializationException {
        PlayerSpeaker.speak("..Creating :" + roomType);
        for (int i = 0; i < roomsCount; i++) {
            Position emptyPos = getRandomEmptyPosition(labyrinth);
            labyrinth.setXYRoomTo(roomType, emptyPos.getX(), emptyPos.getY());
            if (SHOW_THE_SECRET) System.out.println(" ... [" + emptyPos.getX() + ":" + emptyPos.getY() + "] as " + roomType);
        }
    }

    /**
     * Recursion with brutal force
     * @param labyrinth
     * @return
     */
    private static Position getRandomEmptyPosition(Labyrinth labyrinth) throws InitializationException {

        int randomX = ran.nextInt(labyrinth.getWidth());
        int randomY = ran.nextInt(labyrinth.getWidth());

        if (labyrinth.getRoom(randomX,randomY).isEmpty()) {
            return new Position(randomX, randomY);
        }
        else if (emptyRoomsLeft(labyrinth)) {
            return getRandomEmptyPosition(labyrinth);
        } else {
            throw new InitializationException("No empty rooms left - please check the game parameters.");
        }
    }

    private static boolean emptyRoomsLeft(Labyrinth labyrinth) {
        for (int i = 0; i<labyrinth.getWidth(); i++) {
            for(int j = 0; j<labyrinth.getWidth(); j++) {
                if (labyrinth.getRoom(i,j).isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }




}
