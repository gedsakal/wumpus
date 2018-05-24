package com.hunter.model;

/**
 * Its a square board defined by Width and consist of Rooms (each cell)
 */
public class Labyrinth {

    private Room[][] rooms;

    public Labyrinth(int width) {
        rooms = new Room[width][width];
        for (int i = 0; i<width; i++) {
            for (int j = 0; j<width; j++) {
                rooms[i][j] = new Room();
            }
        }
    }

    public int getWidth() {
        return rooms.length;
    }

    public Room getRoom(Position p) {
        return rooms[p.getX()][p.getY()];
    }

    public Room getRoom(int x, int y) {
        return rooms[x][y];
    }

    public void setXYRoomTo(RoomTypeEnum type, int x, int y) {
        rooms[x][y].setRoomType(type);
    }

}
