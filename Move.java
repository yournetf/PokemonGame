public class Move {

    public int typeID;
    public int movePower;
    public int moveAccuracy;
    public String moveName;

    public Move(String moveName, int typeID, int movePower, int moveAccuracy) {
        this.moveName = moveName;
        this.typeID = typeID;
        this.movePower = movePower;
        this.moveAccuracy = moveAccuracy;
    }

    public String getMoveName() {
        return moveName;
    }

    public void setMoveName(String moveName) {
        this.moveName = moveName;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public int getMovePower() {
        return movePower;
    }

    public void setMovePower(int movePower) {
        this.movePower = movePower;
    }

    public int getMoveAccuracy() {
        return moveAccuracy;
    }

    public void setMoveAccuracy(int moveAccuracy) {
        this.moveAccuracy = moveAccuracy;
    }
}
