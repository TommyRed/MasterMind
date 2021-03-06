package mastermind;

import mastermind.Ai.Ai;
import mastermind.domain.Result;
import mastermind.types.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Tomáš Rechtig on 14.11.2016.
 */
public class Game {

    public void startGame(){
        startGame(null);
    }

    public void startGame(Ai ai){

        boolean result = (ai == null)
                ? play(new ArrayList<>(), setupCode(4), 1, 8)
                : play(new ArrayList<>(), setupCode(4), 1, 8000, ai);

        if (result) print("You won");
        else print("You lost");
    }

    private boolean play(List<Color[]> prevGuess, Color[] code, final int round, final int numberOfRounds) {

        print("Round " + round);

        Color[] guess = makeGuess(code.length);

        prevGuess.add(guess);

        int[] result = evaluateGuess(guess, code);

        print("Place and Color guessed : " + result[0] + "\n Color but not place guessed : " +  result[1]);

        if (checkIfEnd(result)) return true;
        else if (round <= numberOfRounds)
            play(prevGuess, code, round + 1, numberOfRounds);
        return false;
    }

    private boolean play(List<Color[]> prevGuess, Color[] code, final int round, final int numberOfRounds, Ai ai) {

        print("\nRound " + round);

        Color[] guess = ai.makeGuess(new Color[code.length]);

        int[] result = evaluateGuess(guess, code);

        ai.addPrevGuess(new Result(guess, result));

        print("    Place and Color guessed : " + result[0] + "\n    Color but not place guessed : " +  result[1]);

        if (checkIfEnd(result)) return true;
        else if (round < numberOfRounds)
            play(prevGuess, code, round + 1, numberOfRounds, ai);
        return false;
    }

    public Color[] makeGuess(final int size){

        print("Make a guess");

        final Color[] guess = new Color[size];

        for (int i = 0; i < guess.length; i++)
            guess[i] = getColor();

        return guess;

    }

    public Color[] setupCode(final int size){

        print("Setup your code");

        Color[] secretCode = new Color[size];

        for (int i = 0; i < secretCode.length; i++)
            secretCode[i] = getColor();

        print("Code set up");

        return secretCode;
    }

    public int[] evaluateGuess(Color[] guessArr, Color[] codeArr){

        int red = 0, white = 0;
        boolean[] codeUsed = new boolean[guessArr.length];
        boolean[] guessUsed = new boolean[guessArr.length];

        for (int i = 0; i < guessArr.length; i++){
            if (check(guessArr[i], codeArr[i])){
                red++;
                codeUsed[i] = guessUsed[i] = true;
            }
        }

        for (int i = 0; i < codeArr.length; i++) {
            for (int j = 0; j < guessArr.length; j++) {
                if (!codeUsed[i] && !guessUsed[j] && check(guessArr[i], codeArr[j])){
                    white++;
                    codeUsed[i] = guessUsed[j] = true;
                    break;
                }
            }
        }

        return new int[]{red, white};
    }


    public boolean checkIfEnd(int[] evaluatedGuessArr){
        return evaluatedGuessArr[0] == 4;
    }

    public boolean check(Color guess, Color code){
        return guess.equals(code);
    }

    /*
     *  UI stuff
     */

    private void print(String text){
        System.out.println(text);
    }

    private Color getColor(){
        for (int i = 0; i < Color.values().length; i++)
            System.out.println(i + ") " + Color.values()[i].getColor());

        int input = new Scanner(System.in).nextInt();

        if (input > -1 && input < Color.values().length) return Color.values()[input];

        System.out.println("Invalid input");
        return getColor();
    }

    private void printArr(Color[] arr){
        for (Color color : arr) {
            System.out.print(" " + color.getColor());
        }
    }
}
