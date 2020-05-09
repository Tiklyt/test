package esi.g52816.view;

import esi.g52816.model.Game;
import java.util.Observable;
import java.util.Observer;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 *
 * @author braro
 */
public class InfoView extends VBox implements Observer {

    private Game game;
    private Label nbMovement;
    private Label nbStorage;
    private Label nbStorageFull;

    public InfoView(Observable obs) {
        this.game = (Game) obs;
        this.nbMovement = new Label("-");
        this.nbMovement.setTextFill(Color.BLACK);
        this.nbStorage = new Label("-");
        this.nbStorage.setTextFill(Color.BLACK);
        this.nbStorageFull = new Label("-");
        this.nbStorageFull.setTextFill(Color.BLACK);
        game.addObserver(this);
        initialize();
    }

    public void initialize() {
        HBox title = new HBox();
        title.setAlignment(Pos.CENTER);
        title.setSpacing(20);
        title.getChildren().addAll(new Text("nb of mov. "), new Text("nb of storage."),
                new Text("nb of storage full"));
        HBox value = new HBox();
        value.setAlignment(Pos.CENTER);
        value.setSpacing(70);
        value.getChildren().addAll(nbMovement, nbStorage, nbStorageFull);
        this.getChildren().addAll(title, value);
    }

    @Override
    public void update(Observable o, Object arg) {
        nbMovement.setText(String.valueOf(game.getNbMovement()));
        nbStorage.setText(String.valueOf(game.getNbStorage()));
        nbStorageFull.setText(String.valueOf(game.getNbStorageFull()));
    }

}
