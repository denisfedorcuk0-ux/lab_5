package playroom.models;

import playroom.AgeGroup;
import playroom.CarSize;
import playroom.exceptions.PlayroomException;

public class Car extends Toy {
    private final CarSize size;

    public Car(String name, double price, AgeGroup ageGroup, CarSize size) throws PlayroomException {
        super(name, price, ageGroup);
        if (size == null) throw new PlayroomException("Розмір машинки має бути вказаний.");
        this.size = size;
    }

    public CarSize getSize() { return size; }

    @Override
    public String toString() {
        return String.format("Машинка [%s, Розмір: %s, Ціна: %.2f, Вік: %s]", getName(), size, getPrice(), getAgeGroup());
    }
}