package playroom.models;

import playroom.AgeGroup;
import playroom.exceptions.PlayroomException;

public class Doll extends Toy {
    private final String material;

    public Doll(String name, double price, AgeGroup ageGroup, String material) throws PlayroomException {
        super(name, price, ageGroup);
        this.material = material;
    }

    public String getMaterial() { return material; }

    @Override
    public String toString() {
        return String.format("Лялька [%s, Матеріал: %s, Ціна: %.2f, Вік: %s]", getName(), material, getPrice(), getAgeGroup());
    }
}