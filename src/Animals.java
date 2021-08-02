public class Animals {

    public static void main(String[] args){
        new Cat().sayHello();
        new Dog().sayHello();
        new Dog().catchCat(new Cat());

    }

    public static class Cat{
        public void sayHello(){
            System.out.println("Мяу!");
        }
    }
    public static class Dog{
        public void sayHello(){
            System.out.println("Гав!");
        }
        public void catchCat(Cat cat){
            System.out.println("Кошка поймана");
            sayHello();
            cat.sayHello();

        }
    }
}
