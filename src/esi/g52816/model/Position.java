package esi.g52816.model;

/**
 *
 * @author bilal
 */
public class Position {

    private int _x;
    private int _y;

    /**
     * Constructor of the Position class for creating the Position of a Square
     *
     * @param row the row of the plate
     * @param column the column of the plate
     */
    public Position(int x, int y) {
        this._x = x;
        this._y = y;
    }

    /**
     * Constructor of copy
     *
     * @param copy the copy that will be "copied"
     */
    public Position(Position copy) {
        this._x = copy.getX();
        this._y = copy.getY();
    }

    /**
     * get the pos X
     *
     * @return int
     */
    public int getX() {
        return _x;
    }

    /**
     * get the pos Y
     *
     * @return int
     */
    public int getY() {
        return _y;
    }

    /**
     * Move in a delta X and delta Y
     *
     * @param dx dx
     * @param dy dy
     */
    public void move(int dx, int dy) {
        _x += dx;
        _y += dy;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this._x;
        hash = 97 * hash + this._y;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Position other = (Position) obj;
        if (this._x != other._x) {
            return false;
        }
        if (this._y != other._y) {
            return false;
        }
        return true;
    }

}
