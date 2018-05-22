package com.hunter.model;

public class Room {

    RoomTypeEnum roomType;

    public Room() {
        this.roomType = RoomTypeEnum.EMPTY;
    }

    public boolean isEmpty() {
        return this.roomType == RoomTypeEnum.EMPTY;
    }

    public RoomTypeEnum getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomTypeEnum type) {
        this.roomType = type;
    }

}
