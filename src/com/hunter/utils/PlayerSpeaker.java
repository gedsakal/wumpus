package com.hunter.utils;

import com.hunter.model.Hunter;
import com.hunter.model.perceptions.Perception;

import java.util.List;

public class PlayerSpeaker {

    public static void speak(Object o) {
        System.out.println(o.toString());
    }

    public static void tellPerceptions(List<Perception> currentPerceptions, Hunter hunter) {
        speak("Hunter on position: " + hunter.getActualPosition().toString() + ", towards: " + hunter.getDirection().getActualDirection().name());
        currentPerceptions.forEach(p -> speak(p.feelsLike()));
    }
}
