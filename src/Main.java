import java.util.*;
import java.nio.*;
import java.io.*;


public class Main {
    public static void main(String[] args) {
        double result = 0;
        Scanner in = new Scanner(System.in);
        String str;

        while (in.hasNextLine()) {
            str = in.nextLine();
            if (str.isEmpty()) {
                break;
            }
            for (String str2: str.split(" ")) {
                if (isDouble(str2)) {
                    result += Double.parseDouble(str2);
                }
            }
        }
        System.out.printf("%.6f", result);
    }

    public static boolean isDouble(String str) throws NumberFormatException {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
