package com.hunter;

import com.hunter.actions.*;
import com.hunter.model.Hunter;
import com.hunter.model.Labyrinth;
import com.hunter.model.Position;
import com.hunter.model.perceptions.Perception;
import com.hunter.utils.PlayerSpeaker;

import java.util.Collection;
import java.util.List;

public class GameController extends PlayerSpeaker {


    public static Action findAction(String actionCode) {
        Action result = null;
        switch (actionCode) {
            case "M":
                result = new Move();
                break;
            case "L":
                result = new TurnLeft();
                break;
            case "R":
                result = new TurnRight();
                break;
            case "S":
                result = new Shoot();
                break;
            case "G":
                result = new Grab();
                break;
            case "E":
                result = new Exit();
                break;
            default:
                speak("Not a valid action. Try again..");
        }
        return result;
    }


    public static Position findNextPosition(Hunter hunter, Labyrinth labyrinth) {
        Position newPosition = new Position(hunter.getActualPosition().getX(), hunter.getActualPosition().getY());

        switch (hunter.getDirection().getActualDirection()) {
            case EAST:
                if (newPosition.getX() < labyrinth.getWidth()-1) newPosition.addToX(1);
                break;
            case SOUTH:
                if (newPosition.getY() < labyrinth.getWidth()-1) newPosition.addToY(1);
                break;
            case WEST:
                if (newPosition.getX() > 0) newPosition.addToX(-1);
                break;
            case NORTH:
                if (newPosition.getY() > 0) newPosition.addToY(-1);
                break;
        }
        return newPosition;
    }

    public static Collection<? extends Perception> getRoomPerceptions(Labyrinth labyrinth, Position pos) {
        return labyrinth.getRoom(pos).getPerceptionsInHere();
    }
}
