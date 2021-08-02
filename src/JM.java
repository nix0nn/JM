import java.lang.Math;
import java.math.BigInteger;
import java.util.Arrays;
import java.lang.CharSequence;
public class JM {

    public static void main(String[] args){

    }


    public static class AsciiCharSequence implements java.lang.CharSequence {
        private byte[] arrbytes;

        public AsciiCharSequence(byte[] arrbytes) {
            this.arrbytes = arrbytes;
        }

        @Override
        public int length() {
            return arrbytes.length;
        }

        @Override
        public char charAt(int index) {
            return (char) arrbytes[index];
        }

        @Override
        public java.lang.CharSequence subSequence(int start, int end) {
            return new AsciiCharSequence(java.util.Arrays.copyOfRange(arrbytes, start, end));
        }

        public String toString() {
            return new String(arrbytes);
        }

//        public interface CharSequence {
//            int length();
//
//            char charAt(int index);
//
//            CharSequence subSequence(int start, int end);
//
//            String toString();
//        }
    }


    public static char charExpression(int a) {
        return (char) ('\\' + a);
    }

    public static int[] mergeArrays(int[] a1, int[] a2) {
        int sizearr = 0;
        sizearr = a1.length + a2.length;

        int[] arr = new int[sizearr];
        int i = 0;
        int j = 0;

        if (a1.length == 0){
            return a2;
        }
        if (a2.length == 0){
            return a1;
        }

        while (i < a1.length && j < a2.length){
            if (a1[i] <= a2[j]) {
                arr[i+j] = a1[i];
                i++;
                if (i == a1.length) {
//                    System.arraycopy(a2, j, arr, i + j, a2.length - j);
                    for (; j < a2.length; j++) {
                        arr[i + j] = a2[j];
                    }
                }
            } else {
                arr[i+j] = a2[j];
                j++;
                if (j == a2.length){
//                    System.arraycopy(a1, i, arr, i + j, a1.length - i);
                    for (; i<a1.length; i++){
                        arr[i+j] = a1[i];
                    }
                }
            }
        }
        return arr;
    }
    public static String printTextPerRole(String[] roles, String[] textLines){
        int i = 0;
        StringBuilder str = new StringBuilder();
        for (String role: roles){
            str.append(role);
            str.append(':');
            str.append("\n");
            for (String text: textLines){
                i++;
                if (text.startsWith(role + ":")){
                    str.append(i);
                    str.append(")");
                    str.append(text.substring(role.length() + 2));
                    str.append("\n");
                }

            }
             i = 0;
            str.append("\n");
        }
        return str.toString();
    }

    public static void printOddNumbers(int[] arr){
        StringBuilder str = new StringBuilder();
        if (arr.length == 0){
            return;
        }
        for(int i = 0; i < arr.length; i++){
            if (arr[i] % 2 != 0){
                str.append(arr[i]);
                str.append(",");
            }
        }
        str.deleteCharAt(str.length()-1);
        System.out.println(str.toString());
    }
    public int[] evenArray(int number){
        int[] arr = new int[number / 2];
        for (int i = 2, k = 0; i < number+1; i += 2){
            arr[k++] = i;
        }
        return arr;
    }

    // factorial (iterraor)
    public static BigInteger factorial(int value) {
        BigInteger result = BigInteger.valueOf(1);
        for (int i = 1; i<value; i++){
            result = result.multiply(BigInteger.valueOf(i+1));
        }
        return result;
    }
    // factorial (recursion)
//    public static BigInteger factorialRe(int value){
//        if (value == 0){
//            return BigInteger.valueOf(1);
//        } else{
//            return value * (factorialRe(value - 1)));
//        }
//    }

    public static boolean mirrorText(String text){
        text = text.replaceAll("[^a-zA-Z0-9]", "");
        StringBuffer a = new StringBuffer(text);
        a = a.reverse();
        if(text.equalsIgnoreCase(a.toString())){
            return true;
        } else {
            return false;
        }
    }
    public static void zeroArrays(){
        Arrays[] arr = {};
    }

    public static boolean isPowerOfTwo(int a){
        a = Integer.bitCount(Math.abs(a));
        if (a == 1) {
            return true;
        } else return false;
    }

//    public static boolean isPowerOfTwo(int value) {
//        Integer.bitCount(Math.abs(value));
//        return true;
//    }

    public static void isText(){
        String text = "A";
        text = 'A' + "12";
        System.out.printf(text);
    }
}
