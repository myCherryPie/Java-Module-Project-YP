import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int persons = 0;
        String name = "";
        String checklist = "";
        String exit = "завершить";
        double price = 0;
        double sumCh = 0;
        double pieToPerson = sumCh / persons;
        String rub = "";
        String num = "";

        System.out.println("На сколько человек будем делить счет?");
        persons = scanner.nextInt();
        while (persons <= 1) {
            System.out.println("Введено некорректное значение, повторите попытку");
            persons = scanner.nextInt();
        }

        while (true) {
            getName(name, checklist, exit);
            if (exit.equalsIgnoreCase(name)) {                  // выход из списка
                break;
            }
            checklist = checklist + name + "\n";
            getPrice(scanner,price,sumCh,num);
        }
        getRub(pieToPerson,rub, checklist);



    }


    public static void getName(String name, String checklist, String exit) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название товара или 'завершить'");
        name = scanner.nextLine();

    }

    public static void getPrice(Scanner scanner, double price, double sumCh, String num) {                  //цена
        System.out.println("Введите стоимость товара");
        testDouble(price);
        sumCh = sumCh + price;
        System.out.println("Продукт успешно добавлен в список");
        }
    static public void testDouble(double price) {
        Scanner scan = new Scanner(System.in);
        boolean testDouble = scan.hasNextDouble();
        if (testDouble) {
            price = scan.nextDouble();
        } else {
            System.out.println("введите коректное значение");
            testDouble(price);
        }
    }


    public static void getRub(double pieToPerson, String rub, String checklist) {
        System.out.println("Добавленные товары:\n" + checklist);
        System.out.println("Каждый должен внести по " + String.format("%.2f", pieToPerson) + " " + rub);
        if (pieToPerson % 100 > 4 && pieToPerson % 100 < 21) {
            rub = "рублей";
        } else if (pieToPerson % 10 == 1) {
            rub = "рубль";
        } else if (pieToPerson % 10 > 1 && pieToPerson % 10 < 5) {
            rub = "рубля";
        } else rub = "рублей";
    }
}








