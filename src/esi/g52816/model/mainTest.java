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
import esi.g52816.view.InfoView;
import esi.g52816.view.View;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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
        View root = new View(g);
        stage.getIcons().add(new Image("https://image.winudf.com/v2/image1/Y29tLm1vZXJzY2hsaS5taW5pc29rb2Jhbl9pY29uXzE1NTMxNDUxMzhfMDcy/icon.png?w=170&fakeurl=1"));
        BackgroundImage myBI= new BackgroundImage(new Image("https://i.pinimg.com/originals/b8/2f/28/b82f28a7e9c8fcb3868d3d94652c107c.gif",900,630,false,true),
        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
          BackgroundSize.DEFAULT);
        root.setBackground(new Background(myBI));
        Scene scene = new Scene(root, 900, 630,Color.BLACK);
        stage.setResizable(false);
        scene.setOnKeyPressed(new displacementEvent(g));
        stage.setTitle("SOKOBAN");

        //Adding scene to the stage 
        stage.setScene(scene);

        //Displaying the contents of the stage 
        stage.show();
    }

    public static void main(String args[]) {
        launch(args);
    }

}
