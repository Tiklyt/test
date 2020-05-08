package esi.g52816.model;

/**
 *
 * @author bilal
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
        System.out.println("DONE");
        Position nextPos = new Position(_posPlayer);
        nextPos.move(_direction.getRow(), _direction.getColumn());

        Position doubleNextPos = new Position(nextPos);
        doubleNextPos.move(_direction.getRow(), _direction.getColumn());

        _currentSquare = new Square(_game.getPlate()[_posPlayer.getX()][_posPlayer.getY()]);

        //_currentSquare.setTypeEntity(_game.getPlate()[_posPlayer.getX()][_posPlayer.getY()].getTypeEntity());
       // _currentSquare.setTypeSquare(_game.getPlate()[_posPlayer.getX()][_posPlayer.getY()].getTypeSquare());

        if (_game.isInside(nextPos)) {
            _nextSquare = new Square(_game.getPlate()[nextPos.getX()][nextPos.getY()]);

            //_nextSquare.setTypeEntity(_game.getPlate()[nextPos.getX()][nextPos.getY()].getTypeEntity());
            //_nextSquare.setTypeSquare(_game.getPlate()[nextPos.getX()][nextPos.getY()].getTypeSquare());
        }
        if (_game.isInside(doubleNextPos)) {
            _doubleNextSquare = new Square(_game.getPlate()[doubleNextPos.getX()][doubleNextPos.getY()]);

            //_doubleNextSquare.setTypeEntity(_game.getPlate()[doubleNextPos.getX()][doubleNextPos.getY()].getTypeEntity());
            //_doubleNextSquare.setTypeSquare(_game.getPlate()[doubleNextPos.getX()][doubleNextPos.getY()].getTypeSquare());
        }

    }

    /**
     * Check the Position of the next's Pos is inside the Board
     *
     * @return true or false
     */
    public boolean isInside() {
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
        System.out.println("DONE");
        _game.move(_direction);
    }

    /**
     * unexecute the command
     */
    @Override
    public void unexecute() {
        System.out.println("UNDONE");
        Position NextPos = new Position(_posPlayer);
        NextPos.move(_direction.getRow(), _direction.getColumn());

        Position doubleNextPos = new Position(NextPos);
        doubleNextPos.move(_direction.getRow(), _direction.getColumn());

        if (_game.isInside(NextPos) && _game.isInside(doubleNextPos)) {

            _game.getPlate()[_posPlayer.getX()][_posPlayer.getY()].setTypeEntity(_currentSquare.getTypeEntity());
            _game.getPlate()[_posPlayer.getX()][_posPlayer.getY()].setTypeSquare(_currentSquare.getTypeSquare());

            _game.getPlate()[NextPos.getX()][NextPos.getY()].setTypeEntity(_nextSquare.getTypeEntity());
            _game.getPlate()[NextPos.getX()][NextPos.getY()].setTypeSquare(_nextSquare.getTypeSquare());

            _game.getPlate()[doubleNextPos.getX()][doubleNextPos.getY()].setTypeEntity(_doubleNextSquare.getTypeEntity());
            _game.getPlate()[doubleNextPos.getX()][doubleNextPos.getY()].setTypeSquare(_doubleNextSquare.getTypeSquare());

            _game.setPosPlayer(new Position(_posPlayer));

        }

    }

    /**
     * check if the command can be executed
     *
     * @return
     */
    @Override
    public boolean canExecute() {
        return isInside();
    }

}
