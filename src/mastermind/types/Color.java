package mastermind.types;

/**
 * Created by Tomáš Rechtig on 14.11.2016.
 */
public enum Color {
    WHITE("White"),
    RED("Red"),
    BLUE("Blue"),
    GREEN("Green"),
    BLACK("Black"),
    BROWN("Brown"),
    YELLOW("Yellow"),
    ORANGE("Orange");

    private final String color;

    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
