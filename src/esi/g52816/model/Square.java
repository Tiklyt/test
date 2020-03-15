package esi.g52816.model;

/**
 *
 * @author bilal
 */
public class Square {

    private SquareType _typeSquare;
    private EntityType _typeEntity;

    /**
     * Create a default Square with a ground SquareType and a void typeEntity
     */
    public Square() {
        this._typeSquare = SquareType.GROUND;
        this._typeEntity = EntityType.VOID;
    }

    public Square(Square square) {
        this._typeSquare = square._typeSquare;
        this._typeEntity = square._typeEntity;
    }

    /**
     * Create a Square with parameter
     *
     * @param typeEntity the Entity that will be added to the Object
     */
    public Square(EntityType typeEntity) {
        this._typeSquare = SquareType.GROUND;
        this._typeEntity = typeEntity;
    }
    /**
     * Create a Square with 2 parameter
     *
     * @param typeSquare the TypeSquare
     * @param typeEntity the TypeEntity
     */
    public Square(SquareType typeSquare, EntityType typeEntity) {
        this._typeSquare = typeSquare;
        this._typeEntity = typeEntity;
    }

    /**
     * check if the square is a wall
     *
     * @return true or false
     */
    public boolean isWall() {
        return _typeSquare == SquareType.WALL;
    }

    /**
     * check if the square contains a box
     *
     * @return true or false
     */
    public boolean isBox() {
        return _typeEntity == EntityType.BOX;
    }

    /**
     * check if the square contains the Players
     *
     * @return true or false
     */
    public boolean isPlayer() {
        return _typeEntity == EntityType.PLAYER;
    }

    /**
     * check if the square is void and Ground
     *
     * @return
     */
    public boolean isVoidGround() {
        return _typeEntity == EntityType.VOID && _typeSquare == SquareType.GROUND;
    }

    /**
     * Check if the square is a Storage
     *
     * @return true or false
     */
    public boolean isStorage() {
        return _typeSquare == SquareType.STORAGE;
    }

    /**
     * Change to a Box
     */
    public void changeToBox() {
        _typeEntity = EntityType.BOX;
    }

    /**
     * Change to a player
     */
    public void changeToPlayer() {
        _typeEntity = EntityType.PLAYER;
    }

    /**
     * Change to a void
     */
    public void changeToVoid() {
        _typeEntity = EntityType.VOID;
    }

    /**
     * Change to a void Ground
     */
    public void changeToVoidGround() {
        _typeEntity = EntityType.VOID;
        _typeSquare = SquareType.GROUND;
    }

    /**
     * Change to a Wall
     */
    public void changeToWall() {
        _typeSquare = SquareType.WALL;
        _typeEntity = EntityType.VOID;
    }

}
