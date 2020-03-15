package esi.g52816.model;

/**
 *
 * @author bilal
 */
public class Position {

    private int x;
    private int y;

    /**
     * Constructor of the Position class for creating the Position of a Square
     *
     * @param row the row of the plate
     * @param column the column of the plate
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructor of copy
     *
     * @param copy the copy that will be "copied"
     */
    public Position(Position copy) {
        this.x = copy.getX();
        this.y = copy.getY();
    }

    /**
     * get the pos X
     *
     * @return int
     */
    public int getX() {
        return x;
    }

    /**
     * get the pos Y
     *
     * @return int
     */
    public int getY() {
        return y;
    }

    /**
     * Move in a delta X and delta Y
     *
     * @param dx dx
     * @param dy dy
     */
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

}
