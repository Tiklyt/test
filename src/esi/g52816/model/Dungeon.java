package esi.g52816.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author bilal
 */
public class Dungeon {

    private Square[][] plate;
    private String[] levels;
    private static final int DUNGEONS_LENGTH = 8;
    public Dungeon() {
        plate = new Square[DUNGEONS_LENGTH][DUNGEONS_LENGTH];
        DungeonSearcher();
    }

    public void DungeonLoader(int level) {
        String present = levels[level];
        String result = stringCleaner(levels[level]);
        stringSearcher(result);
    }

    private void stringSearcher(String toSearch){
        int k = 0;
        for (int i = 0; i < DUNGEONS_LENGTH; i++) {
            for (int j = 0; j < DUNGEONS_LENGTH; j++) {
                if(toSearch.charAt(k) == '#'){
                    plate[i][j] = new Square(SquareType.WALL, EntityType.VOID);
                } else if(toSearch.charAt(k) == '@'){
                    plate[i][j] = new Square(EntityType.PLAYER);
                } else if(toSearch.charAt(k) == '$'){
                    plate[i][j] = new Square(EntityType.BOX);
                } else if(toSearch.charAt(k) == '.'){
                    plate[i][j] = new Square(SquareType.STORAGE, EntityType.VOID);
                } else if(toSearch.charAt(k) == ' '){
                    plate[i][j] = new Square();
                }
                k++;
            }
        }
    }
    private String stringCleaner(String toClean){
        String result = "";
        for (int i = 0; i < toClean.length(); i++) {
            if (toClean.charAt(i) == '#'
                    || toClean.charAt(i) == '$'
                    || toClean.charAt(i) == '.'
                    || toClean.charAt(i) == '@'
                    || toClean.charAt(i) == ' ') {
                result += toClean.charAt(i);
            }
        }
        return result;
    }
    
    
    public Square[][] getPlate() {
        return plate;
    }
    
    private void DungeonSearcher() {
        String level = "";
        try {
            level = Files.readString(Paths.get("level.txt"));
        } catch (IOException ex) {}
        this.levels = level.split(";");
    }
    
    public boolean isWall(Position p){
        return plate[p.getX()][p.getY()].isWall();
    }
    
    public boolean isBox(Position p){
        return plate[p.getX()][p.getY()].isBox();
    }
    
   public boolean isVoidGround(Position p){
       return plate[p.getX()][p.getY()].isVoidGround();
   }
   
   public boolean isStorage(Position p){
       return plate[p.getX()][p.getY()].isStorage();
   }
   
   public void changeToBox(Position p){
       plate[p.getX()][p.getY()].changeToBox();
   }
   
   public void changeToPlayer(Position p){
       plate[p.getX()][p.getY()].changeToPlayer();
   }
   
   public void changeToVoidGround(Position p){
       plate[p.getX()][p.getY()].changeToVoidGround();
   }
    
   public void changeToWall(Position p){
       plate[p.getX()][p.getY()].changeToWall();
   }
   
   public void changeToVoid(Position p){
       plate[p.getX()][p.getY()].changeToVoid();
   }
    
}
