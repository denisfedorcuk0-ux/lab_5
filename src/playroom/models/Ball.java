package playroom.models;

import playroom.AgeGroup;
import playroom.exceptions.PlayroomException;

public class Ball extends Toy {
    private final double diameter;

    public Ball(String name, double price, AgeGroup ageGroup, double diameter) throws PlayroomException {
        super(name, price, ageGroup);
        if (diameter <= 0) throw new PlayroomException("Діаметр м'яча повинен бути більшим за 0.");
        this.diameter = diameter;
    }

    public double getDiameter() { return diameter; }

    @Override
    public String toString() {
        return String.format("М'яч [%s, Діаметр: %.1f см, Ціна: %.2f, Вік: %s]", getName(), diameter, getPrice(), getAgeGroup());
    }
}