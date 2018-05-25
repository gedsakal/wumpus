package com.hunter.wumpus.model;

import java.util.ArrayList;
import java.util.List;

import com.hunter.wumpus.perceptions.Perception;

public class Room {

    private RoomTypeEnum roomType;
    private List<Perception> perceptionsInHere = new ArrayList<>();

    public Room() {
        this.roomType = RoomTypeEnum._EMPTY;
    }

    public boolean isEmpty() {
        return this.roomType == RoomTypeEnum._EMPTY;
    }

    public RoomTypeEnum getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomTypeEnum type) {
        this.roomType = type;
    }

    public void addPerception(Perception p) {
        perceptionsInHere.add(p);
    }

    public List<Perception> getPerceptionsInHere() {
        return perceptionsInHere;
    }

}
