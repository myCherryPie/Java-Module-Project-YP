import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int persons = 0;
        String name = "";
        String exit = "завершить";
        String chList = "";
        double price = 0.0;
        double summa = 0.0;

        System.out.println("на скольких человек необходимо разделить счёт?");
        boolean testPersons = false;
        while (!testPersons) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                persons = scanner.nextInt();
            }
            if (persons <= 0) {
                System.out.println("введите корректное значение");
            }
            if (persons == 1) {
                System.out.println("введите корректное значение");
            } else if (persons > 1) {
                testPersons = true;
            }
        }
        getCheck(name, exit, chList, price, summa, persons);
    }

    public static void getCheck(String name, String exit, String chList, double price, double summa, int persons) {

        Product product = new Product(name,price);
        while (!(exit.equalsIgnoreCase(product.name))) {
            System.out.println("введите название товара или завершить");
            boolean testName = false;
            while (!testName) {
                Scanner scanName = new Scanner(System.in);
                product.name = scanName.nextLine();
                product.name = product.name.trim();
                if (product.name.isEmpty()){
                    System.out.println("строка пустая, введите название продукта");
                } else {
                    testName = true;
                }
            }
            if (exit.equalsIgnoreCase(product.name)) {
                getItogo(chList, summa, persons);
                return;
            } else {
                chList = chList + product.name + "\n";

                System.out.println("введите цену товара");
                boolean testDouble = false;
                while (!testDouble) {
                    Scanner scanner = new Scanner(System.in);
                    if (scanner.hasNextDouble()) {
                        product.price = scanner.nextDouble();

                    }
                    if (product.price <= 0) {
                        System.out.println("введите корректное значение");
                    } else if (product.price > 0) {
                        summa += product.price;
                        testDouble = true;
                    }
                }

            }
        }
    }

    public static void getItogo(String chList, double summa, int persons) {
        double pie = summa / persons;
        String rub = "";

        System.out.println("Добавленные товары:\n" + chList);
        if (pie % 100 > 4 && pie % 100 < 21) {
            rub = "рублей";
        } else if (pie % 10 == 1) {
            rub = "рубль";
        } else if (pie % 10 > 1 && pie % 10 < 5) {
            rub = "рубля";
        } else rub = "рублей";
        System.out.println("общая сумма покупки "+summa);
        System.out.println("Каждый должен внести по " + String.format("%.2f", pie) + " " + rub);
    }
}

