package esi.g52816.model;

import java.util.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author bilal
 */
public class Game extends Observable {

    private Dungeon _dungeon; //|srv: en Java pas de _
    private Position _posPlayer;
    private int _nbMovement = 0;
    private int _nbStorage = 0;
    private int _nbStorageFull = 0;

    private UndoManager _undoManager = new UndoManager();
    private ObservableList<HistoryMove> hlist;

    /**
     * Create a game in a level
     *
     * @param level the level where start
     */
    public Game(int level) {
        _dungeon = new Dungeon();
        _dungeon.DungeonLoader(level);
        _posPlayer = _dungeon.playerFinder();
        _nbStorage = _dungeon.StorageFinder();
        hlist = FXCollections.observableArrayList();
    }

    public ObservableList<HistoryMove> getHlist() {
        return hlist;
    }

    public int getNbMovement() {
        return _nbMovement;
    }

    public int getNbStorage() {
        return _nbStorage;
    }

    public int getNbStorageFull() {
        return _nbStorageFull;
    }

    
    
    
    /**
     * Allow to execute a Move if the command can be done.
     *
     * @param d the direction of the Move
     */
    public void moveExecute(Direction d) {

        Command c = new MoveCommand(this, d);

        if (c.canExecute()) {
            _undoManager.doIt(new MoveCommand(this, d));
        }
    }

    /**
     * Move the Player in a specific direction
     *
     * @param d the direction where the Player will be done
     * @return true or false if done or not
     */
    public boolean move(Direction d) {

        Position nextPos = new Position(_posPlayer);
        nextPos.move(d.getRow(), d.getColumn());
        HistoryMove historyMove = new HistoryMove(new Position(_posPlayer), new Position(nextPos), false);
        Position doubleNextPos = new Position(nextPos);
        doubleNextPos.move(d.getRow(), d.getColumn());

        if (canPushBox(nextPos, doubleNextPos)) {
            System.out.println("moved1");
            _dungeon.changeToVoid(_posPlayer);
            _dungeon.changeToPlayer(nextPos);
            _dungeon.changeToBox(doubleNextPos);
            _posPlayer = new Position(nextPos);
            historyMove.setPushedBox(true);
            hlist.add(historyMove);
            if (_dungeon.isStorage(doubleNextPos)) {
                incNbStorageFulled();
            }
            setChanged();
            notifyObservers();
            return true;
        } else if (_dungeon.isVoidGround(nextPos)) {
            System.out.println("moved3");
            _dungeon.changeToPlayer(nextPos);
            _dungeon.changeToVoid(_posPlayer);
            _posPlayer = new Position(nextPos);
            hlist.add(historyMove);
            setChanged();
            notifyObservers();
            return true;
        } else if (_dungeon.isStorage(nextPos) && _dungeon.isVoid(nextPos)) {
            _dungeon.changeToPlayer(nextPos);
            _dungeon.changeToVoid(_posPlayer);
            _posPlayer = new Position(nextPos);
            hlist.add(historyMove);
            setChanged();
            notifyObservers();
            return true;
        }
        return false;
    }

    public void incNbStorageFulled() {
        _nbStorageFull++;
        setChanged();
        notifyObservers();
    }

    public void incNbMovement() {
        _nbMovement++;
        setChanged();
        notifyObservers();
    }

    public void decNbMovement() {
        if (_nbMovement > 0) {
            _nbMovement--;
        }
        setChanged();
        notifyObservers();
    }

    public Dungeon getDungeons() {
        return _dungeon;
    }

    /**
     * Allow to undo a action
     */
    public void undo() {
        _undoManager.undo();
    }

    /**
     * Allow to redo a action
     */
    public void redo() {
        _undoManager.redo();
    }

    /**
     * check if a Position isInside the Dungeons
     *
     * @param p the position p
     * @return true or false
     */
    public boolean isInside(Position p) {
        return _dungeon.isInside(p);
    }

    /**
     * Check if the Player can push the box
     *
     * @param p1 the Position front of the player
     * @param p2 the Position front of front of the player
     * @return true or false
     */
    public boolean canPushBox(Position p1, Position p2) { //@srv: ce serait parfait si ceci se trouvait dans une classe Box, pareil pour le joueur.
        //@srv: Box.canMove(...) box.move(...), player.canMove(...), player.move(...)
        return _dungeon.isBox(p1)
                && (_dungeon.isVoidGround(p2)
                || (_dungeon.isStorage(p2) && _dungeon.isVoid(p2)));
    }

    /**
     * check if dungeons is over
     *
     * @return true or false
     */
    public boolean isOver() {
        for (int i = 0; i < _dungeon.getPlate().length; i++) {
            for (int j = 0; j < _dungeon.getPlate().length; j++) {
                if (!_dungeon.getPlate()[i][j].isBox()
                        && _dungeon.getPlate()[i][j].isStorage()) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * allow to back to the previous level
     *
     * @return true if done , false if not
     */
    public boolean previousLevel() {
        if (_dungeon.getCurrentLevel() > 0) {
            _dungeon.DungeonLoader(_dungeon.getCurrentLevel() - 1);
            _posPlayer = _dungeon.playerFinder();
            _undoManager = new UndoManager();
            return true;
        }
        return false;
    }

    /**
     * Allow to play the next Level
     *
     * @return true if done, false if not
     */
    public boolean nextLevel() {
        if (_dungeon.getCurrentLevel() + 1 < _dungeon.getNbLevel() - 1) {
            _dungeon.DungeonLoader(_dungeon.getCurrentLevel() + 1);
            _posPlayer = _dungeon.playerFinder();
            _undoManager = new UndoManager();
            return true;
        }
        return false;
    }

    /**
     * Restart the current level
     */
    public void restart() {
        _dungeon.restartLevel();
        _undoManager = new UndoManager();
        _posPlayer = _dungeon.playerFinder();
    }

    /**
     * get the current position of the player
     *
     * @return a position
     */
    public Position getPosPlayer() {
        return _posPlayer;
    }

    /**
     * get the plate of the Dungeons
     *
     * @return a arrays of arrays of Square
     */
    public Square[][] getPlate() {
        return _dungeon.getPlate();
    }

    /**
     * get the current level of dungeons
     *
     * @return a int
     */
    public int getCurrentLevel() {
        return _dungeon.getCurrentLevel();
    }

    /**
     * set the position of the Player
     *
     * @param pos the position where the player will be
     */
    public void setPosPlayer(Position pos) {
        _posPlayer = new Position(pos);
    }
}
