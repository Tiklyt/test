package esi.g52816.view;

import esi.g52816.model.Game;
import esi.g52816.model.Square;
import java.util.Scanner;

/**
 *
 * @author bilal
 */
public class View {

    private Scanner in;
    private Game game;

    /**
     * Create a view in depends of it's game
     *
     * @param game the game view
     */
    public View(Game game) {
        in = new Scanner(System.in);
        this.game = game;
    }

    /**
     * Ask a command to the user
     *
     * @return the String that he put
     */
    public String askCommand() {
        return in.nextLine();
    }
    
    
    public void CurrentLevelShower(){
        System.out.println("You are at level : " +game.getCurrentLevel());
    }
    
    public void helpShower(){
        System.out.println("Welcome to the Sokoban of Bilal");
        System.out.println("COMMAND");
        System.out.println("==========");
        System.out.println("z : UP // q : LEFT // d : DOWN // d : RIGHT");
        System.out.println("previous // next (changing level)");
        System.out.println("quit (exit the game) // undo and redo plays");
    }

    /**
     * Show the Dungeons
     */
    public void ShowDungeons() {
        Square[][] a = game.getPlate();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {

                if (a[i][j].isPlayer() && a[i][j].isStorage()) {
                    System.out.print("+");
                } else if (a[i][j].isBox() && a[i][j].isStorage()) {
                    System.out.print("*");
                } else if (a[i][j].isBox()) {
                    System.out.print("$");
                } else if (a[i][j].isStorage()) {
                    System.out.print(".");
                } else if (a[i][j].isWall()) {
                    System.out.print("#");
                } else if (a[i][j].isPlayer()) {
                    System.out.print("@");
                } else if (a[i][j].isVoidGround()) {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }

}
