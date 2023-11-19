import java.sql.SQLOutput;

public class ColorDecorator extends FootballFormDecorator {
    private String color;

    public ColorDecorator(FootballStrategy decoratedStrategy, String color) {
        super(decoratedStrategy);
        this.color = color;
    }

    public void execute() {
        decoratedStrategy.execute();
        System.out.println(" The color of team form is " + color);
    }

    public String getColor() {
        return color;
    }
}
