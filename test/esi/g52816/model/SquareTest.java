package esi.g52816.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bilal
 */
public class SquareTest {
    


    /**
     * Test of isWall method, of class Square.
     */
    @Test
    public void testIsWall() {
        System.out.println("isWall");
        Square instance = new Square(SquareType.WALL, EntityType.PLAYER);
        boolean expResult = true;
        boolean result = instance.isWall();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsNotWall() {
        System.out.println("isNotWall");
        Square instance = new Square(SquareType.GROUND, EntityType.PLAYER);
        boolean expResult = false;
        boolean result = instance.isWall();
        assertEquals(expResult, result);
    }

    /**
     * Test of isBox method, of class Square.
     */
    @Test
    public void testIsBox() {
        System.out.println("isBox");
        Square instance = new Square(EntityType.BOX);
        boolean expResult = true;
        boolean result = instance.isBox();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isBox method, of class Square.
     */
    @Test
    public void testIsNotBox() {
        System.out.println("isNotBox");
        Square instance = new Square(EntityType.VOID);
        boolean expResult = false;
        boolean result = instance.isBox();
        assertEquals(expResult, result);
    }

    /**
     * Test of isPlayer method, of class Square.
     */
    @Test
    public void testIsPlayer() {
        System.out.println("isPlayer");
        Square instance = new Square(EntityType.PLAYER);
        boolean expResult = true;
        boolean result = instance.isPlayer();
        assertEquals(expResult, result);

    }
    
    @Test
    public void testIsNotPlayer() {
        System.out.println("isNotPlayer");
        Square instance = new Square(EntityType.BOX);
        boolean expResult = false;
        boolean result = instance.isPlayer();
        assertEquals(expResult, result);
    }

    /**
     * Test of isVoidGround method, of class Square.
     */
    @Test
    public void testIsVoidGround() {
        System.out.println("isVoidGround");
        Square instance = new Square(SquareType.GROUND, EntityType.VOID);
        boolean expResult = true;
        boolean result = instance.isVoidGround();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsNotVoidGround() {
        System.out.println("isNotVoidGround");
        Square instance = new Square(SquareType.STORAGE, EntityType.VOID);
        boolean expResult = false;
        boolean result = instance.isVoidGround();
        assertEquals(expResult, result);
    }

    
    /**
     * Test of isStorage method, of class Square.
     */
    @Test
    public void testIsStorage() {
        System.out.println("isStorage");
        Square instance = new Square(SquareType.STORAGE, EntityType.VOID);
        boolean expResult = true;
        boolean result = instance.isStorage();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsNotStorage() {
        System.out.println("isNotStorage");
        Square instance = new Square(SquareType.GROUND, EntityType.VOID);
        boolean expResult = false;
        boolean result = instance.isStorage();
        assertEquals(expResult, result);
    }

    /**
     * Test of changeToBox method, of class Square.
     */
    @Test
    public void testChangeToBox() {
        System.out.println("changeToBox");
        Square instance = new Square(EntityType.PLAYER);
        instance.changeToBox();
        assertTrue(instance.isBox());
    }

    /**
     * Test of changeToPlayer method, of class Square.
     */
    @Test
    public void testChangeToPlayer() {
        System.out.println("changeToPlayer");
        Square instance = new Square(EntityType.BOX);
        instance.changeToPlayer();
        assertTrue(instance.isPlayer());
    }

    /**
     * Test of changeToVoid method, of class Square.
     */
    @Test
    public void testChangeToVoid() {
        System.out.println("changeToVoid");
        Square instance = new Square(SquareType.GROUND, EntityType.PLAYER);
        instance.changeToVoid();
        assertTrue(instance.isVoidGround());
    }

    /**
     * Test of changeToVoidGround method, of class Square.
     */
    @Test
    public void testChangeToVoidGround() {
        System.out.println("changeToVoidGround");
        Square instance = new Square(SquareType.GROUND, EntityType.PLAYER);;
        instance.changeToVoidGround();
        assertTrue(instance.isVoidGround());
    }

    /**
     * Test of changeToWall method, of class Square.
     */
    @Test
    public void testChangeToWall() {
        System.out.println("changeToWall");
        Square instance = new Square(SquareType.STORAGE, EntityType.PLAYER);
        instance.changeToWall();
        assertTrue(instance.isWall());
    }
    
}
