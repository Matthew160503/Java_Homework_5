import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что один человек может иметь несколько телефонов.
 */
public class PhoneBook{
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        controller();
    }
    private static void controller(){
        Map<String, ArrayList<Integer>> phoneBook = new HashMap<>();
        boolean flag = true;
        while(flag){
            System.out.println("\nФункции телефоннной книги:\n1 - Добавление человека с номером\n"+
        "2 - Добавление дополнительного телефона человеку\n3 - Вывод всей книги\n4 - вывод номера(ов) человека\n"+
        "5 - Выход из телефонной книги");
            System.out.println("\nВведите номер желаемой операции: ");
            int numFunc = sc.nextInt();
            switch (numFunc) {
                case 1:
                    phoneBook = addPerson(phoneBook);
                    break;
                case 2:
                    addNewPhone(phoneBook);
                    break;
                case 3:
                    System.out.println(phoneBook);
                    break;
                case 4:
                    viewPersonPhones(phoneBook);
                    break;
                case 5:
                    flag = false;
                    break;
                default:
                    System.out.println("Произошла ошибка при выборе операции. Повторите выбор!");
                    break;
            }
        }
    }

    private static Map<String, ArrayList<Integer>> addPerson(Map<String, ArrayList<Integer>> phoneBook){
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("\nВведите инициалы человека и номер телефона");
        String person = sc.next();
        int number = sc.nextInt();

        numbers.add(number);
        phoneBook.put(person, numbers);

        return phoneBook; 
    }

    private static Map<String, ArrayList<Integer>> addNewPhone(Map<String, ArrayList<Integer>> phoneBook){
        System.out.println("\nВведите инициалы человека, которому хотите добавить телефон");
        String name = sc.next();
        if(phoneBook.containsKey(name)){
            System.out.println("Введите номер");
            int number = sc.nextInt();
            phoneBook.get(name).add(number);
        }
        else System.out.println("Данный человек не зарегестрирован в книжке"); 
        return phoneBook;
    }

    private static void viewPersonPhones(Map<String, ArrayList<Integer>> phoneBook){
        System.out.println("\nВведите инициалы человека, чьи номера телефонов вывести");
        String name = sc.next();
        if(phoneBook.containsKey(name)){
            System.out.println(phoneBook.get(name));
        }
        else System.out.println("Данный человек не зарегестрирован в книжке");
    }
}