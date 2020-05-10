package esi.g52816.Events;

import esi.g52816.model.Direction;
import esi.g52816.model.Game;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author braro
 */
public class displacementEvent implements EventHandler<KeyEvent> {

    private final Game g;

    public displacementEvent(Game g) {
        this.g = g;
    }

    @Override
    public void handle(KeyEvent t) {

        switch (t.getCode()) {
            case W:
                g.moveExecute(Direction.UP);
                break;
            case S:
                g.moveExecute(Direction.DOWN);
                break;
            case A:
                g.moveExecute(Direction.LEFT);
                break;
            case D:
                g.moveExecute(Direction.RIGHT);
                break;
            default:
                break;
        }
    }

}
