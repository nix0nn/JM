package org.jm.java.example;

public class TestExp {
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        m1();
    }

    public static void m1() {
        m2();
    }

    public static void m2(){
        m3();
    }

    public static void  m3(){
        System.out.println(getCallerClassAndMethodName());
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

