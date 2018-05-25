package com.hunter.wumpus.actions;

import java.util.List;

import com.hunter.wumpus.model.Hunter;
import com.hunter.wumpus.model.Labyrinth;
import com.hunter.wumpus.model.RoomTypeEnum;
import com.hunter.wumpus.perceptions.Perception;
import com.hunter.wumpus.utils.PlayerSpeaker;

public class Exit extends Action{

    @Override
    public List<Perception> doAction(Hunter hunter, Labyrinth labyrinth) {
        perceptionsAfterAction.addAll(findPerceptions(labyrinth, hunter.getActualPosition()));

        if (labyrinth.getRoom(hunter.getActualPosition()).getRoomType().equals(RoomTypeEnum.EXIT)) {
            if (hunter.isGotMoney()) {
                perceptionsAfterAction.clear();
                hunter.setWinner(); // Victory!
            } else {
                PlayerSpeaker.speak("Can't exit without grabbing peace of GOLD... Sorry, the rules ;)");
            }
        }

        return perceptionsAfterAction;
    }
}
