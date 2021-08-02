import java.util.Scanner;


public class Demo {
    public static void main(String[] args){
        // Объявляем текстовые переменные
        String text;
        // Создаем объект типа Scanner
        Scanner in = new Scanner(System.in);
        System.out.println("Input data: ");
        text = in.nextLine();

        int size = text.length();
        char A = text.charAt(0);
        char B = text.charAt(size-1);

        System.out.println("Текст:" + text);
        System.out.println("Символов тексте: " + size);
        System.out.println("Первый символ: " + A);
        System.out.println("Последний символ: " + B);
    }

}
