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

    public SquareView(Observable obs) throws FileNotFoundException {
        this.square = (Square) obs;
        settingsFinder();
        g = new Group(groundImage,entityImage);
        groundImage.setFitHeight(60);
        groundImage.setFitWidth(60);
        entityImage.setFitHeight(60);
        entityImage.setFitWidth(60);
        this.square.addObserver(this);
        this.getChildren().add(g);
    }

    private void settingsFinder() throws FileNotFoundException {
        System.out.println(square.toString());
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
        
        groundImage.setFitHeight(60);
        groundImage.setFitWidth(60);
        entityImage.setFitHeight(60);
        entityImage.setFitWidth(60);
        
        g = new Group(groundImage,entityImage);
        this.getChildren().clear();
        this.getChildren().add(g);
    }

    @Override
    public void update(Observable o, Object arg) {
        try {

            settingsFinder();
            System.out.println("updated");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

}
