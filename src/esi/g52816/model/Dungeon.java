package esi.g52816.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author bilal
 */
public class Dungeon { //@srv: trop de méthode public !

    private Square[][] plate;
    private String[] levels; //@srv la gestion/traudction des fichiers doit se faire dans une classe dédiée.
    private int currentLevel;
    private static final int DUNGEONS_LENGTH = 8;

    /**
     * construct a Dungeon
     */
    public Dungeon() {
        plate = new Square[DUNGEONS_LENGTH][DUNGEONS_LENGTH];
        for (int i = 0; i < DUNGEONS_LENGTH; i++) {
            for (int j = 0; j < DUNGEONS_LENGTH; j++) {
                plate[i][j] = new Square();
            }
        }
        DungeonSearcher();
    }

    
    /**
     * load a Dungeon in the game
     *
     * @param level the level number that will be played
     */
    public void DungeonLoader(int level) {
        currentLevel = level;
        String present = levels[level];
        String result = stringCleaner(levels[level]) + " ";
        stringSearcher(result);
    }
    
    /**
     * restart a level
     */
    public void restartLevel() {
        DungeonLoader(currentLevel);
    }


    /**
     * Transform a string into a object
     *
     * @param toSearch the string that will be converted
     */
    private void stringSearcher(String toSearch) { //@srv traduction des fichiers dans un eclasse dédiée: XsbLoader.
        int k = 0;
        Position posPlayer = null;
        for (int i = 0; i < DUNGEONS_LENGTH; i++) {
            for (int j = 0; j < DUNGEONS_LENGTH; j++) {
                switch (toSearch.charAt(k)) {
                    case '+': //@srv: constantes !
                        plate[i][j].changeToPlayer();
                        plate[i][j].changeToStorage();
                        break;
                    case '*':
                        plate[i][j].changeToStorage();
                        plate[i][j].changeToBox();
                        break;
                    case '#':
                        plate[i][j].changeToWall();
                        plate[i][j].changeToVoid();
                        break;
                    case '@':
                        plate[i][j].changeToPlayer();
                        plate[i][j].changeToGround();
                        break;
                    case '$':
                        plate[i][j].changeToBox();
                        plate[i][j].changeToGround();
                        break;
                    case '.':
                        plate[i][j].changeToStorage();
                        plate[i][j].changeToVoid();
                        break;
                    case ' ':
                        plate[i][j].changeToVoidGround();
                        break;
                    default:
                        break;
                }
                k++;
            }
        }
    }

    /**
     * find the Position of the player
     *
     * @return true or false
     */
    public Position playerFinder() { //@srv mieux vautr stocker sa position quelque part
        for (int i = 0; i < plate.length; i++) {
            for (int j = 0; j < plate[i].length; j++) {
                if (plate[i][j].isPlayer()) {
                    return new Position(i, j);
                }
            }
        }
        return null;
    }

    /**
     * Clean a String
     *
     * @param toClean the String that will be cleaned
     * @return new String cleaned
     */
    private String stringCleaner(String toClean) {
        String result = "";
        for (int i = 0; i < toClean.length(); i++) {
            if (toClean.charAt(i) == '+'
                    || toClean.charAt(i) == '*'
                    || toClean.charAt(i) == '#'
                    || toClean.charAt(i) == '$'
                    || toClean.charAt(i) == '.'
                    || toClean.charAt(i) == '@'
                    || toClean.charAt(i) == ' ') {
                result += toClean.charAt(i);
            }
        }
        return result;
    }

    /**
     * read a file of level
     */
    private void DungeonSearcher() {
        String level = "";
        try {
            level = Files.readString(Paths.get("level.txt"));
        } catch (IOException ex) {
        }
        this.levels = level.split(";");
    }

    /**
     * get the current level of the Dungeons
     *
     * @return a int
     */
    public int getCurrentLevel() {
        return currentLevel;
    }

    /**
     * get the plate of the game
     *
     * @return a arrays of arrays of Square
     */
    public Square[][] getPlate() { //@srv JAMAIS retourner un attribut de type tableau ou List (encapsulation).
        return plate;
    }

    /**
     * get the current number level
     *
     * @return a int
     */
    public int getNbLevel() {
        return levels.length;
    }

    /**
     * Check if a Position is Inside the Dungeons
     *
     * @param pos the position
     * @return true or false
     */
    public boolean isInside(Position pos) {
        return pos.getX() >= 0 && pos.getX() < DUNGEONS_LENGTH
                && pos.getY() >= 0 && pos.getY() < DUNGEONS_LENGTH;
    }

    /**
     * Check if in a specific position in the Dungeon is a Wall
     *
     * @param p the position
     * @return true or false
     */
    public boolean isWall(Position p) {
        return plate[p.getX()][p.getY()].isWall();
    }

    /**
     * Check if in a specific position in the Dungeon is a Box
     *
     * @param p the position
     * @return true or false
     */
    public boolean isBox(Position p) {
        return plate[p.getX()][p.getY()].isBox();
    }

    /**
     * Check if in a specific position in the Dungeon is a void ground
     *
     * @param p the Position
     * @return true or false
     */
    public boolean isVoidGround(Position p) {
        return plate[p.getX()][p.getY()].isVoidGround();
    }

    /**
     * Check if in a specific position in the Dungeon is a Storage
     *
     * @param p
     * @return
     */
    public boolean isStorage(Position p) {
        return plate[p.getX()][p.getY()].isStorage();
    }
    
    public boolean isVoid(Position p){
        return plate[p.getX()][p.getY()].isVoid();
    }

    /**
     * Change in a specific position to Box
     *
     * @param p the position in the Dungeon
     */
    public void changeToBox(Position p) {
        plate[p.getX()][p.getY()].changeToBox();
    }

    /**
     * Change in a specific position to Player
     *
     * @param p the position in the Dungeon
     */
    public void changeToPlayer(Position p) {
        plate[p.getX()][p.getY()].changeToPlayer();
    }

    /**
     * Change in a specific position to void ground
     *
     * @param p the position in the Dungeon
     */
    public void changeToVoidGround(Position p) {
        plate[p.getX()][p.getY()].changeToVoidGround();
    }

    /**
     * Change in a specific position to Wall
     *
     * @param p the position in the Dungeon
     */
    public void changeToWall(Position p) {
        plate[p.getX()][p.getY()].changeToWall();
    }

    /**
     * Change in a specific position to void
     *
     * @param p the position in the Dungeon
     */
    public void changeToVoid(Position p) {
        plate[p.getX()][p.getY()].changeToVoid();
    }

}
