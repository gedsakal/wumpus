package com.hunter.actions;

import com.hunter.GameController;
import com.hunter.model.Hunter;
import com.hunter.model.Labyrinth;
import com.hunter.model.perceptions.NoArrowsLeft;
import com.hunter.model.perceptions.Perception;
import com.hunter.utils.PlayerSpeaker;

import java.util.List;

public class Shoot extends Action {
    @Override
    public List<Perception> doAction(Hunter hunter, Labyrinth labyrinth) {
        perceptionsAfterAction.addAll(GameController.getRoomPerceptions(labyrinth, hunter.getActualPosition()));

        if (hunter.getArrowsLeft() > 0) {
            // TODO
            System.err.println("NOT Implemented yet");
        } else {
            perceptionsAfterAction.add(new NoArrowsLeft());
        }

        return perceptionsAfterAction;
    }
}
