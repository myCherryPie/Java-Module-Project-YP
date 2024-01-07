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
        Scanner scanner = new Scanner(System.in);
        boolean testPersons = scanner.hasNextInt();
        if (testPersons) {
            persons = scanner.nextInt();
            while (persons < 2) {
                System.out.println("введите значение больше 1");
                persons = scan.nextInt();
            }
        } else {
            System.out.println("введите корректное значение");
            testInt(persons);
        }

        getCheck(name,exit,chList,price,summa,persons);

    }
    //конец скрипта---------------------------------------------------------------------------------
    public static void getCheck(String name,String exit,String chList,double price,double summa,int persons){
    Scanner scanName = new Scanner(System.in);
    while (true) {
        System.out.println("введите название товара или завершить");
        name = scanName.nextLine();
        if (exit.equalsIgnoreCase(name)) {
            getItogo(chList,summa,persons);
            return;
        } else {
            chList = chList + name + "\n";
            System.out.println("введите цену товара");
            Scanner scanDouble = new Scanner(System.in);
            boolean testDouble = scanDouble.hasNextDouble();
            if (testDouble) {
                price = scanDouble.nextDouble();
                testPositNum(price,scanDouble);
                summa = summa + price;
                System.out.println("Продукт успешно добавлен в список");
            } else {
                System.out.println("введите корректное значение");
                testDouble(price,summa);
            }

                }
            }
        }

    public static void getItogo(String chList, double summa, int persons){
        double pie = summa/persons;
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

    public static void testDouble(double price,double summa){
        Scanner scanDouble = new Scanner(System.in);
        boolean testDouble = scanDouble.hasNextDouble();
        if (testDouble) {
            price = scanDouble.nextDouble();
            testPositNum(price,scanDouble);
            summa = summa + price;
        } else {
            System.out.println("введите корректное значение");
            testDouble(price,summa);
        }
    }
    public static void testPositNum(double price, Scanner scanDouble){
        while (price < 0) {
            System.out.println("введите значение больше 0");
            price = scanDouble.nextInt();
        }
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

    public static void testPositiv(int persons,Scanner scan){
        while (persons < 2) {
            System.out.println("введите значение больше 1");
            persons = scan.nextInt();
        }
    }
}