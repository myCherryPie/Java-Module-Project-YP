import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int persons;

            System.out.println("На сколько человек будем делить счет?");
            persons = scanner.nextInt();

            while (persons <= 1) {
                System.out.println("Введено некорректное значение, повторите попытку");
                persons = scanner.nextInt();
            }

        }
    }
