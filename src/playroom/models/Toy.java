package playroom.models;

import playroom.AgeGroup;
import playroom.exceptions.PlayroomException;

public abstract class Toy {
    private final String name;
    private final double price;
    private final AgeGroup ageGroup;

    public Toy(String name, double price, AgeGroup ageGroup) throws PlayroomException {
        if (name == null || name.trim().isEmpty()) {
            throw new PlayroomException("Назва іграшки не може бути порожньою.");
        }
        if (price < 0) {
            throw new PlayroomException("Вартість іграшки не може бути від'ємною: " + price);
        }
        if (ageGroup == null) {
            throw new PlayroomException("Вікова група має бути вказана.");
        }
        this.name = name;
        this.price = price;
        this.ageGroup = ageGroup;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public AgeGroup getAgeGroup() { return ageGroup; }

    @Override
    public String toString() {
        return String.format("Іграшка{Назва='%s', Ціна=%.2f, Вік=%s}", name, price, ageGroup);
    }
}