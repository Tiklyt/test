package esi.g52816.view;

import esi.g52816.model.EntityType;
import esi.g52816.model.Square;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

/**
 *
 * @author braro
 */
public class SquareView extends StackPane implements Observer {

    private Square square;
    private ImageView groundImage;
    private ImageView entityImage;
    private Group g;

    public SquareView(Observable obs) {
        this.square = (Square) obs;
        settingsFinder();
        g = new Group(groundImage, entityImage);
        groundImage.setFitHeight(40);
        groundImage.setFitWidth(40);
        entityImage.setFitHeight(40);
        entityImage.setFitWidth(40);
        this.square.addObserver(this);
        this.getChildren().add(g);
    }

    private void settingsFinder() {
        try {
            if (square.isWall()) {
                groundImage = new ImageView(new Image(new FileInputStream("src\\wall.png")));
                entityImage = new ImageView(new Image(new FileInputStream("src\\invisible.png")));
            } else if (square.isStorage()) {
                groundImage = new ImageView(new Image(new FileInputStream("src\\storage.png")));
            } else if (square.isGround()) {
                groundImage = new ImageView(new Image(new FileInputStream("src\\ground.png")));
            }

            if (square.isPlayer()) {
                System.out.println("player");
                entityImage = new ImageView(new Image(new FileInputStream("src\\player.png")));
            } else if (square.isVoid()) {
                entityImage = new ImageView(new Image(new FileInputStream("src\\invisible.png")));
            } else if (square.isBox()) {
                entityImage = new ImageView(new Image(new FileInputStream("src\\box.png")));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found !");
        }

        groundImage.setFitHeight(40);
        groundImage.setFitWidth(40);
        entityImage.setFitHeight(40);
        entityImage.setFitWidth(40);

        g = new Group(groundImage, entityImage);
        this.getChildren().clear();
        this.getChildren().add(g);
    }

    @Override
    public void update(Observable o, Object arg) {

            settingsFinder();

    }

}
