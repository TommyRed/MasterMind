package mastermind;

import mastermind.types.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tomáš Rechtig on 14.11.2016.
 */
public class Game {

    public void startGame(){

        //TODO dynamic choosing
        // Higher the number -> harder the game
        int size = 4;
        int numberOfRounds = 8;

        List<Color[]> prevColors = new ArrayList<>();

        Color[] code = setupCode(size);

        boolean result = play(prevColors, code, 1, numberOfRounds);
    }

    public boolean play(List<Color[]> prevColors, Color[] code, final int round, final int numberOfRounds){



        if (round != numberOfRounds){
            play(prevColors, code, round + 1, numberOfRounds);
        }

        return false;
    }

    public boolean[] evaluateGuess(Color[] guessArr, Color[] codeArr){

        boolean[] result = new boolean[codeArr.length];

        for (int i = 0; i < guessArr.length; i++) {
            result[i] = check(guessArr[i], codeArr[i]);
        }

        return result;
    }

    public Color[] makeGuess(final int size){

        final Color[] guess = new Color[size];

        guess[0] = Color.BLUE;
        guess[1] = Color.BLUE;
        guess[2] = Color.BLUE;
        guess[3] = Color.BLUE;

        return guess;

    }

    public Color[] setupCode(final int size){
        Color[] secretCode = new Color[size];

        secretCode[0] = Color.RED;
        secretCode[1] = Color.BLACK;
        secretCode[2] = Color.GREEN;
        secretCode[3] = Color.BLUE;

        return secretCode;
    }

    /**
     * @param evaluatedGuessArr Array of booleans representing state of guess compared to code
     * @return boolean value representing overall status of game
     */
    public boolean checkIfEnd(boolean[] evaluatedGuessArr){
        for (boolean evaluatedGuess : evaluatedGuessArr) {
            if(!evaluatedGuess) return false;
        }
        return true;
    }

    /**
     * @param guess Guessed color
     * @param code Code color
     * @return bool value of equality
     */
    public boolean check(Color guess, Color code){
        return guess.equals(code);
    }
}
