package mastermind.Ai;

import mastermind.domain.Result;
import mastermind.types.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Tomáš Rechtig on 21.11.2016.
 */
public class Ai {

    private List<Result> prevGuess;

    public Ai() {
        this.prevGuess = new ArrayList<>();
    }

    public Color[] makeGuess(Color[] colors) {
        if (prevGuess.isEmpty()) return makeRandomGuess(colors);
        else return prepareGuess(colors);
    }

    private Color[] prepareGuess(Color[] colors){

        int whites = prevGuess.get(prevGuess.size() - 1).getResults()[1];
        int reds = prevGuess.get(prevGuess.size() - 1).getResults()[0];

        if (whites < 1 && reds < 1) return makeRandomGuess(colors);
        else if (reds > 0) {
            System.out.println("#   reds > 0 => make sophisticated guess");
            int randomize = new Random().nextInt(50) + 1;
            if (randomize % 2 == 0){
                // todo dynamic selecting due to size of guess arr
                Color[] arr  = new Color[]{
                        prevGuess.get(prevGuess.size() - 1).getColors()[0],
                        prevGuess.get(prevGuess.size() - 1).getColors()[1],
                        null,
                        null
                };
                return makeRandomGuess(arr);
            } else {
                // todo dynamic selecting due to size of guess arr
                Color[] arr  = new Color[]{
                        null,
                        null,
                        prevGuess.get(prevGuess.size() - 1).getColors()[2],
                        prevGuess.get(prevGuess.size() - 1).getColors()[3],
                };
                return makeRandomGuess(arr);
            }
        }
        return makeRandomGuess(colors);
    }

    private Color[] makeRandomGuess(Color[] colors){
        for (int i = 0; i < colors.length; i++)
            colors[i] = (colors[i] == null) ? Color.values()[new Random().nextInt(Color.values().length)] : colors[i];
        return (colors[colors.length - 1] != null) ? colors : makeRandomGuess(colors);
    }

    public List<Result> getPrevGuess() {
        return prevGuess;
    }

    public void addPrevGuess(Result result) {
        this.prevGuess.add(result);
    }
}
