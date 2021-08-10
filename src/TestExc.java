public class TestExc {

    public static void main(String[] args) {

    }

    public static String getCallerClassAndMethodName() {
        StackTraceElement[] elements = new Exception().getStackTrace();
        if (elements.length < 3 ) {
            return null;
        } else {
            return elements[2].getClassName()+"#"+elements[2].getMethodName();
        }
    }

}



