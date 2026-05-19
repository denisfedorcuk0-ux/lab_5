package playroom.models;

import playroom.AgeGroup;
import playroom.exceptions.PlayroomException;

public class Blocks extends Toy {
    private final int piecesCount;

    public Blocks(String name, double price, AgeGroup ageGroup, int piecesCount) throws PlayroomException {
        super(name, price, ageGroup);
        if (piecesCount <= 0) throw new PlayroomException("Кількість кубиків має бути більшою за 0.");
        this.piecesCount = piecesCount;
    }

    public int getPiecesCount() { return piecesCount; }

    @Override
    public String toString() {
        return String.format("Кубики [%s, Елементів: %d, Ціна: %.2f, Вік: %s]", getName(), piecesCount, getPrice(), getAgeGroup());
    }
}