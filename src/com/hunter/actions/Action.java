package com.hunter.actions;

import com.hunter.model.Hunter;
import com.hunter.model.Labyrinth;
import com.hunter.model.perceptions.Perception;

import java.util.ArrayList;
import java.util.List;

public abstract class Action {

    List<Perception> perceptionsAfterAction = new ArrayList<>();

    public abstract List<Perception> doAction(Hunter hunter, Labyrinth labyrinth);

}
