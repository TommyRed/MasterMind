package test;

import mastermind.Game;
import mastermind.types.Color;
import org.junit.Before;

import static org.junit.Assert.*;


/**
 * Created by Tomáš Rechtig on 15.11.2016.
 */
public class GameTest {

    @org.junit.Test
    public void checkTest(){

        Game game = new Game();

        for (Color color : Color.values()) {
            assertTrue(game.check(color, color));
        }

        assertFalse(game.check(Color.BLACK, Color.WHITE));
    }

    @org.junit.Test
    public void checkIfEndTest(){

        Game game = new Game();

        boolean[] trueResult = new boolean[]{true, true, true, true};
        boolean[] falseResult = new boolean[]{true, false, true, false};

        assertTrue(game.checkIfEnd(trueResult));
        assertFalse(game.checkIfEnd(falseResult));
    }

    @org.junit.Test
    public void checkCodeSetup(){

        Game game = new Game();

        Color[] arr = game.setupCode(4);

        assertEquals(Color.RED, arr[0]);
        assertEquals(Color.BLACK, arr[1]);
    }

    @org.junit.Test
    public void evaluateGuessTest(){

        Game game = new Game();

        Color[] code = game.setupCode(4);
        Color[] guess = new Color[]{Color.RED, Color.BLACK, Color.YELLOW, Color.BLUE};

        assertArrayEquals(new boolean[]{true, true, false, true}, game.evaluateGuess(guess, code));
    }


}
