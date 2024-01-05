import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int persons;
        String productName;
        double sumCh = 0;
        String exit = "завершить";


            System.out.println("На сколько человек будем делить счет?"); // определяем количество персон
            persons = scanner.nextInt();
            while (persons <= 1) {
                System.out.println("Введено некорректное значение, повторите попытку");
                persons = scanner.nextInt();
            }


            while (true) {                                                  // запрос названия, цены, подсчет суммы
                Product product = new Product();
                System.out.println("Введите название товара или 'завершить'");
                product.name = scanner.next();
                if (exit.equalsIgnoreCase(product.name)) {
                    break;
                }
                System.out.println("Введите стоимость товара");
                product.price = scanner.nextDouble();
                sumCh = sumCh+product.price;
                System.out.println("Продукт успешно добавлен в список");


            }
        System.out.println("Подводим итог");
        System.out.println(sumCh/persons);



        }
    }

