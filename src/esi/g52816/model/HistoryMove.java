package esi.g52816.model;

/**
 *
 * @author braro
 */
public class HistoryMove {

    private String startPosition;
    private String endPosition;
    private String pushedBox;

    public HistoryMove(Position stPosition, Position edPosition, boolean pushedBox) {

        this.startPosition = stPosition.toString();
        this.endPosition = edPosition.toString();
        this.pushedBox = String.valueOf(pushedBox);
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

    

}
