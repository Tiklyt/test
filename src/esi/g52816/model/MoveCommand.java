package esi.g52816.model;

/**
 *
 * @author user
 */
public class MoveCommand implements Command {

    private Game _game;
    private Direction _direction;
    private Position _posPlayer;
    private Square _currentSquare;
    private Square _nextSquare;
    private Square _doubleNextSquare;

    /**
     * Allow to create a Move Command
     *
     * @param game the game where the move will be applied
     * @param _direction the direction where the move will be done
     */
    public MoveCommand(Game game, Direction _direction) {
        this._game = game;
        this._posPlayer = new Position(game.getPosPlayer());
        this._direction = _direction;

        Position nextPos = new Position(_posPlayer);
        nextPos.move(_direction.getRow(), _direction.getColumn());

        Position doubleNextPos = new Position(nextPos);
        doubleNextPos.move(_direction.getRow(), _direction.getColumn());
        _currentSquare = new Square(_game.getPlate()[_posPlayer.getX()][_posPlayer.getY()]);
        if(_game.isInside(nextPos)){
            _nextSquare = new Square(_game.getPlate()[nextPos.getX()][nextPos.getY()]);
        }
        if(_game.isInside(doubleNextPos)){
            _doubleNextSquare = new Square(_game.getPlate()[doubleNextPos.getX()][doubleNextPos.getY()]);
        }
       
    }

    
    /**
     * Check the Position of the next's Pos 
     * is inside the Board
     * @return true or false
     */
    public boolean isInside(){
        Position NextPos = new Position(_posPlayer);
        NextPos.move(_direction.getRow(), _direction.getColumn());

        Position doubleNextPos = new Position(NextPos);
        doubleNextPos.move(_direction.getRow(), _direction.getColumn());
        return _game.isInside(NextPos) && _game.isInside(doubleNextPos);
    }
    /**
     * Execute the command
     */
    @Override
    public void execute() {
        _game.move(_direction);
    }

    /**
     * unexecute the command
     */
    @Override
    public void unexecute() {
        Position NextPos = new Position(_posPlayer);
        NextPos.move(_direction.getRow(), _direction.getColumn());

        Position doubleNextPos = new Position(NextPos);
        doubleNextPos.move(_direction.getRow(), _direction.getColumn());

        if (_game.isInside(NextPos) && _game.isInside(doubleNextPos)) {
            _game.getPlate()[_posPlayer.getX()][_posPlayer.getY()] = new Square(_currentSquare);
            _game.getPlate()[NextPos.getX()][NextPos.getY()] = new Square(_nextSquare);
            _game.getPlate()[doubleNextPos.getX()][doubleNextPos.getY()] = new Square(_doubleNextSquare);
            _game.setPosPlayer(new Position(_posPlayer));
        }

    }

    /**
     * check if the command can be executed
     * @return 
     */
    @Override
    public boolean canExecute() {
        return isInside();
    }

}
