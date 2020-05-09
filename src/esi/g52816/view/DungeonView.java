package esi.g52816.view;

import esi.g52816.model.Dungeon;
import esi.g52816.model.Game;
import esi.g52816.model.Position;
import javafx.scene.layout.GridPane;
import java.io.FileNotFoundException;

/**
 *
 * @author braro
 */
public class DungeonView extends GridPane {
    private Dungeon d;
    private Game g;

    public DungeonView(Dungeon d, Game g) throws FileNotFoundException {
        this.d = d;
        this.g = g;
        for (int i = 0; i < d.getPlate().length; i++) {
            for (int j = 0; j < d.getPlate()[0].length; j++) {
                Position position = new Position(i,j);
                SquareView square = new SquareView(d.getPlate()[i][j]);
                this.add(square, j, i);
            }
        }
    }
    
    
    
}
