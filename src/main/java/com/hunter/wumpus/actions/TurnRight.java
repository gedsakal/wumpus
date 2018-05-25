package com.hunter.wumpus.actions;

import java.util.List;

import com.hunter.wumpus.model.Direction;
import com.hunter.wumpus.model.Hunter;
import com.hunter.wumpus.model.Labyrinth;
import com.hunter.wumpus.perceptions.Perception;

public class TurnRight extends Action{

    @Override
    public List<Perception> doAction(Hunter hunter, Labyrinth labyrinth) {
        perceptionsAfterAction.addAll(findPerceptions(labyrinth, hunter.getActualPosition()));
        Direction newDirection = new Direction(hunter.getDirection().getDirectionToRight());
        hunter.setDirection(newDirection);
        return perceptionsAfterAction;
    }
}
