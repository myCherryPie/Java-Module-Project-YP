import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //начало переменных ------------------------------------------------------------------------
        Scanner scan = new Scanner(System.in);
        int persons = 0;
        String name = "";
        String exit = "завершить";
        String chList = "";
        double price = 0.0;
        double summa = 0.0;

        //конец переменных -------------------------------------------------------------------------
        //начало скрипта----------------------------------------------------------------------------

        System.out.println("Введите количество персон ");
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

    //конец скрипта---------------------------------------------------------------------------------
    public static void getCheck(String name, String exit, String chList, double price, double summa, int persons) {
        Scanner scanName = new Scanner(System.in);
        while (!(exit.equalsIgnoreCase(name))) {
            System.out.println("введите название товара или завершить");
            name = scanName.nextLine();
            if (exit.equalsIgnoreCase(name)) {
                getItogo(chList, summa, persons);
                return;
            } else {
                chList = chList + name + "\n";

                System.out.println("введите цену товара");
                boolean testDouble = false;
                while (!testDouble) {
                    Scanner scanner = new Scanner(System.in);
                    if (scanner.hasNextDouble()) {
                        price = scanner.nextDouble();
                        summa += price;
                    }
                    if (price <= 0) {
                        System.out.println("введите корректное значение");
                    } else if (price > 0) {
                        testDouble = true;
                    }
                }

            }
        }
    }

    public static void getItogo(String chList, double summa, int persons) {
        double pie = summa / persons;
        String rub = "";
        System.out.println("кол-во человек " + persons);

        System.out.println("Добавленные товары:\n" + chList);
        if (pie % 100 > 4 && pie % 100 < 21) {
            rub = "рублей";
        } else if (pie % 10 == 1) {
            rub = "рубль";
        } else if (pie % 10 > 1 && pie % 10 < 5) {
            rub = "рубля";
        } else rub = "рублей";
        System.out.println("Каждый должен внести по " + String.format("%.2f", pie) + " " + rub);
    }

    public static void testDouble(double price, double summa) {
        Scanner scanDouble = new Scanner(System.in);
        boolean testDouble = scanDouble.hasNextDouble();
        if (testDouble) {
            price = scanDouble.nextDouble();
            testPositNum(price, scanDouble);
            summa = summa + price;
        } else {
            System.out.println("введите корректное значение");
            testDouble(price, summa);
        }
    }

    public static void testPositNum(double price, Scanner scanDouble) {
        while (price < 0) {
            System.out.println("введите значение больше 0");
            price = scanDouble.nextInt();
        }
    }
}