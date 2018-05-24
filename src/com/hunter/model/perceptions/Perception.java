package com.hunter.model.perceptions;

public abstract class Perception {

    public String feelsLike() {
        return "Feels like " + this.getClass().getName();
    }
}
