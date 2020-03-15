
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
    
    public void commandFinder(String command){
        switch(command){
            case "z" : g.moveExecute(Direction.UP);
            break;
            case "d" : g.moveExecute(Direction.RIGHT);
            break;
            case "q" : g.moveExecute(Direction.LEFT);
            break;
            case "s" : g.moveExecute(Direction.DOWN);
            break;
            case "undo" : g.undo();
            break;
            case "redo" : g.redo();
            break;
            case "restart" : g.restart();
            break;
            case "next" : g.nextLevel();
            break;
            case "previous" : g.previousLevel();
            break;
            case "quit" : System.exit(0);
            default: 
        }
    }
    
    public void startGame(){
        v.helpShower();
        v.ShowDungeons();
        v.CurrentLevelShower();
        String command = v.askCommand();
        while(!g.isOver()){
            commandFinder(command);
            v.CurrentLevelShower();
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
