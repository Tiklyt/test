package esi.g52816.model;

import java.util.Observable;

/**
 *
 * @author bilal
 */
public class Square extends Observable {

    private SquareType _typeSquare;
    private EntityType _typeEntity;

    /**
     * Create a default Square with a ground SquareType and a void typeEntity
     */
    public Square() {
        this._typeSquare = SquareType.GROUND;
        this._typeEntity = EntityType.VOID;
    }

    /**
     * Constructor allowing to do defensive copy with another Square
     *
     * @param square the square that will be copied
     */
    public Square(Square square) {
        this._typeSquare = square._typeSquare;
        this._typeEntity = square._typeEntity;
    }

    public Square(SquareType _typeSquare, EntityType _typeEntity) {
        this._typeSquare = _typeSquare;
        this._typeEntity = _typeEntity;
    }
    
    
    

    /**
     * Allow to get entity type from the class
     *
     * @return the EntityType
     */
    public EntityType getTypeEntity() {
        return _typeEntity;
    }

    /**
     * Allow to get the type Square from the class
     *
     * @return the Square Type
     */
    public SquareType getTypeSquare() {
        return _typeSquare;
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
     * Check if the entityType is Void
     *
     * @return true or false
     */
    public boolean isVoid() {
        return _typeEntity == EntityType.VOID;
    }

    /**
     * Check if the typeSquare is a ground
     *
     * @return true or false
     */
    public boolean isGround() {
        return _typeSquare == SquareType.GROUND;
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
     * Allow to change the type entity to the new Entity type received in
     * parameter
     *
     * @param _typeEntity the entity type that will be copied.
     */
    public void setTypeEntity(EntityType _typeEntity) {
        this._typeEntity = _typeEntity;
        setChanged();
        notifyObservers();
    }

    /**
     * Allow to change the type square to the new Square type receive din
     * parameter
     *
     * @param _typeSquare
     */
    public void setTypeSquare(SquareType _typeSquare) {
        this._typeSquare = _typeSquare;
        setChanged();
        notifyObservers();
    }

    /**
     * Change to a Box
     */
    public void changeToBox() {
        _typeEntity = EntityType.BOX;
        setChanged();
        notifyObservers();
    }

    /**
     * Change to a player
     */
    public void changeToPlayer() {
        _typeEntity = EntityType.PLAYER;
        setChanged();
        notifyObservers();
    }

    /**
     * Change to a void
     */
    public void changeToVoid() {
        _typeEntity = EntityType.VOID;
        setChanged();
        notifyObservers();
    }

    public void changeToGround() {
        _typeSquare = SquareType.GROUND;
        setChanged();
        notifyObservers();
    }

    /**
     * Change to a void Ground
     */
    public void changeToVoidGround() {
        _typeEntity = EntityType.VOID;
        _typeSquare = SquareType.GROUND;
        setChanged();
        notifyObservers();
    }

    /**
     * Change to a Wall
     */
    public void changeToWall() {
        _typeSquare = SquareType.WALL;
        _typeEntity = EntityType.VOID;
        setChanged();
        notifyObservers();
    }

    /**
     * Change to storage
     */
    public void changeToStorage() {
        _typeSquare = SquareType.STORAGE;
        setChanged();
        notifyObservers();
    }
}
