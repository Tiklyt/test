package esi.g52816.view;

import esi.g52816.model.Game;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
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

    public void initialize() {
        setAlignment(Pos.CENTER);
        setSpacing(20);
        getChildren().addAll(prevLevel, nextLevel, restart, undo, redo);
    }

    public void initializeEvent() {
        prevLevel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                game.previousLevel();
            }
        });
        nextLevel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                game.nextLevel();
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
