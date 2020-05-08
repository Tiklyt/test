/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esi.g52816.Events;

import esi.g52816.model.Direction;
import esi.g52816.model.Game;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author braro
 */
public class displacementEvent implements EventHandler<KeyEvent> {

    private Game g;

    public displacementEvent(Game g) {
        this.g = g;
    }

    @Override
    public void handle(KeyEvent t) {

        switch (t.getCode()) {
            case W:
                System.out.println("Handled");
                g.move(Direction.UP);
                break;
            case S:
                System.out.println("Handled");
                g.move(Direction.DOWN);
                break;
            case A:
                System.out.println("Handled");
                g.move(Direction.LEFT);
                break;
            case D:
                System.out.println("Handled");
                g.move(Direction.RIGHT);
                break;
            default:
                break;
        }
    }

}
