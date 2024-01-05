import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int persons;
        String productName;
        double sumCh = 0;
        String exit = "завершить";
        String checklist = "";


            System.out.println("На сколько человек будем делить счет?"); // определяем количество персон
            persons = scanner.nextInt();
            while (persons <= 1) {
                System.out.println("Введено некорректное значение, повторите попытку");
                persons = scanner.nextInt();
            }


            while (true) {                                                  // запрос названия
                Product product = new Product();
                System.out.println("Введите название товара или 'завершить'");
                product.name = scanner.next();

                if (exit.equalsIgnoreCase(product.name)) {                  // выход из списка
                    break;
                }
                checklist = checklist + product.name+ ", ";

                System.out.println("Введите стоимость товара");             // запрос цены
                product.price = scanner.nextDouble();

                sumCh = sumCh+product.price;                                // общая сумма
                System.out.println("Продукт успешно добавлен в список");


            }
        System.out.println("Полный список покупок: "+checklist);
        System.out.println("Общая сумма покупки равна "+sumCh+"руб., каждый должен внести по "+sumCh/persons+" руб.");




        }
    }

