package com.hunter.actions;

import com.hunter.GameController;
import com.hunter.model.Hunter;
import com.hunter.model.Labyrinth;
import com.hunter.model.Position;
import com.hunter.model.RoomTypeEnum;
import com.hunter.model.perceptions.BumpToWall;
import com.hunter.model.perceptions.Exit;
import com.hunter.model.perceptions.GoldGlitter;
import com.hunter.model.perceptions.Perception;
import com.hunter.utils.PlayerSpeaker;

import java.util.List;

public class Move extends Action {

    @Override
    public List<Perception> doAction(Hunter hunter, Labyrinth labyrinth) {
        Position newPosition = GameController.findNextPosition(hunter, labyrinth);

        if (newPosition.equals(hunter.getActualPosition())) {
            perceptionsAfterAction.add(new BumpToWall());
        } else {
            hunter.setActualPosition(newPosition);
        }

        perceptionsAfterAction.addAll(GameController.getRoomPerceptions(labyrinth, hunter.getActualPosition()));

        if (labyrinth.getRoom(hunter.getActualPosition()).getRoomType().equals(RoomTypeEnum.WUMPUS)) {
            PlayerSpeaker.speak("WUMPUS eats you x( at  " + hunter.getActualPosition().toString() );
            hunter.killedByWumpus(); // GAME OVER
        } else if (labyrinth.getRoom(hunter.getActualPosition()).getRoomType().equals(RoomTypeEnum.PIT)) {
            PlayerSpeaker.speak("You have fallen into a PIT at " + hunter.getActualPosition().toString());
            hunter.fallenIntoDarkness(); // GAME OVER
        } else if (labyrinth.getRoom(hunter.getActualPosition()).getRoomType().equals(RoomTypeEnum.GOLD)) {
            perceptionsAfterAction.add(new GoldGlitter());
        } else if (labyrinth.getRoom(hunter.getActualPosition()).getRoomType().equals(RoomTypeEnum.EXIT)) {
            perceptionsAfterAction.add(new Exit());
        }

        return perceptionsAfterAction;
    }
}
