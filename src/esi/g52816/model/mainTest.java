/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esi.g52816.model;

import esi.g52816.Events.displacementEvent;
import esi.g52816.view.ButtonView;
import esi.g52816.view.DungeonView;
import esi.g52816.view.HistoryView;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author braro
 */
public class mainTest extends Application {

    private Game g = new Game(3);
    private Dungeon d = g.getDungeons();

    @Override
    public void start(Stage stage) throws FileNotFoundException {
        System.out.println("LOL");
        DungeonView dungeonView = new DungeonView(d, g);
        ButtonView buttonView = new ButtonView(g);
        HistoryView historyView = new HistoryView(g);
        VBox vbox = new VBox();
        vbox.getChildren().addAll(dungeonView, buttonView);

        HBox root = new HBox();
        root.setSpacing(10);
        root.setPadding(new Insets(15, 20, 10, 10));

        root.getChildren().addAll(vbox, historyView);
        //Creating a scene object 
        Scene scene = new Scene(root, 1000, 700);
        scene.setOnKeyPressed(new displacementEvent(g));

        //Setting title to the Stage 
        stage.setTitle("Loading an image");

        //Adding scene to the stage 
        stage.setScene(scene);

        //Displaying the contents of the stage 
        stage.show();
    }

    public static void main(String args[]) {
        launch(args);
    }

}
