package org.jm.java.example;

public class DemoCar {
    public static class Car implements AutoCloseable{
        @Override
        public void close(){
            System.out.println("Машина закрывается...");
        }
        public void drive(){
            System.out.println("Машина поехала.");
        }

    }
    public static void main(String... args) {
       try (Car tesla = new Car()) {
           tesla.drive();
       }
       catch (RuntimeException e){

       }

    }



}

