package test;

import mastermind.Game;
import mastermind.types.Color;
import org.junit.Before;

import static org.junit.Assert.*;


/**
 * Created by Tomáš Rechtig on 15.11.2016.
 */
public class GameTest {

    private final Game game = new Game();

    @org.junit.Test
    public void checkTest(){
        for (Color color : Color.values()) {
            assertTrue(game.check(color, color));
        }

        assertFalse(game.check(Color.BLACK, Color.WHITE));
    }

    @org.junit.Test
    public void checkIfEndTest(){
        assertTrue(game.checkIfEnd(new int[]{4, 0}));
        assertFalse(game.checkIfEnd(new int[]{0, 0}));
    }

    @org.junit.Test
    public void evaluateGuessTest(){
        //  TEST 1
        Color[] test1Code = new Color[]{Color.YELLOW, Color.GREEN, Color.ORANGE, Color.BLUE};
        Color[] test1Guess = new Color[]{Color.BLUE, Color.GREEN, Color.BLUE, Color.ORANGE};

        //  TEST 2
        Color[] test2Code = new Color[]{Color.RED, Color.BLACK, Color.YELLOW, Color.BLUE};
        Color[] test2Guess = new Color[]{Color.RED, Color.BLACK, Color.YELLOW, Color.BLUE};

        //  TEST 3
        Color[] test3Code = new Color[]{Color.BROWN, Color.WHITE, Color.BLUE, Color.YELLOW};
        Color[] test3Guess = new Color[]{Color.RED, Color.BLACK, Color.YELLOW, Color.BLUE};

        //  TEST 4
        Color[] test4Code = new Color[]{Color.RED, Color.WHITE, Color.BLUE, Color.YELLOW};
        Color[] test4Guess = new Color[]{Color.RED, Color.BLACK, Color.YELLOW, Color.BLUE};

        assertArrayEquals(new int[]{1, 2}, game.evaluateGuess(test1Guess, test1Code));
        assertArrayEquals(new int[]{4, 0}, game.evaluateGuess(test2Guess, test2Code));
        assertArrayEquals(new int[]{0, 2}, game.evaluateGuess(test3Guess, test3Code));
        assertArrayEquals(new int[]{1, 2}, game.evaluateGuess(test4Guess, test4Code));
    }


}
