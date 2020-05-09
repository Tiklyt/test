package esi.g52816.model;

/**
 *
 * @author braro
 */
public class HistoryMove {

    private String startPosition;
    private String endPosition;
    private String direction;
    private String pushedBox;

    public HistoryMove(Position stPosition, Position edPosition, boolean pushedBox,Direction d) {

        this.startPosition = stPosition.toString();
        this.endPosition = edPosition.toString();
        this.pushedBox = String.valueOf(pushedBox);
        this.direction = d.toString();
    }

    public void setPushedBox(boolean pushedBox) {
        this.pushedBox = String.valueOf(pushedBox);
    }

    public String getStartPosition() {
        return startPosition;
    }

    public String getEndPosition() {
        return endPosition;
    }

    public String getPushedBox() {
        return pushedBox;
    }

    public String getDirection() {
        return direction;
    }

    

}
