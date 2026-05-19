package playroom;

import playroom.exceptions.PlayroomException;
import playroom.models.Toy;
import java.util.Arrays;
import java.util.Comparator;

public class Room {
    private final Toy[] toys;

    public Room(Toy[] toys, double budgetLimit) throws PlayroomException {
        if (toys == null || toys.length == 0) {
            throw new PlayroomException("Кімната не може бути порожньою.");
        }

        double totalCost = 0;
        for (Toy toy : toys) {
            if (toy != null) {
                totalCost += toy.getPrice();
            }
        }

        if (totalCost > budgetLimit) {
            throw new PlayroomException(String.format("Перевищено ліміт бюджету! Загальна вартість: %.2f, Ліміт: %.2f", totalCost, budgetLimit));
        }

        this.toys = toys;
    }

    public void sortByPrice() {
        Arrays.sort(toys, Comparator.comparingDouble(Toy::getPrice));
    }

    public Toy[] findToysByPriceRange(double minPrice, double maxPrice) throws PlayroomException {
        if (minPrice > maxPrice) {
            throw new PlayroomException("Мінімальна межа діапазону не може бути більшою за максимальну.");
        }

        return Arrays.stream(toys)
                .filter(toy -> toy.getPrice() >= minPrice && toy.getPrice() <= maxPrice)
                .toArray(Toy[]::new);
    }

    public double calculateTotalCost() {
        double sum = 0;
        for (Toy toy : toys) {
            sum += toy.getPrice();
        }
        return sum;
    }

    public void printToys() {
        for (Toy toy : toys) {
            System.out.println(toy);
        }
    }
}