public class Humans {

    public static void main(String[] args) {
        Human human1 = new Human();
        Human human2 = new Human((byte)36, "Name", "sName", "fSport");
        Human human3 = new Human((byte)37, "Name2", "sName2");
    }

    public static class Human {
        private byte age;
        private String name, secondName, favoriteSport;


        public  Human(){
        }
        public Human(byte age, String name, String secondName, String favoriteSport){
            this.age = age;
            this.name = name;
            this.secondName = secondName;
            this.favoriteSport = favoriteSport;
        }
        public Human(byte age, String name, String secondName){
            this.age = age;
            this.name = name;
            this.secondName = secondName;
        }

    }

}
