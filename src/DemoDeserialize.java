import java.io.*;
import java.rmi.Naming;
import java.util.Arrays;
import java.util.Objects;

public class DemoDeserialize {
    public static void main(String[] args) throws IOException {
        Animal[] animals = {new Animal("cat"), new Animal("dog")};

        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);

            oos.writeInt(animals.length);

            for (Animal animal: animals) {
                oos.writeObject(animal);
            }

            deserializeAnimalArray(oos);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Animal[] deserializeAnimalArray(byte[] data) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);

        try (ObjectInputStream ois = new ObjectInputStream(byteArrayInputStream)) {
            int count = ois.readInt();
            Animal[] animal = new Animal[count];

            for (int i = 0; i < count; i++){
                animal[i] = (Animal) ois.readObject();
                if (!(animal[i].equals(animal[i]))) {
                    throw new IllegalArgumentException();
                }
            }
            return animal;
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    }
    class Animal implements Serializable {
        private final String name;

        public Animal(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Animal) {
                return Objects.equals(name, ((Animal) obj).name);
            }
            return false;
        }
//        @Override
//        public String toString() {
//            return this.name;
//        }
    }
