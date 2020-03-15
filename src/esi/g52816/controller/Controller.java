
package esi.g52816.controller;
import esi.g52816.model.Direction;
import esi.g52816.model.Game;
import esi.g52816.view.View;

/**
 *
 * @author bilal
 */
public class Controller {
    private View v;
    private Game g;

    public Controller(View v, Game g) {
        this.v = v;
        this.g = g;
    }
    
    public void move(String command){
        switch(command){
            case "z" : g.move(Direction.UP);
            break;
            case "d" : g.move(Direction.RIGHT);
            break;
            case "q" : g.move(Direction.LEFT);
            break;
            case "s" : g.move(Direction.DOWN);
            break;
            default: 
        }
    }
    
    public void startGame(){
        String command = v.askCommand();
        while(g.isOver()){
            move(command);
            v.ShowDungeons();
            command = v.askCommand();
        }
    }
    
    public static void main(String[] args) {
        Game Game = new Game(0);
        View v = new View(Game);
        Controller c = new Controller(v, Game);
        c.startGame();
    }
}
