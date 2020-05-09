package esi.g52816.view;

import esi.g52816.model.Game;
import esi.g52816.model.HistoryMove;
import java.util.Observable;
import java.util.Observer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author braro
 */
public class HistoryView extends TableView<HistoryMove> implements Observer {
    
    private ObservableList<HistoryMove> historyList;
    private final Game game;
    
    public HistoryView(Observable obs) {
        this.historyList = FXCollections.observableArrayList();
        this.game = (Game) obs;
        obs.addObserver(this);
        
        TableColumn<HistoryMove, String> startPos = new TableColumn<>("start pos");
        startPos.setCellValueFactory(new PropertyValueFactory<>("startPosition"));
        
        TableColumn<HistoryMove, String> endPos = new TableColumn<>("end pos");
        endPos.setCellValueFactory(new PropertyValueFactory<>("endPosition"));
        
        TableColumn<HistoryMove, String> boxPushed = new TableColumn<>("box pushed");
        boxPushed.setCellValueFactory(new PropertyValueFactory<>("pushedBox"));
        
        this.getColumns().addAll(startPos, endPos, boxPushed);
        setItems(historyList);
    }
    
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("History");
        historyList = game.getHlist();
        setItems(historyList);
    }
    
}
