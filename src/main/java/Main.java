import static java.text.ChoiceFormat.nextDouble;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = "";
        String checklist = "";
        String exit = "завершить";
        double price = 0;
        double sumCh = 0;

        String rub = "";
        int persons = 0;

//begin---------------------------------------------------------------------------------------------
        System.out.println("На сколько человек будем делить счет?");
       // testPersons(persons,scanner);

        boolean testPersons = scanner.hasNextInt();
        if (testPersons) {
            persons = scanner.nextInt();

        } else {
            System.out.println("введите коректное значение больше 1");
            testPersons(persons,scanner);
        }

        while (true) {
            System.out.println("Введите название товара или 'завершить'");
            Scanner scanner1 = new Scanner(System.in);
            name = scanner1.nextLine();
            if (exit.equalsIgnoreCase(name)) {
                break;
            }
            else checklist = checklist + name + "\n";

            System.out.println("Введите стоимость товара");
            Scanner scanner2 = new Scanner(System.in);
            boolean testDouble = scanner2.hasNextDouble();
            if (testDouble) {
                price = scanner2.nextDouble();
                if (price > 0) {
                    sumCh = sumCh + price;
                    System.out.println("продукт добавлен");
                } else

            } else {
                System.out.println("введите корректное и положительное значение");
                testPrice(price,scanner,sumCh);
            }
         }

        System.out.println("Общая сумма покупки: "+sumCh);

        double pieToPerson = sumCh / persons;

       getRub(pieToPerson,rub, checklist);
    }
// end script-------------------------------------------------------------------------------

    public static void getPersons(int persons,Scanner scanner){
        Scanner scanner8 = new Scanner(System.in);

        System.out.println("На сколько человек будем делить счет?");
        persons = scanner8.nextInt();
        while (persons <= 1) {
            System.out.println("Введено некорректное значение, повторите попытку");
            persons = scanner.nextInt();
        }
    }

    static public void testPrice(double price, Scanner scanner, double sumCh) {
        Scanner scanner2 = new Scanner(System.in);
        boolean testDouble = scanner2.hasNextDouble();
        if (testDouble && price >= 0) {
            price = scanner2.nextDouble();
            sumCh=sumCh+price;
            System.out.println("продукт добавлен");
        } else {
            System.out.println("введите корректное и положительное значение");
            testPrice(price,scanner,sumCh);
        }
    }

    static public void testPersons(int persons, Scanner scanner) {
     //   Scanner scanner = new Scanner(System.in);
        boolean testPersons = scanner.hasNextInt();
        if (testPersons && persons > 1) {
            persons = scanner.nextInt();
return;
        } else {
            System.out.println("введите коректное значение больше 1");
            testPersons(persons,scanner);
        }
    }

    static public void testMinus(double price, Scanner scanner, double sumCh) {
       int prc = (int)Math.ceil(price);
        if (prc<0) {
            System.out.println("введите положительное значение");
            price=scanner.nextDouble();
        } else {
            System.out.println("Введите положительное число");
            sumCh = sumCh + price;
            System.out.println("Продукт успешно добавлен в список");
        }
    }

    public static void getRub(double pieToPerson, String rub, String checklist) {
        System.out.println("Добавленные товары:\n" + checklist);
        if (pieToPerson % 100 > 4 && pieToPerson % 100 < 21) {
            rub = "рублей";
        } else if (pieToPerson % 10 == 1) {
            rub = "рубль";
        } else if (pieToPerson % 10 > 1 && pieToPerson % 10 < 5) {
            rub = "рубля";
        } else rub = "рублей";
        System.out.println("Каждый должен внести по " + pieToPerson + " " + rub);// System.out.println("Каждый должен внести по " + String.format("%.2f", pieToPerson) + " " + rub);

    }
    //end class Main
}








