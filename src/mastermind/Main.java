package mastermind;

import mastermind.Ai.Ai;
import mastermind.types.Color;

/**
 * Created by Tomáš Rechtig on 14.11.2016.
 */
public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        Ai ai = new Ai();

        game.startGame(ai);
    }
}
