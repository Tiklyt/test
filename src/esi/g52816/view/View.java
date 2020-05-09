package esi.g52816.view;

import esi.g52816.model.Game;
import java.util.Observable;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author bilal
 */
public class View extends HBox {

    private DungeonView dungeonView;
    private HistoryView historyView;
    private InfoView infoView;
    private ButtonView buttonView;
    private Game game;

    public View(Observable obs){
        this.game = (Game) obs;
        this.dungeonView = new DungeonView(game.getDungeons(), game);
        this.infoView = new InfoView(game);
        this.historyView = new HistoryView(game);
        this.buttonView = new ButtonView(game);
        initialize();
    }
    
    
    public void initialize(){
        historyView.autosize();
        setPadding(new Insets(30));
        setSpacing(50);
        
        VBox subRoot = new VBox();
        subRoot.setSpacing(15);
        subRoot.getChildren().addAll(dungeonView,buttonView,infoView);
        this.getChildren().addAll(subRoot,historyView);
    }
}
