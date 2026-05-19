package playroom;

import playroom.exceptions.PlayroomException;
import playroom.models.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Ініціалізація ігрової кімнати ---");

        try {
            Toy[] toyArray = new Toy[] {
                    new Car("Вантажівка", 450.0, AgeGroup.PRESCHOOL, CarSize.MEDIUM),
                    new Car("Спортивний болид", 850.0, AgeGroup.SCHOOL_AGE, CarSize.LARGE),
                    new Doll("Барбі", 600.0, AgeGroup.PRESCHOOL, "Пластик"),
                    new Ball("Футбольний м'яч", 350.0, AgeGroup.SCHOOL_AGE, 22.0),
                    new Blocks("Дерев'яне містечко", 299.9, AgeGroup.TODDLER, 50),
                    new Car("Брязкальце-машинка", 120.0, AgeGroup.TODDLER, CarSize.SMALL)
            };

            Room playroom = new Room(toyArray, 3000.0);

            System.out.println("\nВміст кімнати до сортування:");
            playroom.printToys();
            System.out.printf("Загальна вартість: %.2f грн\n", playroom.calculateTotalCost());

            System.out.println("\n--- Сортування іграшок за збільшенням ціни ---");
            playroom.sortByPrice();
            playroom.printToys();

            double min = 300.0;
            double max = 650.0;
            System.out.printf("\n--- Пошук іграшок у діапазоні цін від %.2f до %.2f ---\n", min, max);
            Toy[] foundToys = playroom.findToysByPriceRange(min, max);
            if (foundToys.length == 0) {
                System.out.println("Іграшок у такому діапазоні не знайдено.");
            } else {
                for (Toy t : foundToys) {
                    System.out.println(t);
                }
            }

            System.out.println("\n--- Тестування обробки винятків (малий бюджет) ---");
            Room brokenRoom = new Room(toyArray, 500.0);

        } catch (PlayroomException e) {
            System.err.println("Помилка бізнес-логіки програми: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Непередбачувана системна помилка: " + e.getMessage());
        }
    }
}