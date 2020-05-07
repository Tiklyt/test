package esi.g52816.view;

import esi.g52816.Observer.Observable;
import esi.g52816.Observer.Observer;

import esi.g52816.model.Square;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

    public void SquareView(Observable obs) throws FileNotFoundException {
        this.square = (Square) obs;
        settingsFinder();

    }

    private void settingsFinder() throws FileNotFoundException {
        if (square.isBox()) {
            entityImage = new ImageView(new Image(new FileInputStream("src\\box.png")));
        } else if (square.isPlayer()) {
            entityImage = new ImageView(new Image(new FileInputStream("src\\player.png")));
        }

        if (square.isStorage()) {
            groundImage = new ImageView(new Image(new FileInputStream("src\\storage.png")));
        } else if (square.isWall()) {
            groundImage = new ImageView(new Image(new FileInputStream("src\\wall.png")));
        } else {
            groundImage = new ImageView(new Image(new FileInputStream("src\\ground.png")));
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        try {
            settingsFinder();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

}
