package esi.g52816.model;

import java.util.List;

/**
 *
 * @author bilal
 */
public class Game {

    private Dungeon _dungeon;
    private Position _posPlayer;

    public Game(int level) {
        _posPlayer = new Position(1, 5);
        _dungeon = new Dungeon();
        _dungeon.DungeonLoader(level);
    }

    public Square[][] getPlate(){
        return _dungeon.getPlate();
    }
    
    public boolean move(Direction d) {
        Position nextPos = new Position(_posPlayer);
        nextPos.move(d.getRow(), d.getColumn());
        Position doubleNextPos = new Position(nextPos);
        doubleNextPos.move(d.getRow(), d.getColumn());
        if (canPushBox(nextPos, doubleNextPos)) {
            _dungeon.changeToVoid(_posPlayer);
            _dungeon.changeToPlayer(nextPos);
            _dungeon.changeToBox(doubleNextPos);
            _posPlayer = new Position(nextPos);
            return true;
        } else if (_dungeon.isStorage(nextPos)) {
            _dungeon.changeToPlayer(nextPos);
            _dungeon.changeToVoid(_posPlayer);
            _posPlayer = new Position(nextPos);
            return true;
        } else if(_dungeon.isVoidGround(nextPos)){
            _dungeon.changeToPlayer(nextPos);
            _dungeon.changeToVoid(_posPlayer);
            _posPlayer = new Position(nextPos);
        }
        return false;
    }
    
    
    public boolean canPushBox(Position p1,Position p2){
        return _dungeon.isBox(p1)
                && (_dungeon.isVoidGround(p2)
                || _dungeon.isStorage(p2));
    }
    
    public boolean isOver(){
        return true;
    }
}
