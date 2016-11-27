package mastermind.domain;

import mastermind.types.Color;

/**
 * Created by Tomáš Rechtig on 21.11.2016.
 */
public class Result {

    private final Color[] colors;
    private final int[] results;

    public Result(final Color[] colors, final int[] results){
        this.colors = colors;
        this.results = results;
    }

    public Color[] getColors() {
        return colors;
    }

    public int[] getResults() {
        return results;
    }
}
