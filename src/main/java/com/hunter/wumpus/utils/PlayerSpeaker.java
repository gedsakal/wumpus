package com.hunter.wumpus.utils;

import java.util.List;

import com.hunter.wumpus.actions.Action;
import com.hunter.wumpus.model.Hunter;
import com.hunter.wumpus.perceptions.Perception;

/**
 * For more comfortable printing to Console
 */
public class PlayerSpeaker {

    public static void speak(Object o) {
        System.out.println(o.toString());
    }

    public static void tellPerceptions(List<Perception> currentPerceptions, Hunter hunter, Action a) {
        speak("Hunter on position: " + hunter.getActualPosition().toString()
                + ", " + (a != null ? a.getName() : "")
                + " towards: " + hunter.getDirection().getActualDirection().name());
        currentPerceptions.forEach(p -> speak(p.feelsLike()));
    }
}
