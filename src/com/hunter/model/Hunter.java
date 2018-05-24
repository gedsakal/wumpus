package com.hunter.model;

public class Hunter {

    private Direction direction = new Direction(DirectionEnum.EAST);
    private int arrowsLeft = 0;
    private boolean wumpusBeated = false;
    private boolean gotMoney = false;
    private boolean winner = false;
    private boolean alive = true;

    private Position actualPosition;

    public Hunter (int arrowsCount, int labyrinthSize) {
        this.arrowsLeft = arrowsCount;
        this.actualPosition = new Position(0, labyrinthSize-1);
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getArrowsLeft() {
        return arrowsLeft;
    }

    public void setArrowsLeft(int arrowsLeft) {
        this.arrowsLeft = arrowsLeft;
    }

    public boolean isWumpusBeated() {
        return wumpusBeated;
    }

    public void setWumpusBeated(boolean wumpusBeated) {
        this.wumpusBeated = wumpusBeated;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner() {
        this.winner = true;
    }

    public Position getActualPosition() {
        return actualPosition;
    }

    public void setActualPosition(Position actualPosition) {
        this.actualPosition = actualPosition;
    }

    public boolean isAlive() {
        return alive;
    }

    public void killedByWumpus() {
        this.alive = false;
    }

    public void fallenIntoDarkness() {
        this.alive = false;
    }

    public boolean isGotMoney() {
        return gotMoney;
    }

    public void setGotMoney(boolean gotMoney) {
        this.gotMoney = gotMoney;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
