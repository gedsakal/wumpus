package com.hunter.wumpus.actions;


import java.util.List;

import com.hunter.wumpus.model.Hunter;
import com.hunter.wumpus.model.Labyrinth;
import com.hunter.wumpus.model.Position;
import com.hunter.wumpus.model.RoomTypeEnum;
import com.hunter.wumpus.perceptions.BumpToWall;
import com.hunter.wumpus.perceptions.DeathByWumpus;
import com.hunter.wumpus.perceptions.DeathOfFall;
import com.hunter.wumpus.perceptions.GoldGlitter;
import com.hunter.wumpus.perceptions.Perception;
import com.hunter.wumpus.perceptions.Stairs;

public class Move extends Action {

    @Override
    public List<Perception> doAction(Hunter hunter, Labyrinth labyrinth) {
        Position newPosition = findNextPosition(hunter, labyrinth);

        if (newPosition.equals(hunter.getActualPosition())) { // position did not change
            perceptionsAfterAction.add(new BumpToWall());
        } else {
            hunter.setActualPosition(newPosition);  // move is made
        }

        perceptionsAfterAction.addAll(findPerceptions(labyrinth, hunter.getActualPosition()));

        if (labyrinth.getRoom(hunter.getActualPosition()).getRoomType().equals(RoomTypeEnum.WUMPUS)) {
            if (!hunter.hasBeatenWumpus()) {
                perceptionsAfterAction.clear();
                perceptionsAfterAction.add(new DeathByWumpus());
                hunter.killedByWumpus(); // GAME OVER
            }
        } else if (labyrinth.getRoom(hunter.getActualPosition()).getRoomType().equals(RoomTypeEnum.PIT)) {
            perceptionsAfterAction.clear();
            perceptionsAfterAction.add(new DeathOfFall());
            hunter.fallenIntoDarkness(); // GAME OVER
        } else if (labyrinth.getRoom(hunter.getActualPosition()).getRoomType().equals(RoomTypeEnum.GOLD)) {
            perceptionsAfterAction.add(new GoldGlitter());
        } else if (labyrinth.getRoom(hunter.getActualPosition()).getRoomType().equals(RoomTypeEnum.EXIT)) {
            perceptionsAfterAction.add(new Stairs());
        }

        return perceptionsAfterAction;
    }

}
