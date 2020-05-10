package esi.g52816.view;

import esi.g52816.model.Game;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 * This class represent the view of button with the user can interact with.The
 * user can change the level, restart the level undo or redo an action.
 *
 * @author braro
 */
public class ButtonView extends HBox {

    private Game game;
    private final Button prevLevel;
    private final Button nextLevel;
    private final Button restart;
    private final Button undo;
    private final Button redo;

    /**
     * Allow to create the button view and need the game in parameter
     *
     * @param g the game that will be passed in parameter
     */
    public ButtonView(Game g) {
        this.game = g;
        this.prevLevel = new Button("previous level");
        this.nextLevel = new Button("next level");
        this.restart = new Button("restart");
        this.undo = new Button("undo");
        this.redo = new Button("redo");
        initialize();
        initializeEvent();
    }

    /**
     * Allow to initialize the HBox for adding buttons
     */
    private void initialize() {
        setAlignment(Pos.CENTER);
        setSpacing(20);
        getChildren().addAll(prevLevel, nextLevel, restart, undo, redo);
    }

    /**
     * Allow to handle some events when ever user click on one of these button
     */
    private void initializeEvent() {
        prevLevel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                game.previousLevel();
                System.out.println("CurrentLevel :" + game.getCurrentLevel());
            }
        });
        nextLevel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                game.nextLevel();
                System.out.println("CurrentLevel :" + game.getCurrentLevel());
            }
        });
        restart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                game.restart();
            }
        });
        undo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                game.undo();
            }
        });
        redo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                game.redo();
            }
        });
    }
}
