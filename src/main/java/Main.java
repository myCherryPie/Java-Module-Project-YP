import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int persons = 0;

        System.out.println("Введите количество персон");

        getPersons(persons);

        System.out.println("введите название товара или завершить");
        System.out.println("введите цену товара");
        System.out.println("Добавленные товары:");
        System.out.println("Сумма к оплате с человека");
        System.out.println(persons);

    }

    public static void getPersons(int persons) {
        Scanner scanner = new Scanner(System.in);
        testInt(persons);

    }

    public static void testInt(int persons) {
        Scanner scanner = new Scanner(System.in);
        boolean testPersons = scanner.hasNextInt();
        if (testPersons) {
            persons = scanner.nextInt();
            testPositiv(persons,scanner);
        } else {
            System.out.println("введите корректное значение");
            testInt(persons);
        }
    }

    public static void testPositiv(int persons,Scanner scanner){
        while (persons < 2) {
            System.out.println("введите значение больше 1");
            persons = scanner.nextInt();
        }
    }
}