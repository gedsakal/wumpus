package com.hunter;

import com.hunter.model.Labyrinth;
import com.hunter.model.Position;
import com.hunter.model.RoomTypeEnum;

import java.util.Random;
import java.util.Scanner;

public class GameInitializer {

    final static boolean SHOW_THE_SECRET = true; // tell the configuration

    static Scanner scanner = new Scanner(System.in);
    static Random ran = new Random();

    public static Labyrinth initLabyrinth() throws Exception  {

        int labyrinthSize = readANumber("-> Enter Labyrinth size:", -1);
        int numberOfPits = readANumber("-> Enter number of pits:", labyrinthSize);
        int numberOfWalls = readANumber("-> Enter number of walls:", labyrinthSize*2);

        return initLabyrinth(labyrinthSize, numberOfPits, numberOfWalls);
    }

    private static Labyrinth initLabyrinth(int size, int pitsCount, int wallsCount) throws Exception {
        Labyrinth labyrinth = new Labyrinth(size);

        labyrinth.getRoom(0, labyrinth.getWidth()-1).setRoomType(RoomTypeEnum.EXIT);

        createRoomByType(labyrinth, pitsCount, RoomTypeEnum.PIT);
        createRoomByType(labyrinth, wallsCount, RoomTypeEnum.WALL);
        createRoomByType(labyrinth, 1, RoomTypeEnum.GOLD);
        createRoomByType(labyrinth, 1, RoomTypeEnum.WUMPUS);

        return labyrinth;
    }




    private static void createRoomByType(Labyrinth labyrinth, int roomsCount, RoomTypeEnum roomType) throws Exception {
        print("..Creating :" + roomType);
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
    private static Position getRandomEmptyPosition(Labyrinth labyrinth) throws Exception {

        int randomX = ran.nextInt(labyrinth.getWidth());
        int randomY = ran.nextInt(labyrinth.getWidth());

        if (labyrinth.getRoom(randomX,randomY).getRoomType().equals(RoomTypeEnum.EMPTY)) {
            return new Position(randomX, randomY);
        }
        else if (emptyRoomsLeft(labyrinth)) {
            return getRandomEmptyPosition(labyrinth);
        } else {
            throw new Exception("No empty rooms left - please check game parameters");
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


    public static void printIntroduction() {
        print("This is a game. Follow the instructions");
    }

    private static void print(Object o) {
        System.out.println(o.toString());
    }

    private static int readANumber(String forWhat, int maxValue) {
        int aNumber = 0;
        while (aNumber == 0) {

            print(forWhat);
            if (scanner.hasNextInt()) {
                int inputValue = scanner.nextInt();
                if ( (maxValue < 0 && inputValue > 0) || (inputValue > 0 && inputValue < maxValue)) {
                    aNumber = inputValue;
                } else {
                    print("Entered number is out of limit. Has to be greater than 0 and less than: " + maxValue);
                }
            } else {
                print("Not a valid Number");
                scanner.next();
            }
        }
        return aNumber;
    }
}
